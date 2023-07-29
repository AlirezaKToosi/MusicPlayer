package com.novare.musicPlayer.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class playSoundManager {
    static Desktop desktop = Desktop.getDesktop();
    static File albumDefaultFile = new File("assets/no-picture.png");

    public static void openMedia(Song song) throws IOException {
        String songFile = song.getFileName();
        String pictureFile = song.getAlbumImage();

        playSong(songFile);
        viewAlbum(pictureFile);
    }

    private static void playSong(String songFile) throws IOException {
        File soundFile = new File("assets/songs/" + songFile);

        if(soundFile.exists()) {
            desktop.open(soundFile);
        }
        else {
            throw new IOException();
        }
    }

    private static void viewAlbum(String pictureFile) throws IOException {
        File albumFile = new File("assets/albums/" + pictureFile);

        if(albumFile.exists()) {
            desktop.open(albumFile);
        }
        else {
            desktop.open(albumDefaultFile);
        }
    }
}
