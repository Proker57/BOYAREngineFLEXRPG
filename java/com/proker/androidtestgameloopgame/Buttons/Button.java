package com.proker.androidtestgameloopgame.Buttons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.TextCenter;

public class Button implements ButtonImp {
    private int id;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private float x1f;
    private float y1f;
    private float x2f;
    private float y2f;
    private int textX;
    private int textY;

    private  String text;
    private TextCenter textCenter;

    private Paint paint;

    private Rect rect;

    Bitmap bitmap1;

//    public Button(int x1, int y1, int x2, int y2) {
//        this.x1 = x1;
//        this.y1 = y1;
//        this.x2 = x2;
//        this.y2 = y2;
//
//        rect = new Rect(x1, y1, x2, y2);
//    }

    public Button(int x1, int y1, int width, int height) {
        paint = new Paint();

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = width;
        this.y2 = height;

        rect = new Rect(x1, y1, x1 + width, y1 + height);
    }

    // With color rect
    public Button(int x1, int y1, int width, int height, Paint paint) {
        this.paint = paint;

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = width;
        this.y2 = height;

        rect = new Rect(x1, y1, x1 + width, y1 + height);
    }

    // Text + Center
    public Button(int x1, int y1, int width, int height, String text, int textSize, int textColor) {
        paint = new Paint();

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = width;
        this.y2 = height;
        this.text = text;

        rect = new Rect(x1, y1, x1 + width, y1 + height);

        textCenter = new TextCenter(textColor ,textSize, rect, paint, text);

        textX = rect.left;
        textY = rect.top;
    }

    // Text + Center + float textSize
    public Button(int x1, int y1, int width, int height, String text, float textSize, int textColor) {
        paint = new Paint();

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = width;
        this.y2 = height;
        this.text = text;

        rect = new Rect(x1, y1, x1 + width, y1 + height);

        textCenter = new TextCenter(textColor ,textSize, rect, paint, text);

        textX = rect.left;
        textY = rect.top;
    }

    // Text + Center + paint
    public Button(int x1, int y1, int width, int height, String text, int textSize, int textColor, Paint paint) {
        this.paint = paint;

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = width;
        this.y2 = height;
        this.text = text;

        rect = new Rect(x1, y1, x1 + width, y1 + height);

        textCenter = new TextCenter(textColor, textSize, rect, paint, text);

        textX = rect.left;
        textY = rect.top;
    }

    // With color paint float
    public Button(float x1f, float y1f, float width, float height, Paint paint) {
        this.paint = paint;

        this.x1f = x1f;
        this.y1f = y1f;
        this.x2f = width;
        this.y2f = height;

        rect = new Rect((int) x1f, (int) y1f, (int) (x1f + width), (int) (y1f + height));
    }

    // Image w/o rect
    public Button(int x1, int y1, int id) {
        paint = new Paint();

        this.x1 = x1;
        this.y1 = y1;

        bitmap1 = new BitmapFactory().decodeResource(Constants.CURRENT_CONTEXT.getResources(), id);
        rect = new Rect(x1, y1,  x1 + bitmap1.getWidth() , y1 + bitmap1.getHeight());
    }

    // Image with rect
    public Button(int x1, int y1, int width, int height, int id) {
        paint = new Paint();

        this.x1 = x1;
        this.y1 = y1;

        bitmap1 = new BitmapFactory().decodeResource(Constants.CURRENT_CONTEXT.getResources(), id);
        rect = new Rect(x1, y1,  x1 + width , y1 + height);
    }

    public Rect getRect() {
        return rect;
    }

    @Override
    public void recieveTouch(MotionEvent event) {
        System.out.println("Button recieveTouch");
    }

    @Override
    public void update() {

    }

    public void update(Point point) {
        //rect.set(point.x - rect.width() / 2, point.y - rect.height() / 2, point.x + rect.width() / 2, point.y + rect.height() / 2);
    }

    @Override
    public void draw(Canvas canvas) {


        if (bitmap1 == null) {
            paint.setColor(Color.rgb(0, 0, 0));
            canvas.drawRect(rect, paint);
            if (text != null) {
                paint.setColor(Color.WHITE);
                //paint.setTextSize(72);
                //drawCenterText(canvas, paint, text);
                //canvas.drawText(text, textX, textY, paint);
                textCenter.draw(canvas);
            }
        } else {
            canvas.drawBitmap(bitmap1, null, rect, paint);
        }
    }
}
