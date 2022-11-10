package rummikub.common;

public enum TileColor {
    RED(31),
    YELLOW(33),
    BLUE(34),
    WHITE(37); /* Replace Black */

    private final int color;

    TileColor(int color) {
        this.color = color;
    }

    public String color() {
        return "\u001B["+this.color+"m";
    }
}
