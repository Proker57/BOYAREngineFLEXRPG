package com.proker.androidtestgameloopgame.Scenes;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Map {
    public void init();
    public void update();
    public void draw(Canvas canvas);
    public void terminate();
    public void recieveTouch(MotionEvent event);
}
