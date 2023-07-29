package com.novare.musicPlayer.mainMenu;

public class MainMenu {
    public MainMenu() {
        MainMenuModel model = new MainMenuModel();
        MainMenuView view = new MainMenuView(model.getMenuOptions());
        MainMenuController mainMenuController = new MainMenuController(model, view);
        mainMenuController.requestUserInput();
    }
}
