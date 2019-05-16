package com.proker.androidtestgameloopgame.Buttons;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;

import java.util.ArrayList;

public class ButtonManager {
    public ArrayList<Button> buttons  = new ArrayList<>();;

    public void add(int x1, int y1, int width, int height) {
        buttons.add(new Button(x1, y1, width, height));
    }

    public void add(int x1, int y1, int width, int height, Paint paint) {
        buttons.add(new Button(x1, y1, width, height, paint));
    }

    public void add(float x1f, float y1f, float width, float height, Paint paint) {
        buttons.add(new Button(x1f, y1f, width, height, paint));
    }

    public void add(int x1, int y1, int width, int height, String text, int textSize, int textColor) {
        buttons.add(new Button(x1, y1, width, height, text, textSize, textColor));
    }

    public void add(int x1, int y1, int width, int height, String text, float textSize, int textColor) {
        buttons.add(new Button(x1, y1, width, height, text, textSize, textColor));
    }

    public void add(int x1, int y1, int width, int height, String text, int textSize, int textColor, Paint paint) {
        buttons.add(new Button(x1, y1, width, height, text, textSize, textColor, paint));
    }

    public void add(int x1, int y1, int id) {
        buttons.add(new Button(x1, y1, id));
    }

    public void add(int x1, int y1, int width, int height, int id) {
        buttons.add(new Button(x1, y1, width, height, id));
    }

    public void recieveTouch(MotionEvent event) {
        if (!buttons.isEmpty()) {
            for (Button btn: buttons) {
                btn.recieveTouch(event);
            }
        }
    }

    public void update() {
        if (!buttons.isEmpty()) {
            for (Button btn: buttons) {
                btn.update();
            }
        }
    }

    public void update(Point point) {
        if (!buttons.isEmpty()) {
            for (Button btn: buttons) {
                btn.update(point);
            }
        }
    }

    public void draw(Canvas canvas) {
        if (!buttons.isEmpty()) {
            for (Button btn: buttons) {
                btn.draw(canvas);
            }
        }
    }

    public int size() {
        return buttons.size();
    }
}
