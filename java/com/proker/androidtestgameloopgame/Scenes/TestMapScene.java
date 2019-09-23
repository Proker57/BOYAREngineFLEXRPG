package com.proker.androidtestgameloopgame.Scenes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
        Paint paint = new Paint(Color.red(255));

        canvas.drawColor(Color.rgb(128, 128, 64));
        //canvas.drawText(width, 50, 50, paint);

        map.draw(canvas);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }
}
