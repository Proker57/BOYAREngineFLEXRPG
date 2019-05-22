package com.proker.androidtestgameloopgame.StatsFrames.Free;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.Engine.FontManager;
import com.proker.androidtestgameloopgame.Objects.Player.PlayerManager;
import com.proker.androidtestgameloopgame.R;
import com.proker.androidtestgameloopgame.StatsFrames.HelpFrame.HelpFrame;
import com.proker.androidtestgameloopgame.StatsFrames.StatsFrame;

import java.util.ArrayList;

public class FreeStatsColumnMainFrame implements StatsFrame {
    private int index, xpos;
    private Rect rect;
    private String HP, AP, WPN, NAME, RES, VDK, BEER, CTL, DEF, LVL, EXP, EXPMIN, EXPMAX, EVD, CRT, TYPE, STR, DEX, CON;
    private String HPC;
    private String APC;
    private String WPNC;

    private String NAMEC;

    private String VDKC;
    private String BEERC;
    private String CTLC;
    private String DEFC;
    private String LVLC;
    private String EVDC;
    private String CRTC;
    private String STRC;
    private String DEXC;
    private String CONC;
    private StaticLayout slHPC, slAPC, slWPNC, slNAMEC, slVDK, slBEER, slCTL, slDEF, slLVL, slEXP, slEXPMIN, slEXPMAX, slEVD, slCRT, slSTR, slDEX, slCON;
    // Add help frame

    private ArrayList<HelpFrame> helpFrames = new ArrayList<>();
    private boolean helpFrameIsVisible = false;
    private boolean isActive = false;
    private String helpFrameText = Constants.CURRENT_CONTEXT.getString(R.string.help_frame_1_state);
    // Color

    private Paint paint;
    private static int state;      // 0 = main stats, 1 = res, 2 = crits, 3 = str/dex/con

