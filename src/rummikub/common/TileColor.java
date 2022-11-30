package rummikub.common;

public enum TileColor {
    RED(31),
    YELLOW(33),
    BLUE(34),
    WHITE(37); /* Replace Black */

    public final int color;
    public final String value;

    TileColor(int color) {
        this.color = color;
        this.value = "\u001B["+this.color+"m";
    }
}
