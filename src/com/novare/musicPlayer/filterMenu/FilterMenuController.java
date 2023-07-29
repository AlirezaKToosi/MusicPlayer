package com.novare.musicPlayer.filterMenu;

import java.util.List;
import java.util.Scanner;

public class FilterMenuController {
    private final FilterMenuModel model;
    private final FilterMenuView view;
    private final Scanner scanner;

    public FilterMenuController(FilterMenuModel model, FilterMenuView view) {
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
            view.printRequest();
            requestUserInput();
        }
    }

}
