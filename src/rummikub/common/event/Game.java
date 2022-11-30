package rummikub.common.event;

import rummikub.common.Tile;
import rummikub.common.TileColor;
import rummikub.common.TileList;

public class Game {
    boolean player_turn = true;

    static void init() {
        for (int i=1;i<=13;i++)
            for (TileColor color : TileColor.values())
                TileList.unused.add(new Tile(i, color));
        TileList.unused.add(new Tile(0, TileColor.RED));
        TileList.unused.add(new Tile(0, TileColor.WHITE));
    }
}
