package rummikub.common;

import com.sun.istack.internal.Nullable;
import rummikub.common.util.Color;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TileGroup {
    public ArrayList<Tile> tiles = new ArrayList<>();
    int number;
    @Nullable TileColor color;
    int min = 14;
    int max = -1;

    public TileGroup(TileColor color, ArrayList<Tile> tiles) {
        this.color = color;
        this.number = -1;
        tiles.forEach((tile) -> {
            if (tile.number < this.min) this.min = tile.number;
            if (tile.number > this.max) this.max = tile.number;
            this.tiles.add(tile);
        });
    }

    public TileGroup(int number, ArrayList<Tile> tiles) {
        this.color = null;
        this.number = number;
        this.tiles.addAll(tiles);
    }

    public int add(Tile tile) {
        if (tile.number != 0) {
            if (this.color == null) { // 타일의 컬러 색이 상관 없을 경우
                if (tile.number != this.number) // 타일의 번호가 맞지 않은 경우
                    return -1;
                for (Tile value : this.tiles)
                    if (value.color == tile.color) // 현재 그룹에 있는 타일의 컬러랑 추가하려는 타일의 컬러가 같은 경우
                        return -1;
            } else { // 타일의 컬러 색이 같아야 하는 경우
                if (this.color != tile.color)
                    return -1;
                if (this.min - 1 == tile.number)
                    this.min--;
                else if (this.max + 1 == tile.number)
                    this.max++;
                else
                    return -1;
            }
        }
        tiles.add(tile);
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

    public void print() {
        System.out.println(
            this.tiles.stream().map((e) -> {
                return e.color.color() + e.number + Color.RESET.color()+" ";
            })
                .collect(Collectors.joining())
        );
    }
}
