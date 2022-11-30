package rummikub.common.event;

import rummikub.common.Tile;
import rummikub.common.TileColor;
import rummikub.common.TileList;

import java.util.Collections;

public class Game {
    public static void init() {
        // 타일들을 추가하고 셔플
        for (int i=1;i<=13;i++)
            for (TileColor color : TileColor.values())
                TileList.unused.add(new Tile(i, color));
        TileList.unused.add(new Tile(0, TileColor.RED));
        TileList.unused.add(new Tile(0, TileColor.WHITE));
        Collections.shuffle(TileList.unused);

        // Player와 AI에게 각각 14개의 타일 주기
        for (int i=0; i<14; i++) {
            AI.tile.add(TileList.unused.remove(0));
            Player.tile.add(TileList.unused.remove(0));
        }
    }
}
