package com.novare.musicPlayer.mainMenu;

import com.novare.musicPlayer.filterMenu.FilterMenu;
import com.novare.musicPlayer.searchMenu.SearchMenu;
import com.novare.musicPlayer.songMenu.SongMenu;
import com.novare.musicPlayer.utils.ReadFile;
import com.novare.musicPlayer.utils.Song;

import java.util.List;

public class MainMenuModel {
    private final List<String> menuOptions = List.of("Songs", "Artists", "Albums", "Genres", "Search");
    private final List<Song> songs = ReadFile.getSong();

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> new SongMenu(songs);
            case 2 -> new FilterMenu(songs, "artist");
            case 3 -> new FilterMenu(songs, "album");
            case 4 -> new FilterMenu(songs, "genre");
            case 5 -> new SearchMenu(songs);
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
