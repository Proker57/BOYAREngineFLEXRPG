package com.proker.androidtestgameloopgame.Objects.Enemies;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Objects.GameObject;
import com.proker.androidtestgameloopgame.R;

public class Enemy implements GameObject {
    private Rect rect;
    private Bitmap bitmap;
    private int index, xpos, ypos;

    public Enemy(int index) {
        this.index = index;
        this.xpos = xpos;
        this.ypos = ypos;
        bitmap = new BitmapFactory().decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.enemy_generic_first_enemy1);
        rect = new Rect(xpos, ypos, xpos + bitmap.getWidth(), ypos + bitmap.getHeight());
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, rect, null);
    }

    @Override
    public void update() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }
}
