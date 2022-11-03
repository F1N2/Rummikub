package rummikub.common;

public class Tile {
    int count = 1;
    final int id;
    final int number; /* Joker: 0 */
    final TileColor color;
    boolean used;

    public Tile(int number, TileColor color) {
        this.id = count++;
        this.number = number;
        this.color = color;
        this.used = false;
    }

    public int number() {
        return this.number;
    }

    public TileColor color() {
        return this.color;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return this.used;
    }

    public boolean equal(Tile tile) {
        return this.id == tile.id;
    }
}
