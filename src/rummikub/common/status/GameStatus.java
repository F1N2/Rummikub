package rummikub.common.status;

public enum GameStatus {
    NOT_PLAYING(-1),
    PLAYER_TURN(0),
    AI_TURN(1);

    GameStatus(int statusCode) {}
}
