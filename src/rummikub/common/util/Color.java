package rummikub.common.util;

public enum Color {
    RESET("0"),
    BLACK("30"),
    RED("31"),
    GREEN("32"),
    YELLOW("33"),
    BLUE("34"),
    PURPLE("35"),
    CYAN("36"),
    WHITE("37"),
    BACKGROUND_BLACK("40"),
    BACKGROUND_RED("41"),
    BACKGROUND_GREEN("42"),
    BACKGROUND_YELLOW("43"),
    BACKGROUND_BLUE("44"),
    BACKGROUND_PURPLE("45"),
    BACKGROUND_CYAN("46"),
    BACKGROUND_WHITE("47");

    final private String color;

    Color(String color) {
        this.color = color;
    }

    public String color() {
        return "\u001B["+this.color+"m";
    }
}