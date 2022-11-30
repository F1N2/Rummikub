package rummikub.common;

import com.sun.istack.internal.Nullable;
import rummikub.common.event.Game;
import rummikub.common.util.Color;
import rummikub.common.util.Sort;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TileGroup {
    public ArrayList<Tile> tiles = new ArrayList<>();
    public TileGroupType type;
    int number;
    @Nullable
    TileColor color;
    int min = 14;
    int max = -1;

    public TileGroup(ArrayList<Tile> tiles) {
        if (tiles.get(0).color == tiles.get(1).color) {
            this.type = TileGroupType.COLOR;
            this.color = tiles.get(0).color;
            tiles.forEach((tile) -> {
                if (tile.number < this.min) this.min = tile.number;
                if (tile.number > this.max) this.max = tile.number;
                this.tiles.add(tile);
            });
        } else if (tiles.get(0).number == tiles.get(1).number) {
            this.type = TileGroupType.NUMBER;
            this.number = tiles.get(0).number;
            this.tiles.addAll(tiles);
        }
        Game.tileGroups.add(this);
    }

    public static boolean canRegister(ArrayList<ArrayList<Tile>> tileLists, boolean checkSum) {
        int sum = 0;
        for (ArrayList<Tile> tileList : tileLists) {
            Sort.number(tileList);
            if (tileList.size() < 3 || (
                tileList.get(0).color != tileList.get(1).color &&
                    tileList.get(0).number != tileList.get(1).number
            ))
                return false;

            if (tileList.get(0).color == tileList.get(1).color) {
                @Nullable TileColor color = tileList.get(0).color;
                int min = tileList.get(0).number;
                int max = tileList.get(0).number;
                for (Tile tile : tileList) {
                    if (tile.color != color)
                        return false;
                    if (tile.number == min && tile.number == max) {
                        min--;
                        max++;
                    } else if (tile.number == min)
                        min--;
                    else if (tile.number == max)
                        max++;
                    else
                        return false;
                    sum += tile.number;
                }
            } else {
                int number = tileList.get(0).number;
                ArrayList<TileColor> colors = new ArrayList<>();
                if (tileList.size() > 4)
                    return false;
                for (Tile tile : tileList) {
                    if (tile.number != number)
                        return false;
                    else if (colors.contains(tile.color))
                        return false;
                    sum += tile.number;
                    colors.add(tile.color);
                }
            }
        }
        return !checkSum || sum >= 30;
    }

    public int add(Tile tile) {
        if (tile.number != 0) { // 타일이 조커가 아닌 경우
            if (this.type == TileGroupType.NUMBER) { // 타일의 번호가 같아야 하는 경우
                if (tile.number != this.number) // 타일의 번호가 맞지 않은 경우
                    return -1;
                for (Tile value : this.tiles)
                    if (value.color == tile.color) // 현재 그룹에 있는 타일의 컬러랑 추가하려는 타일의 컬러가 같은 경우
                        return -1;
            } else { // 타일의 컬러 색이 같아야 하는 경우
                if (this.color != tile.color)
                    return -1;
                else if (this.min - 1 == tile.number)
                    this.min--;
                else if (this.max + 1 == tile.number)
                    this.max++;
                else
                    return -1;
            }
        }
        tiles.add(tile);
        Sort.number(tiles);
        return tiles.size();
    }

    public int remove(Tile tile) {
        for (int i=0; i< this.tiles.size(); i++) {
            if (this.tiles.get(i).equal(tile)) {
                this.tiles.remove(i);
                return this.tiles.size();
            }
        }
        return -1;
    }

    static public String list(ArrayList<Tile> tiles) {
        return tiles.stream().map((e) -> e.color.value + (e.number == 0 ? "J" : e.number) + Color.RESET.value+" ")
                .collect(Collectors.joining());
    }

    public String list() {
        return this.tiles.stream().map((e) -> e.color.value + (e.number == 0 ? "J" : e.number) + Color.RESET.value+" ")
            .collect(Collectors.joining());
    }
}
