package rummikub.common.status;


public enum InputStatus {
    /*
    타일 그룹을 고르거나 턴 스킵이나 타일 여러개 선택 : 0
     */
    INIT(0),
    SELECT_GROUP(1),
    SELECT_TILES(2);

    InputStatus(int statusCode) {}
}
