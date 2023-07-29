package com.novare.musicPlayer.filterMenu;

import com.novare.musicPlayer.utils.Song;

import java.util.List;

public class FilterMenu {
    public FilterMenu(List<Song> songs, String selectedKey) {
        FilterMenuModel model = new FilterMenuModel(songs, selectedKey);
        FilterMenuView view = new FilterMenuView(model.getMenuOptions());
        FilterMenuController controller = new FilterMenuController(model, view);

        controller.requestUserInput();
    }
}
