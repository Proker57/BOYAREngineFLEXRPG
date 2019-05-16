package com.proker.androidtestgameloopgame.Scenes.GameScene;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.BottomButtons.BottomButtons;
import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.GameBoard.GameBoard;
import com.proker.androidtestgameloopgame.Objects.Player.PlayerManager;
import com.proker.androidtestgameloopgame.Scenes.Scene;
import com.proker.androidtestgameloopgame.StatsFrames.Free.FreeStatsFrame;
import com.proker.androidtestgameloopgame.StatsFrames.StatsFrameManager;
import com.proker.androidtestgameloopgame.TopBar.TopBar;

public class GameScene implements Scene {

    private Rect rect;
    private Paint paint;

    // Add Free Scene
    private TopBar topBar;
    private GameBoard gameBoard;
    private StatsFrameManager statsFrameManager;
    private BottomButtons bottomButtons;

    private PlayerManager playerManager;



    //private int ACTIVE_STATE = -1;   // 0 = Names frame, 1 = intro, 2 = free, 3 = world map


    public GameScene() {
        init();

        rect = new Rect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        paint = new Paint();

        // Set top bar rect
        topBar = new TopBar();
        // Set game board rect
        gameBoard = new GameBoard();
        // Add Stats frame manager
        statsFrameManager = new StatsFrameManager();
        // Add bottom buttons
        bottomButtons = new BottomButtons();

        // Add player
        playerManager = new PlayerManager(Constants.PLAYERS_COUNT);

    }

    private void init() {
        // Game Scene **********************************************************************************
        // Active scene
        Constants.GAME_SCENE_ACTIVE_SCENE = -1;
        // Top bar
        Constants.TOP_BAR_WIDTH = (int) Constants.SCREEN_WIDTH;
        Constants.TOP_BAR_HEIGHT = (int) (Constants.SCREEN_HEIGHT * 0.08f);
        System.out.println("TOP_BAR_HEIGHT: " + Constants.TOP_BAR_HEIGHT);
        // Game board
        Constants.GAME_BOARD_Y = (int)(Constants.SCREEN_HEIGHT * 0.08f);
        Constants.GAME_BOARD_WIDTH = (int) Constants.SCREEN_WIDTH;
        Constants.GAME_BOARD_HEIGHT = (int) (Constants.SCREEN_HEIGHT * 0.65);
        // Stats column
        Constants.STATS_COLUMN_SPELL_BUTTON_Y = (int) (Constants.SCREEN_HEIGHT * 0.9);
        Constants.STATS_COLUMN_SPELL_BUTTON_WIDTH = (int) (Constants.SCREEN_WIDTH / 4);
        Constants.STATS_COLUMN_SPELL_BUTTON_HEIGHT = (int) (Constants.SCREEN_HEIGHT - (Constants.SCREEN_HEIGHT * 0.95));
        // Stats column main frame
        Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_Y = (int) (Constants.SCREEN_HEIGHT * 0.65);
        Constants.FREE_STATS_COLUMN_MAIN_FRAME_RECT_HEIGHT = Constants.SCREEN_HEIGHT - ((int) (Constants.SCREEN_HEIGHT - (Constants.SCREEN_HEIGHT * 0.9)));
        // Bottom buttons
        Constants.BOTTOM_BUTTONS_Y = (int) (Constants.SCREEN_HEIGHT * 0.9) + (int) (Constants.SCREEN_HEIGHT - (Constants.SCREEN_HEIGHT * 0.95));
        Constants.BOTTOM_BUTTON_HEIGHT = Constants.SCREEN_HEIGHT - ((int) (Constants.SCREEN_HEIGHT * 0.9) + (int) (Constants.SCREEN_HEIGHT - (Constants.SCREEN_HEIGHT * 0.95)));
    }

    @Override
    public void update() {
        topBar.update();
        gameBoard.update();
        statsFrameManager.update();
        bottomButtons.update();
        playerManager.update();

        for (int i = 0; i < Constants.PLAYERS_COUNT; ++i) {
            if (playerManager.getPlayers().get(i).isActive()) {
                FreeStatsFrame.getFreeStatsColumns().get(i).getFreeStatsColumnMainFrame().setActive(true);
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {

        // Fill background with solid color
        canvas.drawColor(Color.GREEN);

        // Free
        if (Constants.GAME_SCENE_ACTIVE_SCENE == 2) {
            // Draw top bar
            topBar.draw(canvas);
            // Draw game board
            gameBoard.draw(canvas);
            // Draw players
            playerManager.draw(canvas);
            // Draw Stats frame
            statsFrameManager.draw(canvas);
            // Draw bottom buttons
            bottomButtons.draw(canvas);
        }

        // Add world map
        if (Constants.GAME_SCENE_ACTIVE_SCENE == 3) {
            gameBoard.draw(canvas);
            topBar.draw(canvas);
            statsFrameManager.draw(canvas);
            bottomButtons.draw(canvas);
        }
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        // Free
        if (Constants.GAME_SCENE_ACTIVE_SCENE == 2) {

            statsFrameManager.recieveTouch(event);
            gameBoard.recieveTouch(event);
            bottomButtons.recieveTouch(event);
            topBar.recieveTouch(event);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameBoard.getRect().contains((int) event.getX(), (int) event.getY())) {
                        for (int i = 0; i < Constants.PLAYERS_COUNT; ++i) {
                            playerManager.getPlayers().get(i).setActive(false);
                            FreeStatsFrame.getFreeStatsColumns().get(i).getFreeStatsColumnMainFrame().setActive(false);
                        }
                    }
                    break;
            }

            playerManager.recieveTouch(event);
        }

        // World map
        if (Constants.GAME_SCENE_ACTIVE_SCENE == 3) {

            gameBoard.recieveTouch(event);
            statsFrameManager.recieveTouch(event);
            bottomButtons.recieveTouch(event);
            topBar.recieveTouch(event);
        }

    }
}
