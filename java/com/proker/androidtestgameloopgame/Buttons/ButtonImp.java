package com.proker.androidtestgameloopgame.Buttons;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface ButtonImp {
    public void recieveTouch(MotionEvent event);
    public void update();
    public void draw(Canvas canvas);
}
