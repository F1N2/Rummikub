package rummikub.common.comparator;

import rummikub.common.Tile;

import java.util.Comparator;

public class TileNumberComparator implements Comparator<Tile> {
    @Override
    public int compare(Tile o1, Tile o2) {
        return o1.number - o2.number;
    }
}
