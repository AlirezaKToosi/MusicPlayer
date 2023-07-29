package com.novare.musicPlayer.utils;

public class Song {
    private String name;
    private String artist;
    private String album;
    private String genre;
    private String fileName;
    private String albumImage;

    public Song(String name, String artist, String album, String genre, String fileName, String albumImage) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.fileName = fileName;
        this.albumImage = albumImage;
    }
    public String getByKey(String key) {
        String result = "";

        switch (key) {
            case "name" -> result = name;
            case "artist" -> result = artist;
            case "album" -> result = album;
            case "genre" -> result = genre;
            default -> System.out.println("🚨 ERROR INVALID KEY" + key); // Refactor throw error instead
        }

        return result;
    }
    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public String getFileName() {
        return fileName;
    }

    public String getAlbumImage() {
        return albumImage;
    }

}
