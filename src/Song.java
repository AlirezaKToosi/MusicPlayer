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
