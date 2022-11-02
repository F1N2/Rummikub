package rummikub.common;

public class TileList {
    public static Tile[] used = new Tile[106];
    public static Tile[] unused = new Tile[106];
    public static TileGroup[] group = new TileGroup[100];

    public Tile getUsed(int index) {
        return used[index];
    }

    public Tile getUnused(int index) {
        return unused[index];
    }

    public TileGroup getGroup(int index) {
        return group[index];
    }

    public int addUsed(Tile tile) {
        used[this.usedLength()-1] = tile;
        return this.usedLength();
    }

    public int addUnused(Tile tile) {
        unused[this.unusedLength()-1] = tile;
        return this.unusedLength();
    }

    public int addGroup(TileGroup tileGroup) {
        group[this.groupLength()-1] = tileGroup;
        return this.groupLength();
    }

    public int removeUsed(Tile tile) {
        for (int i=0; i<this.usedLength(); i++) {
            if (used[i].equal(tile)) {
                for (int j=i+1; i<this.usedLength(); j++) used[j-1] = used[j];
                return i;
            }
        }
        return -1;
    }

    public int removeUnused(Tile tile) {
        for (int i=0; i<this.unusedLength(); i++) {
            if (unused[i].equal(tile)) {
                for (int j=i+1; i<this.unusedLength(); j++) unused[j-1] = unused[j];
                return i;
            }
        }
        return -1;
    }

    public int removeGroup(TileGroup tileGroup) {
        for (int i=0; i<this.groupLength(); i++) {
            if (group[i].equal(tileGroup)) {
                for (int j=i+1; i<this.groupLength(); j++) group[j-1] = group[j];
                return i;
            }
        }
        return -1;
    }

    public int usedLength() {
        for (int i=0; i<used.length; i++) {
            if (used[i] == null) return i;
        }
        return used.length;
    }

    public int unusedLength() {
        for (int i=0; i<unused.length; i++) {
            if (unused[i] == null) return i;
        }
        return unused.length;
    }

    public int groupLength() {
        for (int i=0; i<group.length; i++) {
            if (group[i] == null) return i;
        }
        return group.length;
    }
}
