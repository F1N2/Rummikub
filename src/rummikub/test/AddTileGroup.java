package rummikub.test;

import rummikub.common.Tile;
import rummikub.common.TileColor;
import rummikub.common.TileGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class AddTileGroup {
    public static void main(String[] args) {
        TileGroup testGroup = new TileGroup(
            new ArrayList<>(Arrays.asList(
                new Tile(7, TileColor.RED),
                new Tile(8, TileColor.RED),
                new Tile(9, TileColor.RED),
                new Tile(10, TileColor.RED)
            ))
        );
        System.out.println(testGroup.type);
        int test1 = testGroup.add(new Tile(10, TileColor.RED));
        System.out.println(test1);
        System.out.println(testGroup.list());
    }
}
