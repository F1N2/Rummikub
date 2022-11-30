package rummikub.common.event;

import rummikub.common.Tile;
import rummikub.common.TileGroup;
import rummikub.common.status.GameStatus;
import rummikub.common.status.InputStatus;
import rummikub.common.util.Color;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Player {
    public static boolean firstRegistered = false;
    public static InputStatus inputStatus = InputStatus.INIT;
    public static ArrayList<Tile> tile = new ArrayList<>();

    public static void skipTurn() {
        Player.tile.add(Game.unusedTiles.remove(0));
        Game.status = GameStatus.AI_TURN;
    }
}
