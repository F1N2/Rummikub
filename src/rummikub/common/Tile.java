package rummikub.common;

import rummikub.common.enums.TileColor;

public class Tile {
    int count = 1;
    final int id;
    public final int number; /* Joker: 0 */
    public final TileColor color;
    boolean used;

    public Tile(int number, TileColor color) {
        this.id = count++;
        this.number = number;
        this.color = color;
        this.used = false;
    }

    public boolean equal(Tile tile) {
        return this.id == tile.id;
    }
}
