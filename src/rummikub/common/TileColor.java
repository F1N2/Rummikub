package rummikub.common;

public enum TileColor {
    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    WHITE("\u001B[37m"); /* Replace Black */

    private final String color;

    TileColor(String color) {
        this.color = color;
    }

    public String color() {
        return this.color;
    }
}
