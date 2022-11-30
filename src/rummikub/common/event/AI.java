package rummikub.common.event;

import rummikub.common.Tile;
import rummikub.common.status.GameStatus;

import java.util.ArrayList;

public class AI {
    public static int first = 0;
    public static boolean registered = false;
    public static ArrayList<Tile> tile = new ArrayList<>();

    public static void turn() throws InterruptedException {
        Thread.sleep(2000);
        Game.status = GameStatus.PLAYER_TURN;
        Console.playing();
    }
}
