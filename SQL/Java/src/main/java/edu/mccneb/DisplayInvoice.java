package edu.mccneb;

import java.sql.*;

public class DisplayInvoice {
    private int[] Playlist;
    public DisplayInvoice(int[] PassedPlaylist){
        Playlist = PassedPlaylist;
    }
    public void Display()
    {
        String sql = "Select trackid, Tracks.Name, artists.Name as Artist, unitprice from tracks " +
                "inner join albums on albums.AlbumId = tracks.AlbumId " +
                "inner join artists on albums.ArtistId = artists.ArtistId "+
                "WHERE Tracks.trackid IN(";
        for(int i=0; i<Playlist.length;i++)
        {
            sql+= Playlist[i];
            if(i<99)
                sql+=",";
        }
        sql+= ")  order by trackid " +
                "limit 20;";


        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            System.out.println();
            double TotalPrice;
            while (rs.next()) {
                System.out.println(rs.getInt("TrackID") +  "\t" +
                        rs.getString("Name")+"\t"+
                        rs.getString("Artist")+"\t"+
                        rs.getDouble("UnitPrice"));
            }
            GetTotal(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void GetTotal(String sql)
    {
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            System.out.println();
            double TotalPrice=0;
            while (rs.next()) {
                TotalPrice+=rs.getDouble("UnitPrice");
            }
            System.out.printf("The Total purchase invoice is $%.2f%n",TotalPrice);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



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
}
