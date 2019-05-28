package com.proker.androidtestgameloopgame.Scenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Buttons.ButtonEnumMainMenu;
import com.proker.androidtestgameloopgame.Buttons.ButtonManager;
import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.Engine.FontManager;
import com.proker.androidtestgameloopgame.R;

public class MainmenuScene implements Scene {
    private ButtonManager buttonManager;
    private ButtonManager backButtonManager;
    private ButtonManager socialsButtonManager;

    private Rect optionsRect;

    private MediaPlayer backSound;

    private StaticLayout staticLayout;

    private Bitmap bg;
    private Paint paint;

    String start, options, about, pressAboutText, back;

    // Visibility of buttons
    private int MENU_STATE = 0;     // 0 = All buttons, 1 = options, 2 = pressF, 3 = new game

    public MainmenuScene() {
        init();

        // Rect for Options and about Menu
        optionsRect = new Rect(Constants.OPTIONS_RECT_X, Constants.OPTIONS_RECT_y, Constants.OPTIONS_RECT_WIDTH, Constants.OPTIONS_RECT_HEIGHT);

        // StaticLayout for text in about
        //staticLayout = new StaticLayout(pressAboutText, textPaint, optionsRect.width() - (Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.mainmenu_about_text)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        staticLayout = new StaticLayout(pressAboutText, FontManager.PressStart2P(), optionsRect.width(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        System.out.println(EngineStrings.engineText() + Constants.SCREEN_WIDTH + "   " + Constants.SCREEN_HEIGHT);

        // New Paint
        paint = new Paint();

        // Load sounds
        backSound = new MediaPlayer().create(Constants.CURRENT_CONTEXT, R.raw.button_sound);

        // ButtonManager Block
        buttonManager = new ButtonManager();
        backButtonManager = new ButtonManager();
        socialsButtonManager = new ButtonManager();

        // Background image
        bg = new BitmapFactory().decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.bgwo);

