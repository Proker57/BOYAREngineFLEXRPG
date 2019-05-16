package com.proker.androidtestgameloopgame.Objects;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface GameObject {
    public void draw(Canvas canvas);
    public void update();
    public void recieveTouch(MotionEvent event);
}
