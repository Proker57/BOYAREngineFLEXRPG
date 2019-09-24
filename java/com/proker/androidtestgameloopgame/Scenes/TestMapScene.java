package com.proker.androidtestgameloopgame.Scenes;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.MapManager;

public class TestMapScene implements Scene {
    private MapManager map;

    public TestMapScene() {
        map = new MapManager();
    }



    @Override
    public void update() {
        map.update();
    }

    @Override
    public void draw(Canvas canvas) {
        map.draw(canvas);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }
}
