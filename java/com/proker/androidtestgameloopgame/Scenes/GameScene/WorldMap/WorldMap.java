package com.proker.androidtestgameloopgame.Scenes.GameScene.WorldMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.R;
import com.proker.androidtestgameloopgame.Scenes.Scene;

import java.util.ArrayList;

public class WorldMap implements Scene {

    // Rects
    private Rect rect;
    public static Rect rectPlayer;
    private Rect moveRightRect, moveLeftRect, moveUpRect, moveDownRect;
    public static Rect checkRightRect, checkLeftRect, checkUpRect, checkDownRect;

    private Paint paint;

    private static Bitmap map, player;
    private float xBCenter, yBCenter, xFCenter, yFCenter, xCenter, yCenter;
    public static int xpos, ypos, dx, dy;
    private int playerX, playerY;

    private ArrayList<Destination> destinations = new ArrayList<>();
    private ArrayList<Wall> walls = new ArrayList<>();

    public static boolean isMoveLeft = false,
            isMoveRight = false,
            isMoveUp = false,
            isMoveDown = false,
            isMovable = false;

    public WorldMap() {




        paint = new Paint();

        // Add Bitmap
        BitmapFactory bf = new BitmapFactory();
        map = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.game_state_world_map);
        player = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.world_map_player);

        // Start location of map
        xpos = 0;
        ypos = Constants.TOP_BAR_HEIGHT;

        // Useless code
//        xBCenter = (int) (0 - map.getWidth() / 2);
//        yBCenter = (int) (0 - map.getHeight() / 2);
        xFCenter = (int) (xBCenter + Constants.SCREEN_WIDTH / 2);
        yFCenter = (int) (yBCenter + Constants.TOP_BAR_HEIGHT + Constants.GAME_BOARD_HEIGHT / 2);
