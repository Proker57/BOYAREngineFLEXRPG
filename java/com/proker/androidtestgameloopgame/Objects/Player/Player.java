package com.proker.androidtestgameloopgame.Objects.Player;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.Objects.GameObject;

public class Player implements GameObject {

    private Rect rect;
    private Paint paint;
    private boolean isActive = false;
    private int xpos, ypos, width, height;
    private int pWidth = 64, pHeight = 64;

    private int index;
    private String name;
    private String type;

    private int	HP;
    private int	MAXHP;
    private int	AP;
    private int	MAXAP;
    private int	WPN;

    private int	VDK;
    private int	BEER;
    private int	CTL;
    private int	DEF;
    private int	EVD;
    private int	CRT;
    private int	LVL;
    private int	EXP;
    private int	MAXEXP;

    private int	STR;
    private int	DEX;
    private int	CON;

    public Player(int index) {
        this.index = index;
        paint = new Paint();

        switch (index) {
            case 1:
                //xpos = (int) (Constants.SCREEN_WIDTH * 0.15f);
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) / 2);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.55f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);
                break;
            case 2:
                //xpos = (int) (Constants.SCREEN_WIDTH * 0.35f);
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) + (Constants.SCREEN_WIDTH / 4) / 2);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.45f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);
                break;

            case 3:
                //xpos = (int) (Constants.SCREEN_WIDTH * 0.55f);
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) * 2 + (Constants.SCREEN_WIDTH / 4) / 2)  - (pWidth);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.55f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);
                break;
            case 4:
                //xpos = (int) (Constants.SCREEN_WIDTH * 0.75f);
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) * 3 + (Constants.SCREEN_WIDTH / 4) / 2)  - (pWidth);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.45f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);
                break;
        }
        rect = new Rect(xpos, ypos, width, height);

//        name;
//        type;
//
//        HP;
//        MAXHP;
//        AP;
//        MAXAP;
//        WPN;
//
//        VDK;
//        BEER;
//        CTL;
//        DEF;
//        EVD;
//        CRT;
//        LVL;
//        EXP;
//        MAXEXP;
//
//        STR;
//        DEX;
//        CON;
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setColor(Color.rgb(15, 230, 15));
        canvas.drawRect(rect, paint);
    }

    @Override
    public void update() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (rect.contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " Player " + index + " pressed (DOWN), " + "isActive: " + isActive);
                }
                break;
            case MotionEvent.ACTION_UP:
                // Spell button
                if (rect.contains((int) event.getX(), (int) event.getY())) {
                    isActive = true;
                    System.out.println(EngineStrings.engineText() + " Player " + index + " pressed, " + "isActive: " + isActive);
                } else {
                    isActive = false;
                }
                break;
        }
    }

    public int getIndex() {
        return index;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Rect getRect() {
        return rect;
    }
}
