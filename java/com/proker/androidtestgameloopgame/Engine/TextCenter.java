package com.proker.androidtestgameloopgame.Engine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;


public class TextCenter {
    private Paint paint;
    private String text;
    private Rect areaRect;
    private RectF bounds;

    private Typeface pressstart2p;

    public TextCenter(int color, int size, Rect rectDst, Paint paint, String text) {
        this.text = text;

        this.paint = paint;
        pressstart2p = Typeface.createFromAsset(Constants.CURRENT_CONTEXT.getAssets(), "font/pressstart2p.ttf");
        //float scaledSizeInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, Constants.CURRENT_CONTEXT.getResources().getDisplayMetrics());
        paint.setTextSize((int) (size * Constants.CURRENT_CONTEXT.getResources().getDisplayMetrics().scaledDensity));
        paint.setTypeface(pressstart2p);
        areaRect = new Rect(rectDst);
        bounds = new RectF(areaRect);
        bounds.right = paint.measureText(text, 0, text.length());
        bounds.bottom = paint.descent() - paint.ascent();
        bounds.left += (areaRect.width() - bounds.right) / 2.0f;
        bounds.top += (areaRect.height() - bounds.bottom) / 2.0f;
        paint.setColor(color);
    }

    // Float version
    public TextCenter(int color, float size, Rect rectDst, Paint paint, String text) {
        this.text = text;

        this.paint = paint;
        pressstart2p = Typeface.createFromAsset(Constants.CURRENT_CONTEXT.getAssets(), "font/pressstart2p.ttf");
        //float scaledSizeInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, Constants.CURRENT_CONTEXT.getResources().getDisplayMetrics());
        //paint.setTextSize(size * Constants.CURRENT_CONTEXT.getResources().getDisplayMetrics().scaledDensity);
        paint.setTextSize(size);
        paint.setTypeface(pressstart2p);
        areaRect = new Rect(rectDst);
        bounds = new RectF(areaRect);
        bounds.right = paint.measureText(text, 0, text.length());
        bounds.bottom = paint.descent() - paint.ascent();
        bounds.left += (areaRect.width() - bounds.right) / 2.0f;
        bounds.top += (areaRect.height() - bounds.bottom) / 2.0f;
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        canvas.drawText(text, bounds.left, bounds.top - paint.ascent(), paint);
    }
}
