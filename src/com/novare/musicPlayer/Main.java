package com.novare.musicPlayer;

import com.novare.musicPlayer.mainMenu.MainMenu;
import com.novare.musicPlayer.utils.ReadFile;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        new ReadFile("assets/data.txt");
        new MainMenu();
    }
}
