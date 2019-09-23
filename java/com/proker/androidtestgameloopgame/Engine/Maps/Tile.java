package com.proker.androidtestgameloopgame.Engine.Maps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Tile implements Tiles {
    private float x, y, id;
    private BitmapFactory bf;
    private Bitmap bitmap;
    private Paint paint;

    public Tile(float x, float y, Bitmap bitmap, Paint paint) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        this.paint = paint;
        //this.id = id;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, paint);
    }
}
