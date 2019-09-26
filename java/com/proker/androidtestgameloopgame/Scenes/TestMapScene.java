package com.proker.androidtestgameloopgame.Scenes;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.Hud.HudManager;
import com.proker.androidtestgameloopgame.Engine.MapManager;
import com.proker.androidtestgameloopgame.Objects.Player.Player;

public class TestMapScene implements Scene {
    private MapManager map;
    private HudManager hudManager;
    private Player player;

    public TestMapScene() {
        // Load Map first
        map = new MapManager();
        hudManager = new HudManager();

        player = new Player(0 * Constants.TILESIZE, 0 * Constants.TILESIZE);
    }



    @Override
    public void update() {
        map.update();
        hudManager.update();
        player.update();
    }

    @Override
    public void draw(Canvas canvas) {
        map.draw(canvas);
        hudManager.draw(canvas);
        player.draw(canvas);
    }

    @Override
    public void terminate() {
        map.terminate();
    }

    @Override
    public void recieveTouch(MotionEvent event) {
        map.recieveTouch(event);
        hudManager.recieveTouch(event);
        player.recieveTouch(event);
    }
}
