package com.novare.musicPlayer.songMenu;

import java.io.IOException;
import java.util.Scanner;

public class SongMenuController {
    private final SongMenuModel model;
    private final SongMenuView view;
    private final Scanner scanner;
    public SongMenuController(SongMenuModel model, SongMenuView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void requestUserInput() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.handleOption(selectedOption);
            view.printSongPlaying();
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            view.printInvalidOption();
        }
        catch (IOException exception) {
            view.printSongNotFoundError();
        }

        view.printRequest();
        requestUserInput();
    }
}
