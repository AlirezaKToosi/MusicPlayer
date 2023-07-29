package com.novare.musicPlayer.searchMenu;

import java.util.List;
import com.novare.musicPlayer.utils.Song;

public class SearchMenu {
    public SearchMenu(List<Song> songs) {
        SearchMenuModel model = new SearchMenuModel(songs);
        SearchMenuView view = new SearchMenuView();
        SearchMenuController controller = new SearchMenuController(model, view);

        controller.requestUserInput();
    }
}
