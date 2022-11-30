package rummikub.common;

import rummikub.common.util.Color;

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

    public String toString(Object str) {
        return this.value+str+Color.RESET.value;
    }
}
