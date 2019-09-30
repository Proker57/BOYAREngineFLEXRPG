package com.proker.androidtestgameloopgame.Engine.Hud;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;

import java.util.HashMap;

public class HudManager {
    private float xpos, ypos;

    public static HashMap<String, Hud> huds = new HashMap<>();
    
    public HudManager() {
    }
    
    public void update() {
        for (String key: huds.keySet()) {
            huds.get(key).update();
        }
    }
    
    public void draw(Canvas canvas) {
        for (String key: huds.keySet()) {
            huds.get(key).draw(canvas);
        }
    }
    
    public void recieveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xpos = event.getX();
                ypos = event.getY();

                // Rectangle location where will spawn joystick
                if (event.getX() >= 0 && event.getX() < Constants.SCREEN_WIDTH / 3) {
                    huds.put("joystick", new Hud(0, xpos, ypos));
                }

                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        for (String key: huds.keySet()) {
            huds.get(key).recieveTouch(event);
        }
    }
}
