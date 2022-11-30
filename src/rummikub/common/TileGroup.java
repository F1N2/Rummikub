package rummikub.common;

import com.sun.istack.internal.Nullable;
import rummikub.common.enums.TileColor;
import rummikub.common.enums.TileGroupType;
import rummikub.common.util.Color;
import rummikub.common.util.Sort;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TileGroup {
    int count = 1;
    final int id;
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
        this.id = this.count++;
    }

    public static int canRegister(ArrayList<ArrayList<Tile>> tileLists) {
        int sum = 0;
        for (ArrayList<Tile> tileList : tileLists) {
            Sort.number(tileList);
            if (tileList.size() < 3 || (
                tileList.get(0).color != tileList.get(1).color &&
                    tileList.get(0).number != tileList.get(1).number
            ))
                return -1;

            if (tileList.get(0).color == tileList.get(1).color) {
                @Nullable TileColor color = tileList.get(0).color;
                int min = tileList.get(0).number;
                int max = tileList.get(0).number;
                for (Tile tile : tileList) {
                    if (tile.color != color)
                        return -1;
                    if (tile.number == min && tile.number == max) {
                        min--;
                        max++;
                    } else if (tile.number == min)
                        min--;
                    else if (tile.number == max)
                        max++;
                    else
                        return -1;
                    sum += tile.number;
                }
            } else {
                int number = tileList.get(0).number;
                ArrayList<TileColor> colors = new ArrayList<>();
                if (tileList.size() > 4)
                    return -1;
                for (Tile tile : tileList) {
                    if (tile.number != number)
                        return -1;
                    else if (colors.contains(tile.color))
                        return -1;
                    sum += tile.number;
                    colors.add(tile.color);
                }
            }
        }
        return sum;
    }

    public boolean add(Tile tile) {
        if (tile.number != 0) { // 타일이 조커가 아닌 경우
            if (this.type == TileGroupType.NUMBER) { // 타일의 번호가 같아야 하는 경우
                if (tile.number != this.number) // 타일의 번호가 맞지 않은 경우
                    return false;
                for (Tile value : this.tiles)
                    if (value.color == tile.color) // 현재 그룹에 있는 타일의 컬러랑 추가하려는 타일의 컬러가 같은 경우
                        return false;
            } else { // 타일의 컬러 색이 같아야 하는 경우
                if (this.color != tile.color)
                    return false;
                else if (this.min - 1 == tile.number)
                    this.min--;
                else if (this.max + 1 == tile.number)
                    this.max++;
                else
                    return false;
            }
        }
        tiles.add(tile);
        Sort.number(tiles);
        return true;
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
