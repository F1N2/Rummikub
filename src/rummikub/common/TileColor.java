package rummikub.common;

public enum TileColor {
    RED(31),
    YELLOW(33),
    BLUE(34),
    WHITE(37); /* Replace Black */

    public final int number;
    public final String value;

    TileColor(int number) {
        this.number = number;
        this.value = "\u001B["+this.number +"m";
    }
}
