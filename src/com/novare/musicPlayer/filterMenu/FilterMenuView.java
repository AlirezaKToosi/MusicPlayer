package com.novare.musicPlayer.filterMenu;

import com.novare.musicPlayer.utils.printManager;

import java.util.List;

public class FilterMenuView {
    public FilterMenuView(List<String> menuOption) {
        printManager.clearScreen();
        printManager.appTitle();
        MenuTitle();
        printManager.optionList(menuOption);
        printManager.optionBackToMainMenu();
        printRequest();

    }

    private static void MenuTitle() {
        System.out.println("Menu:");
    }
    public void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public void printRequest() {
        System.out.print("Choose an option press enter: ");
    }
}