    public FreeStatsColumnMainFrame(int index, int xpos) {
        this.index = index;
        this.xpos = xpos;

        paint = new Paint();
        rect = new Rect(xpos, Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y, xpos + Constants.FREE_STATS_COLUMN_WIDTH, Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_HEIGHT);

        // Set default help frame
        //helpFrames.add(new HelpFrame(helpFrameText));
        //helpFrameInit();

        // Init strings
        HP = Constants.CURRENT_CONTEXT.getString(R.string.stats_hp);
        AP = Constants.CURRENT_CONTEXT.getString(R.string.stats_ap);
        WPN = Constants.CURRENT_CONTEXT.getString(R.string.stats_wpn);
        NAME = Constants.CURRENT_CONTEXT.getString(R.string.stats_name);
        RES = Constants.CURRENT_CONTEXT.getString(R.string.stats_res);
        VDK = Constants.CURRENT_CONTEXT.getString(R.string.stats_vdk);
        BEER = Constants.CURRENT_CONTEXT.getString(R.string.stats_beer);
        CTL = Constants.CURRENT_CONTEXT.getString(R.string.stats_ctl);
        DEF = Constants.CURRENT_CONTEXT.getString(R.string.stats_def);
        LVL = Constants.CURRENT_CONTEXT.getString(R.string.stats_lvl);
        EXP = Constants.CURRENT_CONTEXT.getString(R.string.stats_exp);
        EVD = Constants.CURRENT_CONTEXT.getString(R.string.stats_evd);
        CRT = Constants.CURRENT_CONTEXT.getString(R.string.stats_crt);
        TYPE = Constants.CURRENT_CONTEXT.getString(R.string.stats_type);
        STR = Constants.CURRENT_CONTEXT.getString(R.string.stats_str);
        DEX = Constants.CURRENT_CONTEXT.getString(R.string.stats_dex);
        CON = Constants.CURRENT_CONTEXT.getString(R.string.stats_con);

        // GET THIS VARS FROM SAVE FILE
        for (int i = 0; i <= Constants.PLAYERS_COUNT; ++i) {
            HPC = PlayerManager.getPlayers().get(index - 1).getHPC() + "/" + PlayerManager.getPlayers().get(index - 1).getHPMAX();
            APC = PlayerManager.getPlayers().get(index - 1).getAPC() + "/" + PlayerManager.getPlayers().get(index - 1).getAPMAX();
            WPNC = PlayerManager.getPlayers().get(index - 1).getWPNC();
            NAMEC = PlayerManager.getPlayers().get(index - 1).getName();
            VDKC = PlayerManager.getPlayers().get(index - 1).getVDKC();
            BEERC = PlayerManager.getPlayers().get(index - 1).getBEERC();
            CTLC = PlayerManager.getPlayers().get(index - 1).getCTLC();
            DEFC = PlayerManager.getPlayers().get(index - 1).getDEFC();
            LVLC = PlayerManager.getPlayers().get(index - 1).getLVLC();
            EXPMIN = PlayerManager.getPlayers().get(index - 1).getEXPMIN();
            EXPMAX = PlayerManager.getPlayers().get(index - 1).getEXPMAX();
            EVDC = PlayerManager.getPlayers().get(index - 1).getEVDC() + "%";
            CRTC = PlayerManager.getPlayers().get(index - 1).getCRTC() + "%";
            STRC = PlayerManager.getPlayers().get(index - 1).getSTRC();
            DEXC = PlayerManager.getPlayers().get(index - 1).getDEXC();
            CONC = PlayerManager.getPlayers().get(index - 1).getCONC();
        }


        // Init StaticLayouts
        slHPC = new StaticLayout(HPC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0, false);
        slAPC = new StaticLayout(APC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0, false);
        slWPNC = new StaticLayout(WPNC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0, false);
        slNAMEC = new StaticLayout(NAMEC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);

        slVDK = new StaticLayout(VDK + VDKC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0, false);
        slBEER = new StaticLayout(BEER + BEERC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0, false);
        slCTL = new StaticLayout(CTL + CTLC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0, false);
        slDEF = new StaticLayout(DEF + DEFC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0, false);

        slLVL = new StaticLayout(LVL + LVLC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        slEXP = new StaticLayout(EXP, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0, false);
        slEXPMIN = new StaticLayout(EXPMIN + "  /", FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        slEXPMAX = new StaticLayout(EXPMAX, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0, false);
        slEVD = new StaticLayout(EVD + EVDC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        slCRT = new StaticLayout(CRT + CRTC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);

        slSTR = new StaticLayout(STR + STRC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        slDEX = new StaticLayout(DEX + DEXC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        slCON = new StaticLayout(CON + CONC, FontManager.FreeStatsCoumnMainFrameStats(), (int)(rect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);

        state = 0;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        // Check visibility of help frame
        if (helpFrameIsVisible) {
            if (!helpFrames.isEmpty()) {
                helpFrames.get(0).draw(canvas);
            }
        }

        switch (Constants.GAME_SCENE_ACTIVE_SCENE) {
            case 3:     // Free
                switch (state) {
                    case 0:     // Main stats
                        paint.setColor(Color.rgb(150, 0, 0));
                        canvas.drawRect(rect, paint);
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text));
                        canvas.drawText(HP, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 2), FontManager.FreeStatsCoumnMainFrameStats());
                        // HP current
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 2.5f));
                        slHPC.draw(canvas);
                        canvas.restore();

                        canvas.drawText(AP, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 5), FontManager.FreeStatsCoumnMainFrameStats());
                        // AP current
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 5.5f));
                        slAPC.draw(canvas);
                        canvas.restore();

                        canvas.drawText(WPN, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 8), FontManager.FreeStatsCoumnMainFrameStats());
                        // WPN current
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 8.5f));
                        slWPNC.draw(canvas);
                        canvas.restore();
                        break;
                    case 1:     // Res
                        // Background
                        paint.setColor(Color.rgb(0, 150, 0));
                        canvas.drawRect(rect, paint);
                        // Text
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text));
                        canvas.drawText(RES, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 2), FontManager.FreeStatsCoumnMainFrameStats());
                        // VDK
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 3));
                        slVDK.draw(canvas);
                        canvas.restore();
                        // BEER
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 4.5f));
                        slBEER.draw(canvas);
                        canvas.restore();
                        // CTL
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 6));
                        slCTL.draw(canvas);
                        canvas.restore();
                        // DEF
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 7.5f));
                        slDEF.draw(canvas);
                        canvas.restore();
                        break;
                    case 2:     // Crits
                        // Background
                        paint.setColor(Color.rgb(0, 0, 150));
                        canvas.drawRect(rect, paint);
                        // Text
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text));
                        // LVL
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)));
                        slLVL.draw(canvas);
                        canvas.restore();
                        // EXP
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 3.5f));
                        slEXP.draw(canvas);
                        canvas.restore();
                        // EXP MIN
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 5));
                        slEXPMIN.draw(canvas);
                        canvas.restore();
                        // EXP MAX
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 6.5f));
                        slEXPMAX.draw(canvas);
                        canvas.restore();
                        // EVD
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 9));
                        slEVD.draw(canvas);
                        canvas.restore();
                        // CRT
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 10.5f));
                        slCRT.draw(canvas);
                        canvas.restore();
                        break;
                    case 3:     // STR/DEX/CON
                        // Background
                        paint.setColor(Color.rgb(150, 150, 150));
                        canvas.drawRect(rect, paint);
                        // Text
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text));
                        // STR
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)));
                        slSTR.draw(canvas);
                        canvas.restore();
                        // DEX
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 2.5f));
                        slDEX.draw(canvas);
                        canvas.restore();
                        // CON
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 4f));
                        slCON.draw(canvas);
                        canvas.restore();
                        break;
                }

                if (isActive()) {
                    paint.setColor(Color.argb(40, 255, 255,255));
                    canvas.drawRect(rect, paint);
                }

                canvas.drawText(NAME, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 14), FontManager.FreeStatsCoumnMainFrameStats());
                // NAME current
                canvas.save();
                canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 14.5f));
                slNAMEC.draw(canvas);
                canvas.restore();
                break;
            case 2:     // Battle
                switch (state) {
                    case 0:     // Main stats
                        paint.setColor(Color.rgb(150, 0, 0));
                        canvas.drawRect(rect, paint);
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text));
                        canvas.drawText(HP, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 2), FontManager.FreeStatsCoumnMainFrameStats());
                        // HP current
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 2.5f));
                        slHPC.draw(canvas);
                        canvas.restore();

                        canvas.drawText(AP, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 5), FontManager.FreeStatsCoumnMainFrameStats());
                        // AP current
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 5.5f));
                        slAPC.draw(canvas);
                        canvas.restore();

                        canvas.drawText(WPN, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 8), FontManager.FreeStatsCoumnMainFrameStats());
                        // WPN current
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 8.5f));
                        slWPNC.draw(canvas);
                        canvas.restore();
                        break;
                    case 1:     // Res
                        // Background
                        paint.setColor(Color.rgb(0, 150, 0));
                        canvas.drawRect(rect, paint);
                        // Text
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text));
                        canvas.drawText(RES, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 2), FontManager.FreeStatsCoumnMainFrameStats());
                        // VDK
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 3));
                        slVDK.draw(canvas);
                        canvas.restore();
                        // BEER
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 4.5f));
                        slBEER.draw(canvas);
                        canvas.restore();
                        // CTL
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 6));
                        slCTL.draw(canvas);
                        canvas.restore();
                        // DEF
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 7.5f));
                        slDEF.draw(canvas);
                        canvas.restore();
                        break;
                    case 2:     // Crits
                        // Background
                        paint.setColor(Color.rgb(0, 0, 150));
                        canvas.drawRect(rect, paint);
                        // Text
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text));
                        // LVL
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)));
                        slLVL.draw(canvas);
                        canvas.restore();
                        // EXP
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 3.5f));
                        slEXP.draw(canvas);
                        canvas.restore();
                        // EXP MIN
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 5));
                        slEXPMIN.draw(canvas);
                        canvas.restore();
                        // EXP MAX
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 6.5f));
                        slEXPMAX.draw(canvas);
                        canvas.restore();
                        // EVD
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 9));
                        slEVD.draw(canvas);
                        canvas.restore();
                        // CRT
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 10.5f));
                        slCRT.draw(canvas);
                        canvas.restore();
                        break;
                    case 3:     // STR/DEX/CON
                        // Background
                        paint.setColor(Color.rgb(150, 150, 150));
                        canvas.drawRect(rect, paint);
                        // Text
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text));
                        // STR
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)));
                        slSTR.draw(canvas);
                        canvas.restore();
                        // DEX
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 2.5f));
                        slDEX.draw(canvas);
                        canvas.restore();
                        // CON
                        canvas.save();
                        canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 4f));
                        slCON.draw(canvas);
                        canvas.restore();
                        break;
                }

                if (isActive()) {
                    paint.setColor(Color.argb(40, 255, 255,255));
                    canvas.drawRect(rect, paint);
                }

                canvas.drawText(NAME, xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 14), FontManager.FreeStatsCoumnMainFrameStats());
                // NAME current
                canvas.save();
                canvas.translate(xpos + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text)), Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y + (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 14.5f));
                slNAMEC.draw(canvas);
                canvas.restore();
                break;
        }
    }

    // Help timer

    final Handler handler = new Handler();
    Runnable mLongPressed = new Runnable() {
        public void run() {
            switch (state) {
                case 0:
                    helpFrames.add(new HelpFrame(helpFrameText));
                    break;
                case 1:
                    helpFrames.add(new HelpFrame(Constants.CURRENT_CONTEXT.getString(R.string.help_frame_2_state)));
                    break;
                case 2:
                    helpFrames.add(new HelpFrame(Constants.CURRENT_CONTEXT.getString(R.string.help_frame_3_state)));
                    break;
                case 3:
                    helpFrames.add(new HelpFrame(Constants.CURRENT_CONTEXT.getString(R.string.help_frame_4_state)));
                    break;
            }
            helpFrameIsVisible = true;
            System.out.println(EngineStrings.engineText() + "Help frame long press on frame: " + index);
        }
    };
    @Override
    public void recieveTouch(MotionEvent event) {
        switch (Constants.GAME_SCENE_ACTIVE_SCENE) {
            case 3:     // Free
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (rect.contains((int) event.getX(), (int) event.getY())) {
                            handler.postDelayed(mLongPressed, 1000);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        // Spell button
                        if (rect.contains((int) event.getX(), (int) event.getY()) && helpFrameIsVisible == false) {
                            if (state < 3) {
                                state++;
                            } else {
                                state = 0;
                            }
                            System.out.println(EngineStrings.engineText() + " Free Stats Column Main Frame " + index + " pressed");
                        }
                        handler.removeCallbacks(mLongPressed);
                        // Remove help frame object
                        if (!helpFrames.isEmpty()) {
                            helpFrames.remove(0);
                            helpFrameIsVisible = false;
                        }
                        break;
                }
                break;
            case 2:     // Battle

                break;
        }
    }


    // Getters and setters *************************************************************************
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
