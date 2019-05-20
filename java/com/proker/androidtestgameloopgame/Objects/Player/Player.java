package com.proker.androidtestgameloopgame.Objects.Player;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.Objects.GameObject;
import com.proker.androidtestgameloopgame.R;

import static android.content.Context.MODE_PRIVATE;

public class Player extends PlayerVars implements GameObject {
    private SharedPreferences s;

    private Rect rect;
    private Paint paint;
    private boolean isActive = false;
    private int xpos, ypos, width, height;
    private int pWidth = 64, pHeight = 64;

    private int index;

    private String type;

    public Player(int index) {
        this.index = index;
        paint = new Paint();
        s = Constants.CURRENT_CONTEXT.getSharedPreferences("saveFile", MODE_PRIVATE);

        switch (index) {
            case 1:
                // Position
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) / 2);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.55f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);

                // STATS
                name = Constants.CURRENT_CONTEXT.getString(R.string.player_1_name);
                HPC = s.getString("player_1_HPC", "");
                HPMAX = s.getString("player_1_HPMAX", "");

                APC = "100";
                APMAX = "129";
                WPNC = "VODKA";
                VDKC = "15";
                BEERC = "20";
                CTLC = "35";
                DEFC = "4";
                LVLC = "1";
                EXPMIN = "1200";
                EXPMAX = "6500";
                EVDC = "15" + "%";
                CRTC = "20" + "%";
                STRC = "10";
                DEXC = "18";
                CONC = "11";
                break;
            case 2:

                xpos = (int) ((Constants.SCREEN_WIDTH / 4) + (Constants.SCREEN_WIDTH / 4) / 2);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.45f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);

                // STATS
                name = Constants.CURRENT_CONTEXT.getString(R.string.player_2_name);
                HPC = "60";
                HPMAX = "190";
                break;

            case 3:
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) * 2 + (Constants.SCREEN_WIDTH / 4) / 2)  - (pWidth);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.55f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);

                // STATS
                name = Constants.CURRENT_CONTEXT.getString(R.string.player_3_name);
                break;
            case 4:

                xpos = (int) ((Constants.SCREEN_WIDTH / 4) * 3 + (Constants.SCREEN_WIDTH / 4) / 2)  - (pWidth);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.45f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);

                // STATS
                name = Constants.CURRENT_CONTEXT.getString(R.string.player_4_name);
                break;
        }
        rect = new Rect(xpos, ypos, width, height);

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHPC() {
        return HPC;
    }

    public void setHPC(String HPC) {
        this.HPC = HPC;
    }

    public String getHPMAX() {
        return HPMAX;
    }

    public void setHPMAX(String MAXHP) {
        this.HPMAX = MAXHP;
    }

    public String getAPC() {
        return APC;
    }

    public void setAPC(String APC) {
        this.APC = APC;
    }

    public String getAPMAX() {
        return APMAX;
    }

    public void setAPMAX(String MAXAP) {
        this.APMAX = MAXAP;
    }

    public String getWPNC() {
        return WPNC;
    }

    public void setWPNC(String WPNC) {
        this.WPNC = WPNC;
    }

    public String getVDKC() {
        return VDKC;
    }

    public void setVDKC(String VDKC) {
        this.VDKC = VDKC;
    }

    public String getBEERC() {
        return BEERC;
    }

    public void setBEERC(String BEERC) {
        this.BEERC = BEERC;
    }

    public String getCTLC() {
        return CTLC;
    }

    public void setCTLC(String CTLC) {
        this.CTLC = CTLC;
    }

    public String getDEFC() {
        return DEFC;
    }

    public void setDEFC(String DEFC) {
        this.DEFC = DEFC;
    }

    public String getEVDC() {
        return EVDC;
    }

    public void setEVDC(String EVDC) {
        this.EVDC = EVDC;
    }

    public String getCRTC() {
        return CRTC;
    }

    public void setCRTC(String CRTC) {
        this.CRTC = CRTC;
    }

    public String getLVLC() {
        return LVLC;
    }

    public void setLVLC(String LVLC) {
        this.LVLC = LVLC;
    }

    public String getEXPMIN() {
        return EXPMIN;
    }

    public void setEXPMIN(String EXPMIN) {
        this.EXPMIN = EXPMIN;
    }

    public String getEXPMAX() {
        return EXPMAX;
    }

    public void setEXPMAX(String EXPMAX) {
        this.EXPMAX = EXPMAX;
    }

    public String getSTRC() {
        return STRC;
    }

    public void setSTRC(String STRC) {
        this.STRC = STRC;
    }

    public String getDEXC() {
        return DEXC;
    }

    public void setDEXC(String DEXC) {
        this.DEXC = DEXC;
    }

    public String getCONC() {
        return CONC;
    }

    public void setCONC(String CONC) {
        this.CONC = CONC;
    }

}
