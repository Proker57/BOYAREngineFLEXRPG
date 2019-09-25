package com.proker.androidtestgameloopgame.Engine;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Maps.Tile;
import com.proker.androidtestgameloopgame.Scenes.Scene;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MapManager implements Scene {
    private String filename;
    public  String[] blockSheet;

    private int sizeLayers;

    public static int WIDTH, HEIGHT, TILESIZE;

    private JSONObject mapFile;

    private BitmapFactory bf;
    private Paint paint;

    private ArrayList<String> tilesetNames = new ArrayList<>();
    private ArrayList<Tile> tiles = new ArrayList<>();
    private ArrayList<Tile> blockTiles = new ArrayList<>();
    private ArrayList<String[]> sheets = new ArrayList<>();

    public MapManager() {
        // Set current map
        Constants.ACTIVE_MAP = 5;

        bf = new BitmapFactory();
        paint = new Paint();

        init();

        // TEST OUTPUT
        for (int i = 0; i < sheets.size(); i++) {
            try {
                System.out.print(mapFile.getJSONArray("layers").getJSONObject(i).getString("name") + ": ");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < sheets.get(i).length; j++) {
                System.out.print(sheets.get(i)[j]);
            }
            System.out.println("");
        }
    }

    private void init() {
        tiles.clear();
        tilesetNames.clear();
        blockTiles.clear();

        switch (Constants.ACTIVE_MAP) {
            case 0:
                this.filename = "tilemaps/testmapxml.json";
                break;
            case 1:
                this.filename = "tilemaps/test.json";
                break;
            case 2:
                this.filename = "tilemaps/test2.json";
                break;
            case 3:
                this.filename = "tilemaps/test3.json";
                break;
            case 4:
                this.filename = "tilemaps/test4.json";
                break;
            case 5:
                this.filename = "tilemaps/test5.json";
                break;
        }
        try {
            // Load tile map file
            mapFile = new JSONObject(loadJSONFromAsset(filename));
            // Get TILESIZE
            TILESIZE = mapFile.getInt("tilewidth") * 2;
            // Get WIDTH of map
            WIDTH = mapFile.getInt("width");
            // Get HEIGHT of map
            HEIGHT = mapFile.getInt("height");
            // Set layers count
            sizeLayers = mapFile.getJSONArray("layers").length();
            // Get tilesets array and source links
            for (int i = 0; i < mapFile.getJSONArray("tilesets").length(); i++) {
                tilesetNames.add(mapFile.getJSONArray("tilesets").getJSONObject(i).getString("name"));
            }
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        // Make new mapSheet
        try {
            for (int i = 0; i < sizeLayers; i++) {
                // Add sheets of movable tiles
                if (mapFile.getJSONArray("layers").getJSONObject(i).getString("name").compareToIgnoreCase("Block") != 0) {
                    sheets.add(mapFile.getJSONArray("layers").getJSONObject(i).getJSONArray("data").join(",").split(","));
                    System.out.println("ADD SHEET: " + mapFile.getJSONArray("layers").getJSONObject(i).getString("name"));
                } else {
                    // Add block tiles
                    blockSheet = mapFile.getJSONArray("layers").getJSONObject(i).getJSONArray("data").join(",").split(",");
                    System.out.println("ADD Block sheet: " + mapFile.getJSONArray("layers").getJSONObject(i).getString("name"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // DELETE
        System.out.println("Sheet size: " + sheets.size() + " *");

        for (int l = 0; l < sheets.size(); l++) {
            int k = 0;
            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {
                    switch (sheets.get(l)[k]) {
                        case "1":
                            tiles.add(new Tile(j * TILESIZE, i * TILESIZE, TILESIZE, bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(tilesetNames.get(0), "drawable", Constants.CURRENT_CONTEXT.getPackageName()))));
                            break;
                        case "2":
                            tiles.add(new Tile(j * TILESIZE, i * TILESIZE, TILESIZE, bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(tilesetNames.get(1), "drawable", Constants.CURRENT_CONTEXT.getPackageName()))));
                            break;
                        case "3":
                            tiles.add(new Tile(j * TILESIZE, i * TILESIZE, TILESIZE, bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(tilesetNames.get(2), "drawable", Constants.CURRENT_CONTEXT.getPackageName()))));
                            break;
                        case "4":
                            tiles.add(new Tile(j * TILESIZE, i * TILESIZE, TILESIZE, bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(tilesetNames.get(3), "drawable", Constants.CURRENT_CONTEXT.getPackageName()))));
                            break;
                    }
                    k++;
                }
            }
        }
        int k = 0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (blockSheet[k].compareToIgnoreCase("0") != 0) {
                    blockTiles.add(new Tile(j * TILESIZE, i * TILESIZE, TILESIZE / 2));
                }
                k++;
            }
        }
        // DELETE
        System.out.println(tiles.size() + "TILES SIZE");
        System.out.println(blockTiles.size() + "BLOCK TILES SIZE");


    }

    private String loadJSONFromAsset(String filename) {
        String json = null;

        try {
            InputStream is = Constants.CURRENT_CONTEXT.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void changeMap(int index) {
        Constants.ACTIVE_MAP = index;
        init();
    }

    @Override
    public void update() {
        // Making camera move
        for (int i = 0; i < tiles.size(); i++) {
            //tiles.get(i).setX(tiles.get(i).getX() -1);
        }

    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < tiles.size(); i++) {
            // Draw only visible tiles on screen
            if (tiles.get(i).getX() >= -TILESIZE && tiles.get(i).getX() <= Constants.SCREEN_WIDTH + TILESIZE && tiles.get(i).getY() >=  - TILESIZE && tiles.get(i).getY() <= Constants.SCREEN_HEIGHT + TILESIZE) {
                tiles.get(i).draw(canvas);
            }
        }
        for (int i = 0; i < blockTiles.size(); i++) {
            canvas.drawRect(blockTiles.get(i).getRect(), paint);
        }
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (int i = 0; i < blockTiles.size(); i++) {
                    if (blockTiles.get(i).getRect().contains((int) event.getX(), (int) event.getY())) {
                        System.out.println("LOH PIDOR");
                    }
                }
                System.out.println(blockTiles.size());
                break;
        }
    }
}
