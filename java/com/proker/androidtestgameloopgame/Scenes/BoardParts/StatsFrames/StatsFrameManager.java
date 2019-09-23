package com.proker.androidtestgameloopgame.Scenes.BoardParts.StatsFrames;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Scenes.BoardParts.StatsFrames.Free.FreeStatsFrame;
import com.proker.androidtestgameloopgame.Scenes.BoardParts.StatsFrames.Quest.QuestStatsFrame;

import java.util.ArrayList;

public class StatsFrameManager {

    private ArrayList<StatsFrame> statsFrame = new ArrayList<>();
    public static int ACTIVE_FRAME;

    public StatsFrameManager() {
        ACTIVE_FRAME = 0;
        statsFrame.add(new FreeStatsFrame());
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

    public ArrayList<StatsFrame> getStatsFrame() {
        return statsFrame;
    }
}
