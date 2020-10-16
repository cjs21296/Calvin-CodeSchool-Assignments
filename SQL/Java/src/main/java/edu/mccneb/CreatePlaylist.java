package edu.mccneb;

import java.sql.*;

public class CreatePlaylist {
    private int[] Playlist;
    public CreatePlaylist()
    {
        Playlist = new int[100];
        for(int i=0;i<100;i++){Playlist[i]=0;}
    }
    public int[] Add()
    {
        int s;
        int count=0;
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
}
