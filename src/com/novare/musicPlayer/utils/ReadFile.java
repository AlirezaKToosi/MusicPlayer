package com.novare.musicPlayer.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private static Scanner scanner;
    private static List<Song> song;

    public ReadFile(String path) {
        File file = new File(path);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find data file");
            throw new RuntimeException(e);
        }
        song = generateSongList();
    }

    public static List<Song> getSong() {
        return song;
    }

    private List<Song> generateSongList() {
        List<Song> song = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            List<String> listOfFields = List.of(line.split(","));
            String name = listOfFields.get(0);
            String artist = listOfFields.get(1);
            String album = listOfFields.get(2);
            String genre = listOfFields.get(3);
            String soundFile = listOfFields.get(4);
            String albumFile = listOfFields.get(5);
            Song newSong = new Song(name, artist, album, genre, soundFile, albumFile);
            song.add(newSong);
        }

        return song;
    }
}

