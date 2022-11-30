package rummikub;

import rummikub.common.TileGroup;
import rummikub.common.event.AI;
import rummikub.common.event.Game;
import rummikub.common.event.Player;

public class Rummikub {
    public static void main(String[] args) {
        Game.init();
        TileGroup.colorSort(Player.tile);
        TileGroup.colorSort(AI.tile);
        System.out.println(Player.printTile());
        System.out.println(AI.printTile());
    }
}
