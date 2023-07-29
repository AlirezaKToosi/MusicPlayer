package com.novare.musicPlayer.searchMenu;

import com.novare.musicPlayer.utils.printManager;

public class SearchMenuView {
    public SearchMenuView() {
        printManager.clearScreen();
        printManager.appTitle();
        System.out.println("Search for a song:");
        printRequest();
    }

    public void printRequest() {
        System.out.print("Write the name of a song and press enter: ");
    }

    public void printResultsNotFoundError(String query) {
        System.out.println("🔍️ No results found for " + query);
    }
}
