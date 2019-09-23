package com.proker.androidtestgameloopgame.Scenes.BoardParts.StatsFrames;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface StatsFrame {
    public void update();
    public void draw(Canvas canvas);
    public void recieveTouch(MotionEvent event);
}
