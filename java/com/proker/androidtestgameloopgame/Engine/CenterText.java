package com.proker.androidtestgameloopgame.Engine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class CenterText {
    private static Rect r = new Rect();

    public static void drawCenterText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }
}
