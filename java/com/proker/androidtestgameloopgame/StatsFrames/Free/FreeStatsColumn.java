package com.proker.androidtestgameloopgame.StatsFrames.Free;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Buttons.ButtonManager;
import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.R;
import com.proker.androidtestgameloopgame.StatsFrames.StatsFrame;

public class FreeStatsColumn implements StatsFrame {
    private int index, xpos;

    private FreeStatsColumnMainFrame freeStatsColumnMainFrame;
    private ButtonManager spellButtonManager;
    private String spell_button_text;

    public FreeStatsColumn(int index, int xpos) {
        this.index = index;
        this.xpos = xpos;

        // Init strings
        spell_button_text = Constants.CURRENT_CONTEXT.getResources().getString(R.string.stats_spell_button);

        // Add stats frame
        freeStatsColumnMainFrame = new FreeStatsColumnMainFrame(index, xpos);

        // Add spell button
        spellButtonManager = new ButtonManager();
        spellButtonManager.add(xpos, Constants.STATS_COLUMN_SPELL_BUTTON_Y, Constants.STATS_COLUMN_SPELL_BUTTON_WIDTH, Constants.STATS_COLUMN_SPELL_BUTTON_HEIGHT, spell_button_text, Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.freeStatsColumn_spellButtonManager_button), Color.WHITE);
    }

    public FreeStatsColumn() {

    }

    @Override
    public void update() {
        spellButtonManager.update();
        freeStatsColumnMainFrame.update();
    }

    @Override
    public void draw(Canvas canvas) {
        spellButtonManager.draw(canvas);
        freeStatsColumnMainFrame.draw(canvas);
    }

    @Override
    public void recieveTouch(MotionEvent event) {
        freeStatsColumnMainFrame.recieveTouch(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Spell button
                if (spellButtonManager.buttons.get(0).getRect().contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " Spell " + index + " button pressed");
                }
        }
    }

    public FreeStatsColumnMainFrame getFreeStatsColumnMainFrame() {
        return freeStatsColumnMainFrame;
    }
}
