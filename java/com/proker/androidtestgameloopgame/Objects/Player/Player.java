package com.proker.androidtestgameloopgame.Objects.Player;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Objects.GameObject;

public class Player implements GameObject {
    public static int x, y;
    public static float dx, dy, walkSpeed, runSpeed;
    private int WIDTH, HEIGHT;
    private Rect rect;
    private Paint paint;
    private Bitmap bitmap;
    private BitmapFactory bf;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;
        walkSpeed = 3;
        runSpeed = 10;

        WIDTH = x + Constants.TILESIZE + Constants.TILESIZE;
        HEIGHT = y + Constants.TILESIZE + Constants.TILESIZE;

        paint = new Paint();
        paint.setColor(Color.rgb(255, 168, 32));

        rect = new Rect(x, y, WIDTH, HEIGHT);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(rect, paint);
    }

    @Override
    public void update() {
        x += dx;
        y += dy;
        rect.set(x, y, x + WIDTH, y + HEIGHT);
    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }
}
