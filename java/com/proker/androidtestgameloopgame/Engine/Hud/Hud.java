package com.proker.androidtestgameloopgame.Engine.Hud;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Scenes.Scene;

public class Hud implements Scene {
    private int id;     // 0: Movement

    private HudMovement hudMovement;

    public Hud(int id, float x, float y) {
        this.id = id;

        switch (id) {
            case 0:
                hudMovement = new HudMovement((int) (x), (int) (y));
                break;
        }
    }

    @Override
    public void update() {
        hudMovement.update();
    }

    @Override
    public void draw(Canvas canvas) {
        hudMovement.draw(canvas);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        hudMovement.recieveTouch(event);
    }
}
