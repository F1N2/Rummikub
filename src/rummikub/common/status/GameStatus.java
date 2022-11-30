package rummikub.common.status;

public enum GameStatus {
    NOT_PLAYING(-1),
    PLAYER_TURN(0),
    AI_TURN(1),
    AI2_TURN(2);

    final int statusCode;

    GameStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public String nowPlayer() {
        return this.statusCode == 0 ? "Player" : "AI";
    }
}