        // Iterators of buttonManager
        // Start        0
        buttonManager.add(Constants.START_BUTTON_X, Constants.START_BUTTON_Y, Constants.START_BUTTON_WIDTH, Constants.START_BUTTON_HEIGHT, start, Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.mainmenu_buttons), Color.WHITE);
        // Options      1
        buttonManager.add(Constants.OPTIONS_BUTTON_X, Constants.OPTIONS_BUTTON_Y, Constants.OPTIONS_BUTTON_WIDTH, Constants.OPTIONS_BUTTON_HEIGHT, options, Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.mainmenu_buttons), Color.WHITE);
        // About        2
        buttonManager.add(Constants.ABOUT_BUTTON_X, Constants.ABOUT_BUTTON_Y, Constants.ABOUT_BUTTON_WIDTH, Constants.ABOUT_BUTTON_HEIGHT, about, Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.mainmenu_buttons), Color.WHITE);
        // Back         0
        backButtonManager.add(Constants.BACK_BUTTON_X, Constants.BACK_BUTTON_Y, Constants.BACK_BUTTON_WIDTH, Constants.BACK_BUTTON_HEIGHT, back, Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.mainmenu_back_button), Color.WHITE);
        // VK           0
        socialsButtonManager.add(Constants.VK_BUTTON_X, Constants.VK_BUTTON_Y, Constants.VK_BUTTON_WIDTH, Constants.VK_BUTTON_HEIGHT, "VK", Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.mainmenu_back_button), Color.WHITE);
        // Facebook     1
        socialsButtonManager.add(Constants.F_BUTTON_X, Constants.F_BUTTON_Y, Constants.F_BUTTON_WIDTH, Constants.F_BUTTON_HEIGHT, "f", Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.mainmenu_back_button), Color.WHITE);

        System.out.println(MENU_STATE);
    }

    private void init() {
        // Strings block
        start = Constants.CURRENT_CONTEXT.getString(R.string.new_game);
        options = Constants.CURRENT_CONTEXT.getString(R.string.options);
        about = Constants.CURRENT_CONTEXT.getString(R.string.about);
        pressAboutText = Constants.CURRENT_CONTEXT.getString(R.string.about_text);
        back = Constants.CURRENT_CONTEXT.getString(R.string.back);

        // Main menu scene *****************************************************************************
        // Options rect
        Constants.OPTIONS_RECT_X = (int) (Constants.SCREEN_WIDTH * 0.1f);
        Constants.OPTIONS_RECT_y = (int) (Constants.SCREEN_HEIGHT / 2.2f);
        Constants.OPTIONS_RECT_WIDTH = (int) (Constants.SCREEN_WIDTH / 1.1f);
        Constants.OPTIONS_RECT_HEIGHT = (int) (Constants.SCREEN_HEIGHT / 1.2f);
        // Start button
        Constants.START_BUTTON_X = Constants.SCREEN_WIDTH / 2 - ((int)(Constants.SCREEN_WIDTH * 0.6f) / 2);
        Constants.START_BUTTON_Y = (int) (Constants.SCREEN_HEIGHT * 0.45f);
        Constants.START_BUTTON_WIDTH = (int) (Constants.SCREEN_WIDTH * 0.6f);
        Constants.START_BUTTON_HEIGHT = (int) (Constants.SCREEN_HEIGHT / 12);
        // Options button
        Constants.OPTIONS_BUTTON_X = Constants.SCREEN_WIDTH / 2 - ((int)(Constants.SCREEN_WIDTH * 0.6f) / 2);
        Constants.OPTIONS_BUTTON_Y = (int) (Constants.SCREEN_HEIGHT * 0.57f);
        Constants.OPTIONS_BUTTON_WIDTH = (int) (Constants.SCREEN_WIDTH * 0.6f);
        Constants.OPTIONS_BUTTON_HEIGHT = (int) (Constants.SCREEN_HEIGHT / 12);
        // ABOUT button
        Constants.ABOUT_BUTTON_X = Constants.SCREEN_WIDTH / 2 - ((int)(Constants.SCREEN_WIDTH * 0.6f) / 2);
        Constants.ABOUT_BUTTON_Y = (int) (Constants.SCREEN_HEIGHT * 0.69f);
        Constants.ABOUT_BUTTON_WIDTH = (int) (Constants.SCREEN_WIDTH * 0.6f);
        Constants.ABOUT_BUTTON_HEIGHT = (int) (Constants.SCREEN_HEIGHT / 12);
        // Back button
        Constants.BACK_BUTTON_X = (int) ((Constants.SCREEN_WIDTH * 1.4f) / 2);
        Constants.BACK_BUTTON_Y = (int) (Constants.SCREEN_HEIGHT * 0.9f);
        Constants.BACK_BUTTON_WIDTH = (int) (Constants.SCREEN_WIDTH * 0.2f);
        Constants.BACK_BUTTON_HEIGHT = (int) (Constants.SCREEN_HEIGHT / 12);
        // VK button
        Constants.VK_BUTTON_X = (int) (Constants.SCREEN_WIDTH * 0.1f);
        Constants.VK_BUTTON_Y = (int) (Constants.SCREEN_HEIGHT * 0.9);
        Constants.VK_BUTTON_WIDTH = (int) (Constants.SCREEN_WIDTH * 0.15f);
        Constants.VK_BUTTON_HEIGHT = (int) (Constants.SCREEN_HEIGHT / 12);
        // Facebook button
        Constants. F_BUTTON_X = (int) (Constants.SCREEN_WIDTH * 0.3f);
        Constants.F_BUTTON_Y = (int) (Constants.SCREEN_HEIGHT * 0.9);
        Constants.F_BUTTON_WIDTH = (int) (Constants.SCREEN_WIDTH * 0.15f);
        Constants.F_BUTTON_HEIGHT = (int) (Constants.SCREEN_HEIGHT / 12);
    }

    @Override
    public void update() {
        //buttonManager.update();
    }

    @Override
    public void draw(Canvas canvas) {
        //paint.setTextSize(48);
        //canvas.drawColor(Color.rgb(255, 0, 255));

        // Draw background image
        canvas.drawBitmap(bg, null, new RectF(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT), paint);
        socialsButtonManager.draw(canvas);

        switch (MENU_STATE) {
            case 0:     // Main menu
                buttonManager.draw(canvas);
                break;
            case 1:     // Options
                backButtonManager.draw(canvas);
                paint.setColor(Color.BLACK);
                canvas.drawRect(optionsRect, paint);
                break;
            case 2:     // About
                backButtonManager.draw(canvas);
                paint.setColor(Color.BLACK);
                canvas.drawRect(optionsRect, paint);

                // Draw static layout
                canvas.save();
                canvas.translate(optionsRect.left + (int) (14 * Constants.CURRENT_CONTEXT.getResources().getDisplayMetrics().density), optionsRect.top + (int) (14 * Constants.CURRENT_CONTEXT.getResources().getDisplayMetrics().density));
                staticLayout.draw(canvas);
                canvas.restore();
                break;
            case 3:     // New Game
                break;
        }
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // VK button
                if (socialsButtonManager.buttons.get(ButtonEnumMainMenu.vk).getRect().contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " VK");
                }
                // Facebook button
                if (socialsButtonManager.buttons.get(ButtonEnumMainMenu.f).getRect().contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " f");
                }
        }

        switch (MENU_STATE) {
            case 0:     // Main menu
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Start button
                        if (buttonManager.buttons.get(ButtonEnumMainMenu.start).getRect().contains((int) event.getX(), (int) event.getY())) {
                            System.out.println(EngineStrings.engineText() + " NEW GAME");
                            //terminate();
                        }
                        // Option button
                        if (buttonManager.buttons.get(ButtonEnumMainMenu.options).getRect().contains((int) event.getX(), (int) event.getY())) {
                            System.out.println(EngineStrings.engineText() + " OPTIONS");
                            MENU_STATE = 1;
                        }
                        // PressF button
                        if (buttonManager.buttons.get(ButtonEnumMainMenu.about).getRect().contains((int) event.getX(), (int) event.getY())) {
                            System.out.println(EngineStrings.engineText() + " ABOUT");
                            MENU_STATE = 2;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        // Start button
                        if (buttonManager.buttons.get(ButtonEnumMainMenu.start).getRect().contains((int) event.getX(), (int) event.getY())) {
                            System.out.println(EngineStrings.engineText() + " Button 1 UP");
                            // Load game
                            EngineStrings.load();
                            // World map or any other
                            Constants.GAME_SCENE_ACTIVE_SCENE = 3;
                            // Change to GameScene
                            SceneManager.ACTIVE_SCENE = 2;
                        }
                        break;
                }
                break;
            case 1:     // Options
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (backButtonManager.buttons.get(ButtonEnumMainMenu.back).getRect().contains((int) event.getX(), (int) event.getY())) {
                            // ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                            backSound.start();
                            MENU_STATE = 0;
                            System.out.println(EngineStrings.engineText() + " BACK");
                        }
                }
                break;
            case 2:     // About
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (backButtonManager.buttons.get(ButtonEnumMainMenu.back).getRect().contains((int) event.getX(), (int) event.getY())) {
                            MENU_STATE = 0;
                            System.out.println(EngineStrings.engineText() + " BACK");
                        }
                }
                break;
            case 3:     // New Game
                break;

        }
    }
}
