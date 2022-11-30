package rummikub.common.event;

import rummikub.common.Tile;
import rummikub.common.TileGroup;
import rummikub.common.enums.GameStatus;

import java.util.ArrayList;

public class Player {
    public static int first = 0;
    public static boolean registered = false;
    public static ArrayList<Tile> tile = new ArrayList<>();
    public static ArrayList<TileGroup> tempGroup = new ArrayList<>();

    public static void skipTurn() {
        if (!Player.registered)
            Player.tile.add(Game.unusedTiles.remove(0));
        if ((Player.first >= 30 || Player.first == -1) && Player.registered) {
            tempGroup = new ArrayList<>();
            Player.registered = false;
            if (Player.first >= 30)
                Player.first = -1;
        } else if (tempGroup.size() > 0)
            for (TileGroup group: tempGroup) {
                tile.addAll(group.tiles);
                Game.tileGroups.remove(group);
                tempGroup = new ArrayList<>();
            }
        Game.status = GameStatus.AI_TURN;
    }
}
