package com.proker.androidtestgameloopgame.Objects.Player;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Objects.GameObject;

import java.util.ArrayList;

public class PlayerManager implements GameObject {

    private static ArrayList<PlayerOld> players = new ArrayList<>();

    public PlayerManager(int count) {
        for (int i = 0; i < count; i++) {
            players.add(new PlayerOld(i));
        }
    }


    @Override
    public void draw(Canvas canvas) {
        for (PlayerOld player : players) {
            player.draw(canvas);
        }
    }

    @Override
    public void update() {
        for (PlayerOld player : players) {
            player.update();
        }
    }

    @Override
    public void recieveTouch(MotionEvent event) {
        for (PlayerOld player : players) {
            player.recieveTouch(event);
        }
    }

    public static ArrayList<PlayerOld> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayerOld> players) {
        this.players = players;
    }

}
