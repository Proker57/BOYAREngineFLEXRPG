package com.proker.androidtestgameloopgame.Engine.Hud;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Scenes.Scene;

public class Hud implements Scene {
    private int id;     // 0: Movement

    private HudMovement hudMovement;

    public Hud(int id) {
        this.id = id;

        switch (id) {
            case 0:
                hudMovement = new HudMovement((int) (Constants.SCREEN_WIDTH * 0.05), (int) (Constants.SCREEN_HEIGHT * 0.7));
                break;
        }
    }

    @Override
    public void update() {
        if (hudMovement.isActive()) hudMovement.update();
    }

    @Override
    public void draw(Canvas canvas) {
        if (hudMovement.isActive()) hudMovement.draw(canvas);

    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        if (hudMovement.isActive()) hudMovement.recieveTouch(event);

    }
}
