package rummikub;

import com.sun.istack.internal.Nullable;

public class TileGroup {
    Tile[] tiles = new Tile[13];
    @Nullable TileColor tileColor;
    @Nullable int tileNumber;

    public int get(Tile tile) {
        for (int i=0; i<this.length(); i++) {
            if (tiles[i].equal(tile)) return i;
        }
        return -1;
    }

    public int add(Tile tile) {
        this.tiles[this.length()-1] = tile;
        return this.length();
    }

    public int remove(Tile tile) {
        for (int i=0; i<this.length(); i++) {
            if (tiles[i].equal(tile)) {
                for (int j=i+1; i<this.length(); j++) tiles[j-1] = tiles[j];
                return i;
            }
        }
        return -1;
    }

    public int length() {
        for (int i=0; i<tiles.length; i++) {
            if (tiles[i] == null) return i;
        }
        return tiles.length;
    }

    public boolean equal(TileGroup tileGroup) {
        if (this.length() != tileGroup.length()) return false;
        for (int i=0; i<this.length(); i++) {
            if (!this.tiles[i].equal(tileGroup.tiles[i])) return false;
        }
        return true;
    }
}
