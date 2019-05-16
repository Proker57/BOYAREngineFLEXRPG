package com.proker.androidtestgameloopgame.Objects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;

public class Obstacle implements GameObject {
    private Rect rect, rect2;
    private int color;
    private int startX;
    private int playerGap;

    public Rect getRect() {
        return rect;
    }

    public void incrementY(float y) {
        rect.top += y;
        rect.bottom += y;
        rect2.top += y;
        rect2.bottom += y;
    }

    public Obstacle(int rectHeight, int color, int startX, int startY, int playerGap) {
        this.color = color;
        rect = new Rect(0, startY, startX, startY + rectHeight);
        rect2 = new Rect(startX + playerGap, startY, Constants.SCREEN_WIDTH, startY + rectHeight);
    }

    public boolean playerCollide(PlayerTest playerTest) {
        return Rect.intersects(rect, playerTest.getRect()) || Rect.intersects(rect2, playerTest.getRect());
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rect, paint);
        canvas.drawRect(rect2, paint);
    }

    @Override
    public void update() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }
}
