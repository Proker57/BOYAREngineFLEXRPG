package com.proker.androidtestgameloopgame.Engine.Maps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Tile implements Tiles {
    private float x;
    private float y;
    private float tileSize;
    private boolean isMovable = true;
    private Bitmap bitmap;
    private Paint paint;
    private Rect rect;

    public Tile(float x, float y, int tileSize, Bitmap bitmap, Paint paint) {
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
        this.bitmap = bitmap;
        this.paint = paint;
        rect = new Rect((int) x, (int) y, tileSize, tileSize);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, paint);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isMovable() { return isMovable; }

    public Rect getRect() { return rect; }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setMovable(boolean movable) {
        isMovable = movable;
    }
}