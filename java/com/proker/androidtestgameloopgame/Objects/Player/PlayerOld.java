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

public class PlayerOld extends PlayerVars implements GameObject {
    private SharedPreferences s;
    private SharedPreferences.Editor e;

    private Rect rect;
    private Paint paint;
    private boolean isActive = false;
    private int xpos, ypos, width, height;
    private int pWidth = 64, pHeight = 64;

    private int index;

    private String type;

    public PlayerOld(int index) {
        this.index = index;
        paint = new Paint();
        s = Constants.CURRENT_CONTEXT.getSharedPreferences("saveFile", MODE_PRIVATE);
        e = s.edit();

        // Set position
        switch (index) {
            case 0:
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) / 2);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.55f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);
                // Other stats
                name = Constants.CURRENT_CONTEXT.getString(R.string.player_1_name);
                break;
            case 1:
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) + (Constants.SCREEN_WIDTH / 4) / 2);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.45f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);
                // Other stats
                name = Constants.CURRENT_CONTEXT.getString(R.string.player_2_name);
                break;

            case 2:
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) * 2 + (Constants.SCREEN_WIDTH / 4) / 2)  - (pWidth);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.55f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);
                // Other stats
                name = Constants.CURRENT_CONTEXT.getString(R.string.player_3_name);
                break;
            case 3:
                xpos = (int) ((Constants.SCREEN_WIDTH / 4) * 3 + (Constants.SCREEN_WIDTH / 4) / 2)  - (pWidth);
                ypos = (int) (Constants.SCREEN_HEIGHT * 0.45f);
                width = (int) (xpos + pWidth);
                height = (int) (ypos + pHeight);
                // Other stats
                name = Constants.CURRENT_CONTEXT.getString(R.string.player_4_name);
                break;
        }

        //loadPlayer();

        if (!s.contains("player_" + index + "_HPC")) {
            switch (index) {
                case 0:
                    HPC = "11";
                    HPMAX = "111";
                    APC = "12";
                    APMAX = "112";
                    WPNC = "VODKA";
                    VDKC = "11";
                    BEERC = "12";
                    CTLC = "13";
                    DEFC = "14";
                    LVLC = "15";
                    EXPMIN = "106";
                    EXPMAX = "1007";
                    EVDC = "18";
                    CRTC = "19";
                    STRC = "110";
                    DEXC = "111";
                    CONC = "112";

                    e.putString("player_0_HPC", HPC);
                    e.putString("player_0_HPMAX", HPMAX);
                    e.putString("player_0_APC", APC);
                    e.putString("player_0_APMAX", APMAX);
                    e.putString("player_0_WPNC", WPNC);
                    e.putString("player_0_VDKC", VDKC);
                    e.putString("player_0_BEERC", BEERC);
                    e.putString("player_0_CTLC", CTLC);
                    e.putString("player_0_DEFC", DEFC);
                    e.putString("player_0_LVLC", LVLC);
                    e.putString("player_0_EXPMIN", EXPMIN);
                    e.putString("player_0_EXPMAX", EXPMAX);
                    e.putString("player_0_EVDC", EVDC);
                    e.putString("player_0_CRTC", CRTC);
                    e.putString("player_0_STRC", STRC);
                    e.putString("player_0_DEXC", DEXC);
                    e.putString("player_0_CONC", CONC);
                    e.commit();
                    break;
                case 1:
                    HPC = "21";
                    HPMAX = "211";
                    APC = "22";
                    APMAX = "212";
                    WPNC = "COCKTAIL";
                    VDKC = "21";
                    BEERC = "22";
                    CTLC = "23";
                    DEFC = "24";
                    LVLC = "25";
                    EXPMIN = "206";
                    EXPMAX = "2007";
                    EVDC = "28";
                    CRTC = "29";
                    STRC = "210";
                    DEXC = "211";
                    CONC = "212";

                    e.putString("player_1_HPC", HPC);
                    e.putString("player_1_HPMAX", HPMAX);
                    e.putString("player_1_APC", APC);
                    e.putString("player_1_APMAX", APMAX);
                    e.putString("player_1_WPNC", WPNC);
                    e.putString("player_1_VDKC", VDKC);
                    e.putString("player_1_BEERC", BEERC);
                    e.putString("player_1_CTLC", CTLC);
                    e.putString("player_1_DEFC", DEFC);
                    e.putString("player_1_LVLC", LVLC);
                    e.putString("player_1_EXPMIN", EXPMIN);
                    e.putString("player_1_EXPMAX", EXPMAX);
                    e.putString("player_1_EVDC", EVDC);
                    e.putString("player_1_CRTC", CRTC);
                    e.putString("player_1_STRC", STRC);
                    e.putString("player_1_DEXC", DEXC);
                    e.putString("player_1_CONC", CONC);
                    e.commit();
                    break;
                case 2:
                    HPC = "31";
                    HPMAX = "311";
                    APC = "32";
                    APMAX = "312";
                    WPNC = "BEER";
                    VDKC = "31";
                    BEERC = "32";
                    CTLC = "33";
                    DEFC = "34";
                    LVLC = "35";
                    EXPMIN = "306";
                    EXPMAX = "3007";
                    EVDC = "38";
                    CRTC = "39";
                    STRC = "310";
                    DEXC = "311";
                    CONC = "312";

                    e.putString("player_2_HPC", HPC);
                    e.putString("player_2_HPMAX", HPMAX);
                    e.putString("player_2_APC", APC);
                    e.putString("player_2_APMAX", APMAX);
                    e.putString("player_2_WPNC", WPNC);
                    e.putString("player_2_VDKC", VDKC);
                    e.putString("player_2_BEERC", BEERC);
                    e.putString("player_2_CTLC", CTLC);
                    e.putString("player_2_DEFC", DEFC);
                    e.putString("player_2_LVLC", LVLC);
                    e.putString("player_2_EXPMIN", EXPMIN);
                    e.putString("player_2_EXPMAX", EXPMAX);
                    e.putString("player_2_EVDC", EVDC);
                    e.putString("player_2_CRTC", CRTC);
                    e.putString("player_2_STRC", STRC);
                    e.putString("player_2_DEXC", DEXC);
                    e.putString("player_2_CONC", CONC);
                    e.commit();
                    break;
                case 3:
                    HPC = "41";
                    HPMAX = "411";
                    APC = "42";
                    APMAX = "412";
                    WPNC = "VODKA";
                    VDKC = "41";
                    BEERC = "42";
                    CTLC = "43";
                    DEFC = "44";
                    LVLC = "45";
                    EXPMIN = "406";
                    EXPMAX = "4007";
                    EVDC = "48";
                    CRTC = "49";
                    STRC = "410";
                    DEXC = "411";
                    CONC = "412";

                    e.putString("player_3_HPC", HPC);
                    e.putString("player_3_HPMAX", HPMAX);
                    e.putString("player_3_APC", APC);
                    e.putString("player_3_APMAX", APMAX);
                    e.putString("player_3_WPNC", WPNC);
                    e.putString("player_3_VDKC", VDKC);
                    e.putString("player_3_BEERC", BEERC);
                    e.putString("player_3_CTLC", CTLC);
                    e.putString("player_3_DEFC", DEFC);
                    e.putString("player_3_LVLC", LVLC);
                    e.putString("player_3_EXPMIN", EXPMIN);
                    e.putString("player_3_EXPMAX", EXPMAX);
                    e.putString("player_3_EVDC", EVDC);
                    e.putString("player_3_CRTC", CRTC);
                    e.putString("player_3_STRC", STRC);
                    e.putString("player_3_DEXC", DEXC);
                    e.putString("player_3_CONC", CONC);
                    e.commit();
                    break;
            }
        } else {
            HPC = s.getString("player_" + index + "_HPC", "");
            HPMAX = s.getString("player_" + index + "_HPMAX", "");
            APC = s.getString("player_" + index + "_APC", "");
            APMAX = s.getString("player_" + index + "_APMAX", "");
            WPNC = s.getString("player_" + index + "_WPNC", "");
            VDKC = s.getString("player_" + index + "_VDKC", "");
            BEERC = s.getString("player_" + index + "_BEERC", "");
            CTLC = s.getString("player_" + index + "_CTLC", "");
            DEFC = s.getString("player_" + index + "_DEFC", "");
            LVLC = s.getString("player_" + index + "_LVLC", "");
            EXPMIN = s.getString("player_" + index + "_EXPMIN", "");
            EXPMAX = s.getString("player_" + index + "_EXPMAX", "");
            EVDC = s.getString("player_" + index + "_EVDC", "");
            CRTC = s.getString("player_" + index + "_CRTC", "");
            STRC = s.getString("player_" + index + "_STRC", "");
            DEXC = s.getString("player_" + index + "_DEXC", "");
            CONC = s.getString("player_" + index + "_CONC", "");
        }

        // Init rectangle
        rect = new Rect(xpos, ypos, width, height);
    }

    public void savePlayer() {
        e.putString("player_" + index + "_HPC", HPC);
        e.putString("player_" + index + "_HPMAX", HPMAX);
        e.putString("player_" + index + "_APC", APC);
        e.putString("player_" + index + "_APMAX", APMAX);
        e.putString("player_" + index + "_WPNC", WPNC);
        e.putString("player_" + index + "_VDKC", VDKC);
        e.putString("player_" + index + "_BEERC", BEERC);
        e.putString("player_" + index + "_CTLC", CTLC);
        e.putString("player_" + index + "_DEFC", DEFC);
        e.putString("player_" + index + "_LVLC", LVLC);
        e.putString("player_" + index + "_EXPMIN", EXPMIN);
        e.putString("player_" + index + "_EXPMAX", EXPMAX);
        e.putString("player_" + index + "_EVDC", EVDC);
        e.putString("player_" + index + "_CRTC", CRTC);
        e.putString("player_" + index + "_STRC", STRC);
        e.putString("player_" + index + "_DEXC", DEXC);
        e.putString("player_" + index + "_CONC", CONC);
        e.commit();
        System.out.println(EngineStrings.engineText() + "PlayerOld " + index + " stats saved");
    }

    public void loadPlayer() {
        // STATS
        HPC = s.getString("player_" + index + "_HPC", "");
        HPMAX = s.getString("player_" + index + "_HPMAX", "");
        APC = s.getString("player_" + index + "_APC", "");
        APMAX = s.getString("player_" + index + "_APMAX", "");
        WPNC = s.getString("player_" + index + "_WPNC", "");
        VDKC = s.getString("player_" + index + "_VDKC", "");
        BEERC = s.getString("player_" + index + "_BEERC", "");
        CTLC = s.getString("player_" + index + "_CTLC", "");
        DEFC = s.getString("player_" + index + "_DEFC", "");
        LVLC = s.getString("player_" + index + "_LVLC", "");
        EXPMIN = s.getString("player_" + index + "_EXPMIN", "");
        EXPMAX = s.getString("player_" + index + "_EXPMAX", "");
        EVDC = s.getString("player_" + index + "_EVDC", "");
        CRTC = s.getString("player_" + index + "_CRTC", "");
        STRC = s.getString("player_" + index + "_STRC", "");
        DEXC = s.getString("player_" + index + "_DEXC", "");
        CONC = s.getString("player_" + index + "_CONC", "");
        System.out.println(EngineStrings.engineText() + "PlayerOld " + index +" stats loaded");
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
                    System.out.println(EngineStrings.engineText() + " PlayerOld " + index + " pressed (DOWN), " + "isActive: " + isActive);
                }
                break;
            case MotionEvent.ACTION_UP:
                // Spell button
                if (rect.contains((int) event.getX(), (int) event.getY())) {
                    isActive = true;
                    System.out.println(EngineStrings.engineText() + " PlayerOld " + index + " pressed, " + "isActive: " + isActive);
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
