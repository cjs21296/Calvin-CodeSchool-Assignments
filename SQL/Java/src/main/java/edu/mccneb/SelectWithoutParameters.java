package edu.mccneb;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    /**
     *
     * @author sqlitetutorial.net
     */
    public class SelectWithoutParameters {

        /**
         * Connect to the test.db database
         * @return the Connection object
         */
        private Connection connect() {
            // SQLite connection string
            String url = "jdbc:sqlite:C:/Users/gotta/OneDrive/Documents/Code School/SQLWeek/sql-jdbc/chinook.db";
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }


        /**
         * select all rows in the warehouses table
         */
        public void selectAll(){
            String sql = "SELECT artistid, name FROM artists";

            try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){

                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getInt("artistid") +  "\t" +
                            rs.getString("name"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            SelectWithoutParameters app = new SelectWithoutParameters();
            app.popularQuery();
        }

        public void doQuery() {
            String sql = "SELECT tracks.TrackId, tracks.Name as 'Track', albums.AlbumId, artists.Name as 'Artist' " +
                    "FROM tracks " +
                    "INNER JOIN albums ON albums.AlbumId = tracks.AlbumId " +
                    "INNER JOIN artists ON albums.ArtistId = artists.ArtistId";
            try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){

                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getInt("TrackId") +  "\t" +
                            rs.getString("Track"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        public void popularQuery() {

            //the sql should actually be: SELECT InvoiceId, invoice_items.TrackId, tracks.GenreID, genres.Name, count(genres.Name) as Count
            //FROM invoice_items
            //INNER JOIN tracks ON tracks.TrackId = invoice_items.TrackId
            //INNER JOIN genres ON genres.GenreID = tracks.GenreID
            //Group by genres.Name
            //Order by Count
            //;
            //but we wanted to try it this way
            String sql = "SELECT InvoiceId, invoice_items.TrackId, tracks.GenreID, genres.Name " +
                    "FROM invoice_items " +
                    "INNER JOIN tracks ON tracks.TrackId = invoice_items.TrackId " +
                    "INNER JOIN genres ON genres.GenreID = tracks.GenreID ";
            int[] genreCount = new int[25];
            String[] genreType = {"Rock","Jazz",
                    "Metal",
                    "Alternative & Punk",
                    "Rock And Roll",
                    "Blues",
                    "Latin",
                    "Reggae",
                    "Pop",
                    "Soundtrack",
                    "Bossa Nova",
                    "Easy Listening",
                    "Heavy Metal",
                    "R&B/Soul",
                    "Electronica/Dance",
                    "World",
                    "Hip Hop/Rap",
                    "Science Fiction",
                    "TV Shows",
                    "Sci Fi & Fantasy",
                    "Drama",
                    "Comedy",
                    "Alternative",
                    "Classical",
                    "Opera"};
            try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){

                // loop through the result set
                while (rs.next()) {
                    genreCount[(rs.getInt("GenreId") - 1)]++;
                }
                int max = 0;
                for (int i = 0; i < 25; i++) {
                    if (genreCount[i] > genreCount[max]) {
                        max = i;
                    }
                }
                System.out.println("The highest selling genre was " + genreType[max] + " with this many tracks sold: " + genreCount[max]);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void DisplayTracks()
        {

        }


}
