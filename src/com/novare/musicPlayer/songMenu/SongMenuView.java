package com.novare.musicPlayer.songMenu;

import com.novare.musicPlayer.utils.printManager;

import java.util.List;

public class SongMenuView {
    public SongMenuView(List<String> menuOptions) {
        printManager.clearScreen();
        printManager.appTitle();
        System.out.println("Songs menu:");
        printManager.optionList(menuOptions);
        printManager.optionBackToMainMenu();
        printRequest();
    }

    public void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public void printRequest() {
        System.out.print("Choose a song and press enter: ");
    }

    public void printSongNotFoundError() {
        System.out.println("❌️ Cannot play this song");
    }

    public void printSongPlaying() {
        System.out.println("▶️ Playing song");
    }
}
