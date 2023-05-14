import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    /**
     * It defines the main path of data text file which contains all information about songs
     */
    private static final String DATA_FILE_PATH = "assets/data.txt";
    /**
     * It defines the path of songs files
     */
    private static final String MUSIC_FOLDER_PATH = "assets/songs/";
    /**
     * It defines the path of albums logo files
     */
    private static final String IMAGE_FOLDER_PATH = "assets/albums/";
    /**
     * It defines the path of logo of songs without album logo
     */
    private static final String PLACEHOLDER_IMAGE_PATH = "assets/no-picture.png";
    private static Scanner scanner = new Scanner(System.in);
    /**
     * This is a list of songs object which gathered from data file
     */
    private static ArrayList<Song> songs = new ArrayList<Song>();
    /**
     * List of unique artists
     */
    private static ArrayList<String> artists;
    /**
     * List of unique albums
     */
    private static ArrayList<String> albums;
    /**
     * List of unique genres
     */
    private static ArrayList<String> genres;

    /**
     * Start point of project with running two methods of loadSongs() and showMainMenu()
     */
    public static void main(String[] args) {
        loadSongs();
        showMainMenu();
    }

    /**
     * load data.txt and read the data from that then creat song object from each row and
     * insert it in songs list
     */
    private static void loadSongs() {
        try {
            File file = new File(DATA_FILE_PATH);
            Scanner fileScanner = new Scanner(file);
            Set<String> artistsList=new HashSet<String>();
            Set<String> albumsList=new HashSet<String>();
            Set<String> genresList=new HashSet<String>();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                if (data.length == 6) {
                    String name = data[0];
                    String artist = data[1];
                    String album = data[2];
                    String genre = data[3];
                    String fileName = data[4];
                    String imagePath = IMAGE_FOLDER_PATH + data[5];

                    Song song = new Song(name, artist, album, genre, fileName, imagePath);
                    songs.add(song);

                    artistsList.add(artist);

                    albumsList.add(album);

                    genresList.add(genre);
                }
            }
            artists=new ArrayList<>(artistsList);
            Collections.sort(artists);
            albums=new ArrayList<>(albumsList);
            Collections.sort(albums);
            genres=new ArrayList<>(genresList);
            Collections.sort(genres);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find data file");
        }
    }

    /**
     * show 6 different choice for user and let run appropriate method base on user choice
     */
    private static void showMainMenu() {
        while (true) {
            System.out.println("Welcome to the Spotifoo music player!");
            System.out.println();
            System.out.println("Main Menu options:");
            System.out.println("[1] Songs");
            System.out.println("[2] Artists");
            System.out.println("[3] Albums");
            System.out.println("[4] Genres");
            System.out.println("[5] Search");
            System.out.println("[0] Exit");

            int choice = getChoice(0, 5);

            switch (choice) {
                case 1:
                    playSongMenu();
                    break;
                case 2:
                    filterByArtist();
                    break;
                case 3:
                    filterByAlbum();
                    break;
                case 4:
                    filterByGenre();
                    break;
                case 5:
                    searchSongs();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * @param lowerBound lowest integer number in choice interval
     * @param upperBound highest integer number in choice interval
     * @return user choice number
     *
     *In this method get the input number from the user and check it for being in the correct
     * interval and return user choice
     * this method have appropriate not valid choice
     */
    public static int getChoice(int lowerBound, int upperBound) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Choose an option and press enter: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < lowerBound || choice > upperBound) {
                    System.out.println("Not a valid option. Please enter a number between " + lowerBound + " and " + upperBound + ".");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid option. Please enter a number between " + lowerBound + " and " + upperBound + ".");
            }
        }
        return choice;
    }

    /**
     * In this method shows all the songs information and lets user choose one of
     * them for playing
     */
    private static void playSongMenu() {
        System.out.println("Songs menu for playing:");
        int index = 1;

        for (Song song : songs) {
            System.out.println("["+index + "] " + song.getName());
            index++;
        }
        System.out.println("[0] Back to main menu");

        int choice = getChoice(0, songs.size());
        if (choice==0) {
            return;
        }
        else {
            Song song = songs.get(choice - 1);
            playSong(song);
        }
    }

    /**
     * @param songs List of the songs that show to user for selecting and playing
     * it is overloading of playSongMenu() with list of selected song
     * it is usable when user filter song based various factors such
     *  as artist,album,genre or search
     */
    private static void playSongMenu(List<Song> songs) {
        System.out.println("Songs menu for playing:");
        int index = 1;

        for (Song song : songs) {
            System.out.println("["+index + "] " + song.getName());
            index++;
        }
        System.out.println("[0] Back to main menu");

        int choice = getChoice(0, songs.size());
        if (choice==0) {
            showMainMenu();
        }
        else {
            Song song = songs.get(choice - 1);
            playSong(song);
        }
    }

    /**
     * @param song the specific song object that wants to play with default desktop
     *             music-player
     *  In this method play a selected song and show album image with default app
     *  handel incorrect files and show no image for song without album image
     */
    private static void playSong(Song song) {
        try {
            File file = new File(MUSIC_FOLDER_PATH + song.getFileName());
            if (file.exists()) {
                System.out.println("Playing file!");
                Desktop.getDesktop().open(file);
                File imageFile = new File(song.getAlbumImage());

                if (imageFile.exists()) {
                    Desktop.getDesktop().open(imageFile);
                } else {
                    Desktop.getDesktop().open(new File(PLACEHOLDER_IMAGE_PATH));
                }
            } else {
                System.out.println("Could not play the song. Music file does not exist.");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error playing song");
        }
    }

    /**
     * Show list of Artists and let user choose one of them and then show
     * songs of that artist for choosing and playing
     */
    private static void filterByArtist() {
        int index = showOptions(artists);
        String selectedArtist = artists.get(index - 1);
        List<Song> songList = getSongsByArtist(selectedArtist);
        System.out.println("Songs by " + selectedArtist + ":");
        playSongMenu(songList);
    }

    /**
     * @param options list of String data which contains specific information
     * @return  user choice and return to main menu if user select 0
     */
    private static int showOptions(List<String> options) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > options.size()) {
            System.out.println("Choose an option:");
            for (int i = 0; i < options.size(); i++) {
                System.out.println("["+(i+1)+"] "+ options.get(i));
            }
            System.out.println("[0] Back to main menu");
            choice = getChoice(0, options.size());
        }
        if (choice==0) {
            showMainMenu();
            return 0;
        }
        else
            return choice;
    }

    /**
     * @param artist name of valid artist
     * @return List of the song of that artist
     */
    private static List<Song> getSongsByArtist(String artist) {
        List<Song> songsList = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtist().equals(artist)) {
                songsList.add(song);
            }
        }

        return songsList;
    }

    /**
     * Show list of albums and let user choose one of them and then show
     * songs of that album for choosing and playing
     */
    private static void filterByAlbum() {
        int index = showOptions(albums);
        String selectedAlbum = albums.get(index - 1);
        List<Song> songList = getSongsByAlbum(selectedAlbum);
        System.out.println("Songs in " + selectedAlbum + " album:");
        playSongMenu(songList);
    }

    /**
     * @param albumName name of valid album
     * @return List of the songs of that album
     */
    private static List<Song> getSongsByAlbum(String albumName) {
        List<Song> songsList = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().equals(albumName)) {
                songsList.add(song);
            }
        }
        return songsList;
    }

    /**
     * Show list of genres and let user choose one of them and then show
     * songs of that genre for choosing and playing
     */
    private static void filterByGenre() {
        int index = showOptions(genres);
        String selectedGenre = genres.get(index - 1);
        List<Song> songList = getSongsByGenre(selectedGenre);
        System.out.println("Songs in " + selectedGenre + " genre :");
        playSongMenu(songList);
    }

    /**
     * @param genreName name of valid genre
     * @return List of the songs of that genre
     */
    private static List<Song> getSongsByGenre(String genreName) {
        List<Song> songsList = new ArrayList<>();
        for (Song song : songs) {
            if (song.getGenre().equalsIgnoreCase(genreName)) {
                songsList.add(song);
            }
        }
        return songsList;
    }

    /**
     * Show list of songs that are match with user input text and
     * let user for choosing and playing that song
     */
    private static void searchSongs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write the name of a song and press enter: ");
        String searchTerm = scanner.nextLine();
        List<Song> matchingSongs = getMatchingSongs(searchTerm);
        if (matchingSongs.isEmpty()) {
            System.out.println("No results found related to " +searchTerm);
            return;
        } else {
            System.out.println("Songs that contain " + searchTerm + " in their names :");
            playSongMenu(matchingSongs);
        }
    }

    /**
     * @param searchTerm input text for searching among songs name
     * @return List of matched songs
     * it is not case-sensitive
     * and find song with part or exact match with searchTerm
     */
    private static List<Song> getMatchingSongs(String searchTerm) {
        List<Song> matchingSongs = new ArrayList<Song>();
        for (Song song : songs) {
            if (song.getName().toLowerCase().contains(searchTerm)) {
                matchingSongs.add(song);
            }
        }
        return matchingSongs;
    }
}