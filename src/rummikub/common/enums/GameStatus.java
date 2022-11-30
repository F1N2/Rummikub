package rummikub.common.enums;

public enum GameStatus {
    NOT_PLAYING(-1),
    PLAYER_TURN(0),
    AI_TURN(1),
    AI2_TURN(2);

    public int number;

    GameStatus(int number) {
        this.number = number;
    }

    public String nowPlayer() {
        return number == 0 ? "Player" : number == 1 ? "1st AI" : "2nd AI";
    }

    public int number() {
        return this.number;
    }
}
