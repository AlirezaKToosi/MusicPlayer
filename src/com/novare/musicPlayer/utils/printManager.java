package com.novare.musicPlayer.utils;

import java.io.IOException;
import java.util.List;

public class printManager {
    public static void appTitle() {
        System.out.println("Welcome to the MusicPlayer app! 🎼 ");
        System.out.println();
    }

    public static void clearScreen() {
        String operatingSystem = System.getProperty("os.name");
        if (operatingSystem.equals("Windows")) {
            clearScreenWindows();
        } else {
            clearScreenUnix();
        }
    }
    public static void optionBackToMainMenu() {
        System.out.println("[0] Back to main menu");
    }

    public static void optionList(List<String> options) {
        for (int index = 0; index < options.size(); index++) {
            int number = index + 1;
            String label = options.get(index);

            System.out.println("[" + number + "] " + label);
        }
    }
    private static void clearScreenUnix() {
        String clearScreenASCIICode = "\033[H\033[2J";
        System.out.print(clearScreenASCIICode);
        System.out.flush();
    }

    private static void clearScreenWindows() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException error) {
            System.out.println("An error occurred, please try again later");
        }
    }
}
