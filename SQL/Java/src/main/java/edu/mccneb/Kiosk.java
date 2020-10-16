package edu.mccneb;
import java.sql.*;

public class Kiosk {
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
    private int[] Playlist;
    public static void main(String[] args) {
        Boolean DisplayType = true;
        //Display type variable chooses between doing assignment with/without classes
        //or in other words, all in the Kiosk Calss, with methods
        //or all in the classes
        if(DisplayType) {
            Kiosk kiosk = new Kiosk();
            kiosk.DisplayTracksWithClass();
            kiosk.AddTracksToPlaylistWithClass();
            kiosk.DisplayInvoiceWithClass();
        }
        else {
        Kiosk app = new Kiosk();
        int[] Playlist;
        app.DisplayTracks();
        Playlist = app.AddTracksToPlaylist();
        app.DisplayInvoice(Playlist);
        }
    }
    public void DisplayTracks()
    {
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
    public void DisplayTracksWithClass()
    {
        DisplayAllTracks DAT = new DisplayAllTracks();
        DAT.Display();
    }
    public int[] AddTracksToPlaylist()
    {
        int s;
        int count=0;
        int[] Playlist = new int[100];
        for(int i=0;i<100;i++){Playlist[i]=0;}
        System.out.println();
        System.out.println("Add tracks to playlist by entering TrackID number, Enter 0 to quit");
        System.out.println("Limit of 100 tracks per playlist per purchase order");
        System.out.println();
        do
        {
            s = Console.getInt("Enter TrackID to add to playlist: ");
            Playlist[count]=s;
            count++;
        }while (s!=0 && count <100);
        return Playlist;
    }
    public void AddTracksToPlaylistWithClass()
    {
        CreatePlaylist CPL = new CreatePlaylist();
        Playlist = CPL.Add();
    }
    public void DisplayInvoice(int[] Playlist)
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
    public void DisplayInvoiceWithClass()
    {
        DisplayInvoice DI = new DisplayInvoice(Playlist);
        DI.Display();
    }
    public void GetTotal(String sql)
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
}
