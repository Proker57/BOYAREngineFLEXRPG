package com.proker.androidtestgameloopgame.Engine.Hud;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

public class HudManager {
    private ArrayList<Hud> huds = new ArrayList<>(4);
    
    public HudManager() {
        huds.add(new Hud(0));
    }
    
    public void update() {
        for (Hud hud: huds) {
            hud.update();
        }
    }
    
    public void draw(Canvas canvas) {
        for (Hud hud: huds) {
            hud.draw(canvas);
        }
    }
    
    public void recieveTouch(MotionEvent event) {
        for (Hud hud: huds) {
            hud.recieveTouch(event);
        }
    }
}
