package com.novare.musicPlayer.songMenu;

import com.novare.musicPlayer.mainMenu.MainMenu;
import com.novare.musicPlayer.utils.ReadFile;
import com.novare.musicPlayer.utils.Song;
import com.novare.musicPlayer.utils.playSoundManager;

import java.io.IOException;
import java.util.List;

public class SongMenuModel {

    private final List<Song> songs;
    private final List<String> menuOptions;

    public SongMenuModel(List<Song> songs) {
        this.songs = songs;
        this.menuOptions = songs.stream().map(item->item.getName()).toList();
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException, IOException {
        if (selectedOption == 0) {
            new MainMenu();
        }
        playSong(selectedOption - 1);
    }

    private void playSong(int selectedSongNumber)throws IndexOutOfBoundsException, IOException {
        Song selectedSong = songs.get(selectedSongNumber);

        playSoundManager.openMedia(selectedSong);
    }
}
