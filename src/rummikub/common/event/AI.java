package rummikub.common.event;

import rummikub.common.Tile;
import rummikub.common.util.Color;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AI {
    public static ArrayList<Tile> tile = new ArrayList<>();

    public static String printTile() {
        return tile.stream().map((e) -> e.color.value + e.number + Color.RESET.color()+" ")
            .collect(Collectors.joining());
    }
}
