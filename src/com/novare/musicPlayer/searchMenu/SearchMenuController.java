package com.novare.musicPlayer.searchMenu;

import com.novare.musicPlayer.utils.Song;

import java.util.List;
import java.util.Scanner;

public class SearchMenuController {
    private final SearchMenuModel model;
    private final SearchMenuView view;
    private final Scanner scanner;

    public SearchMenuController(SearchMenuModel model, SearchMenuView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void requestUserInput() {
        String input = scanner.nextLine();
        List<Song> songsFound = model.searchSongsByName(input);
        int totalSongsFound = songsFound.size();

        if (totalSongsFound > 0) {
            model.navigateToSongMenu(songsFound);
        }
        else {
            view.printResultsNotFoundError(input);
            view.printRequest();
            requestUserInput();
        }
    }
}
