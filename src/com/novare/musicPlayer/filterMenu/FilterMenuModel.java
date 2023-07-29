package com.novare.musicPlayer.filterMenu;

import com.novare.musicPlayer.mainMenu.MainMenu;
import com.novare.musicPlayer.songMenu.SongMenu;
import com.novare.musicPlayer.utils.Song;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class FilterMenuModel {
    private final String selectedKey;
    private final List<Song> songs;
    private final List<String> menuOptions;

    public FilterMenuModel(List<Song> songs, String selectedKey) {
        this.selectedKey = selectedKey;
        this.songs = songs;
        this.menuOptions = createMenuOptions();
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) {
        if (selectedOption == 0) {
            new MainMenu();
        }

        List<Song> selectedSongs = filterSongsByOption(selectedOption);

        new SongMenu(selectedSongs);
    }

    private List<String> createMenuOptions() {
        List<String> repeatedMenuOptions = songs.stream().map(item -> item.getByKey(selectedKey)).toList();
        List<String> uniqueMenuOptions = new ArrayList<>(new HashSet<>(repeatedMenuOptions));
        return uniqueMenuOptions.stream().sorted().toList();

    }

    private List<Song> filterSongsByOption(int selectedOption) throws IndexOutOfBoundsException {
        String menuOption = menuOptions.get(selectedOption - 1);
        return songs.stream().filter(item -> Objects.equals(item.getByKey(selectedKey), menuOption)).toList();
    }
}
