package rummikub.common.status;


public enum InputStatus {
    /*
        타일 그룹 선택, 타일들 선택, 턴 스킵, 정렬 : 0
        타일 그룹 선택 : 1
        타일 그룹 선택 : 2
     */
    INIT(0),
    SELECT_GROUP(1),
    SELECT_TILES(2);

    InputStatus(int statusCode) {}
}
