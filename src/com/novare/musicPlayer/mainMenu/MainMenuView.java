package com.novare.musicPlayer.mainMenu;

import java.util.List;
import com.novare.musicPlayer.utils.*;

public class MainMenuView {
    public MainMenuView(List<String> menuOptions) {
        printManager.clearScreen();
        printManager.appTitle();
        System.out.println("Main menu options:");
        printManager.optionList(menuOptions);
        printEnterChoice();
    }
    public void printRequest() {
        System.out.print("Write the name of a song and press enter: ");
    }

    public void printResultsNotFoundError(String query) {
        System.out.println("🔍️ No results found for " + query);
    }
    public void printEnterChoice() {
        System.out.print("Choose an option press enter: ");
    }
    public void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }
}
