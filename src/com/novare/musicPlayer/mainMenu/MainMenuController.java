package com.novare.musicPlayer.mainMenu;

import java.util.Scanner;

public class MainMenuController {
    private final MainMenuView view;
    private final MainMenuModel model;
    private final Scanner scanner;

    public MainMenuController(MainMenuModel model, MainMenuView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void requestUserInput() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);
            model.handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            view.printInvalidOption();
            view.printEnterChoice();
            requestUserInput();
        }
    }
}
