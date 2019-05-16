package com.proker.androidtestgameloopgame.StatsFrames;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.StatsFrames.Battle.BattleStatsFrame;
import com.proker.androidtestgameloopgame.StatsFrames.Free.FreeStatsFrame;
import com.proker.androidtestgameloopgame.StatsFrames.Quest.QuestStatsFrame;

import java.util.ArrayList;

public class StatsFrameManager {
    public ArrayList<StatsFrame> statsFrame = new ArrayList<>();
    public static int ACTIVE_FRAME;

    public StatsFrameManager() {
        ACTIVE_FRAME = 0;
        statsFrame.add(new FreeStatsFrame());
        statsFrame.add(new BattleStatsFrame());
        statsFrame.add(new QuestStatsFrame());
    }


    public void recieveTouch(MotionEvent event) {
        statsFrame.get(ACTIVE_FRAME).recieveTouch(event);
    }

    public void update() {
        statsFrame.get(ACTIVE_FRAME).update();
    }

    public void draw(Canvas canvas) {
        statsFrame.get(ACTIVE_FRAME).draw(canvas);
    }
}