//        xpos = xFCenter;
//        ypos = yFCenter;
        // Delta x
        dx = player.getWidth();
        dy = player.getHeight();
        // Rect init
        playerX = 4 * player.getWidth();
        playerY = 3 * player.getHeight() + Constants.TOP_BAR_HEIGHT;

        rect = new Rect(0, Constants.GAME_BOARD_Y, Constants.GAME_BOARD_WIDTH, Constants.GAME_BOARD_HEIGHT);
        rectPlayer = new Rect(playerX + 1, playerY + 1, playerX + player.getWidth() - 1, playerY + player.getHeight() - 1);
        // Move Rectangles
        moveLeftRect = new Rect((int) (Constants.SCREEN_WIDTH * 0.52f), (int) (Constants.GAME_BOARD_HEIGHT * 0.72f), (int) (Constants.SCREEN_WIDTH * 0.7f), (int) (Constants.GAME_BOARD_HEIGHT * 0.88f));
        moveRightRect = new Rect((int) (Constants.SCREEN_WIDTH * 0.85f), (int) (Constants.GAME_BOARD_HEIGHT * 0.72f), (int) (Constants.SCREEN_WIDTH), (int) (Constants.GAME_BOARD_HEIGHT * 0.88f));
        moveUpRect = new Rect((int) (Constants.SCREEN_WIDTH * 0.7f), (int) (Constants.GAME_BOARD_HEIGHT * 0.6f), (int) (Constants.SCREEN_WIDTH * 0.85f), (int) (Constants.GAME_BOARD_HEIGHT * 0.75f));
        moveDownRect = new Rect((int) (Constants.SCREEN_WIDTH * 0.7f), (int) (Constants.GAME_BOARD_HEIGHT * 0.85f), (int) (Constants.SCREEN_WIDTH * 0.85f), (int) (Constants.GAME_BOARD_HEIGHT));
        // CheckRectangles
        checkLeftRect = new Rect(playerX - player.getWidth() + 2, playerY, playerX, playerY + player.getHeight());
        checkRightRect = new Rect(playerX, playerY, playerX + player.getWidth() * 2, playerY + player.getHeight());
        checkUpRect = new Rect(playerX, playerY - player.getHeight(), playerX + player.getWidth(), playerY + player.getHeight());
        checkDownRect = new Rect(playerX, playerY + player.getHeight(), playerX + player.getWidth(), playerY + player.getHeight() * 2);

        init();


        // Destionations
        addDestionations();
        // Walls
        addWalls();
    }

    private void init() {
        Constants.WALL_WIDTH = rectPlayer.width();
    }

    private void addDestionations() {
        // Test 1
        destinations.add(new Destination(0, xpos + 7 * dx, ypos + 5 * dy));
        // Test 2
        destinations.add(new Destination(1, xpos + 2 * player.getWidth(), ypos + 3 * player.getHeight()));
    }

    private void addWalls() {
        walls.add(new Wall(xpos + 5 * dx, ypos + 2 * dy));
        walls.add(new Wall(xpos + 20 * dx, ypos + 5 * dy));
    }

    @Override
    public void update() {
        for (Wall wall : walls) {
            wall.checkCollision();
        }

        // Move left
        if (isMoveLeft) {
            //isMovable = false;
            if (xpos >= 0 || playerX > 5 * player.getWidth()) {
                if (!(playerX - player.getWidth() < 0)) {
                    playerX -= dx;
                } else {
                    isMoveLeft = false;
                }
            } else {
                isMovable = true;
                // Update Destionations
                for (Destination destination : destinations) {
                    destination.update();
                }
                // Update walls
                for (Wall wall : walls) {
                    wall.update();
                }
                xpos += dx;
            }

            isMoveLeft = false;
        } else {
            isMoveLeft = false;
        }
        // Move Right
        if (isMoveRight) {
            isMovable = false;
            if (xpos + map.getWidth() - Constants.SCREEN_WIDTH - dx <= 0 || playerX < 6 * player.getWidth()) {
                if (!(playerX + rectPlayer.width() * 2 > Constants.SCREEN_WIDTH)) {
                    playerX += dx;
                } else {
                    isMoveRight = false;
                }
            } else {
                isMovable = true;
                // Update Destionations
                for (Destination destination : destinations) {
                    destination.update();
                }
                // Update walls
                for (Wall wall : walls) {
                    wall.update();
                }
                xpos -= dx;
            }

            isMoveRight = false;
        } else {
            isMoveRight = false;
        }
        // Move Up
        if (isMoveUp) {
            isMovable = false;
            if (ypos >= Constants.TOP_BAR_HEIGHT || playerY >= Constants.TOP_BAR_HEIGHT + 6 * player.getHeight()) {
                if (!(playerY - player.getHeight() < Constants.TOP_BAR_HEIGHT)) {
                    playerY -= dy;
                } else {
                    isMoveUp = false;
                }
            } else {
                isMovable = true;
                // Update Destionations
                for (Destination destination : destinations) {
                    destination.update();
                }
                // Update walls
                for (Wall wall : walls) {
                    wall.update();
                }
                ypos += dy;
            }

            isMoveUp = false;
        } else {
            isMoveUp = false;
        }
        // Move Down
        if (isMoveDown) {
            isMovable = false;
            if (ypos + map.getHeight() - Constants.GAME_BOARD_HEIGHT <= Constants.TOP_BAR_HEIGHT || playerY <= Constants.TOP_BAR_HEIGHT + 5 * player.getHeight()) {
                if (!(playerY + player.getHeight() * 2 > Constants.GAME_BOARD_HEIGHT)) {
                    playerY += dy;
                } else {
                    isMoveUp = false;
                }
            } else {
                isMovable = true;
                // Update Destionations
                for (Destination destination : destinations) {
                    destination.update();
                }
                // Update walls
                for (Wall wall : walls) {
                    wall.update();
                }
                ypos -= dy;
            }

            isMoveDown = false;
        } else {
            isMoveDown = false;
        }

        // Set player rectangle
        rectPlayer.set(playerX + 1, playerY + 1, playerX + player.getWidth() - 1, playerY + player.getHeight() - 1);
        // Set checkRectangles
        checkLeftRect.set(playerX - player.getWidth(), playerY, playerX, playerY + player.getHeight());
        checkRightRect.set(playerX, playerY, playerX + player.getWidth() * 2, playerY + player.getHeight());
        checkUpRect.set(playerX, playerY - player.getHeight(), playerX + player.getWidth(), playerY + player.getHeight());
        checkDownRect.set(playerX, playerY + player.getHeight(), playerX + player.getWidth(), playerY + player.getHeight() * 2);

        // Update Destionation collisions
        for (Destination destination : destinations) {
            destination.checkCollision();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        // Fill background with solid color
        paint.setColor(Color.MAGENTA);
        canvas.drawRect(rect, paint);

        // Draw world map
        canvas.drawBitmap(map, xpos, ypos, paint);

        // Draw Destionations
        for (Destination destination : destinations) {
            destination.draw(canvas);
        }

        // Draw walls
        for (Wall wall : walls) {
            wall.draw(canvas);
        }

        // DELETE
        paint.setColor(Color.argb(150, 255, 255, 255));
        canvas.drawRect(moveLeftRect, paint);
        canvas.drawRect(moveRightRect, paint);
        canvas.drawRect(moveUpRect, paint);
        canvas.drawRect(moveDownRect, paint);
        canvas.drawRect(checkLeftRect, paint);
        canvas.drawRect(checkRightRect, paint);
        canvas.drawRect(checkUpRect, paint);
        canvas.drawRect(checkDownRect, paint);

        // Draw player on world map
        canvas.drawBitmap(player, playerX, playerY, null);
        // Draw player rect
        paint.setColor(Color.WHITE);
        //canvas.drawRect(rectPlayer, paint);

    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Move Left
                if (moveLeftRect.contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " World map Left Button DOWN");
                    isMoveLeft = true;
                }
                // Move Right
                if (moveRightRect.contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " World map Right Button DOWN");
                    isMoveRight = true;
                }
                // Move Up
                if (moveUpRect.contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " World map Up Button DOWN");
                    isMoveUp = true;
                }
                // Move Down
                if (moveDownRect.contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " World map Down Button DOWN");
                    isMoveDown = true;
                }
                break;
        }
    }

    public static Bitmap getMap() {
        return map;
    }
}
