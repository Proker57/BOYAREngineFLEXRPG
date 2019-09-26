package com.proker.androidtestgameloopgame.Engine.Hud;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Objects.Player.Player;
import com.proker.androidtestgameloopgame.Scenes.Scene;

public class HudMovement implements Scene {
    private int x, y;
    private Rect    rectLeft,
                    rectRight,
                    rectUp,
                    rectDown;

    private boolean isActive = true;

    private Paint paint;
    private BitmapFactory bf;
    private Bitmap bitmap;

    public HudMovement(int x, int y) {
        this.x = x;
        this.y = y;

        paint = new Paint();
        paint.setColor(Color.argb(168, 0, 234, 113));
        rectLeft = new Rect(x, y, (int) (x + Constants.SCREEN_WIDTH * 0.05), (int) (y + Constants.SCREEN_HEIGHT * 0.2));
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(rectLeft, paint);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (rectLeft.contains((int) event.getX(), (int) event.getY())) {
                    Player.dx += 10;
                }
                break;
            case MotionEvent.ACTION_UP:
                Player.dx = 0;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
