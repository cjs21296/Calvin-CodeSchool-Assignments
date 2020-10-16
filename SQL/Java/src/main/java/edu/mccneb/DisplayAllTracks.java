package edu.mccneb;

import java.sql.*;

public class DisplayAllTracks {
    public DisplayAllTracks(){}
    private Connection connect() {
        // SQLite connection string
        Connection conn = null;
        String url = "jdbc:sqlite:C:/Users/cjs21/GIT/Group Submission/Week4/SQL/chinook.db";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void Display() {
        String sql = "Select trackid, Tracks.Name, artists.Name as Artist, unitprice from tracks " +
                "inner join albums on albums.AlbumId = tracks.AlbumId " +
                "inner join artists on albums.ArtistId = artists.ArtistId " +
                "order by trackid " +
                "limit 20;";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("TrackID") +  "\t" +
                        rs.getString("Name")+"\t"+
                        rs.getString("Artist")+"\t"+
                        rs.getDouble("UnitPrice"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }

}
