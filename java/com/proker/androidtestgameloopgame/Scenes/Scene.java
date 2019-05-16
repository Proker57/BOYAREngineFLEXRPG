package com.proker.androidtestgameloopgame.Scenes;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public interface Scene {
    public void update();
    public void draw(Canvas canvas);
    public void terminate();
    public void recieveTouch(MotionEvent event);
}
