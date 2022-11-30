package rummikub.common.event;

import rummikub.common.Tile;
import rummikub.common.TileGroup;
import rummikub.common.status.GameStatus;
import rummikub.common.TileColor;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    public static GameStatus status = GameStatus.NOT_PLAYING;
    public static ArrayList<Tile> unusedTiles = new ArrayList<>();
    public static ArrayList<TileGroup> tileGroups = new ArrayList<>();

    public static void init() {
        // 타일들을 추가하고 셔플
        for (int i=1;i<=13;i++)
            for (TileColor color : TileColor.values())
                unusedTiles.add(new Tile(i, color));
        unusedTiles.add(new Tile(0, TileColor.RED));
        unusedTiles.add(new Tile(0, TileColor.WHITE));
        Collections.shuffle(unusedTiles);

        // Player와 AI에게 각각 14개의 타일 주기
        for (int i=0; i<14; i++) {
            AI.tile.add(unusedTiles.remove(0));
            Player.tile.add(unusedTiles.remove(0));
        }
    }

    public static void inspection() {

    }
}
