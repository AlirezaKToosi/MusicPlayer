package com.novare.musicPlayer.songMenu;

import com.novare.musicPlayer.utils.Song;

import java.util.List;

public class SongMenu {
    public SongMenu(List<Song> song) {
        SongMenuModel model=new SongMenuModel(song);
        SongMenuView view=new SongMenuView(model.getMenuOptions());
        SongMenuController controller=new SongMenuController(model,view);
        controller.requestUserInput();
    }
}
