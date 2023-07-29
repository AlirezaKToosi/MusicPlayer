package com.novare.musicPlayer.searchMenu;

import com.novare.musicPlayer.utils.Song;
import com.novare.musicPlayer.songMenu.SongMenu;

import java.util.ArrayList;
import java.util.List;

public class SearchMenuModel {
    private final List<Song> songs;

    public SearchMenuModel(List<Song> songs) {
        this.songs = songs;
    }

    public void navigateToSongMenu(List<Song> songsFound){
        new SongMenu(songsFound);
    }

    public List<Song> searchSongsByName(String input) {
        List<Song> result = new ArrayList<>();

        if (input.trim().equals("")) {
            return result;
        }

        for (Song item: songs) {
            String songName = item.getByKey("name").toUpperCase();
            String textToSearch = input.toUpperCase();

            if (songName.contains(textToSearch)) {
                result.add(item);
            }
        }

        return result;
    }
}
