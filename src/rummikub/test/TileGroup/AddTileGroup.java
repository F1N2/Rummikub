package rummikub.test.TileGroup;

import rummikub.common.Tile;
import rummikub.common.TileColor;
import rummikub.common.TileGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class AddTileGroup {
    public static void main(String[] args) {
        // Number Test
        TileGroup testGroup = new TileGroup(
            new ArrayList<>(Arrays.asList(
                new Tile(7, TileColor.RED),
                new Tile(8, TileColor.RED),
                new Tile(9, TileColor.RED),
                new Tile(10, TileColor.RED)
            ))
        );
        System.out.println(testGroup.type);
        System.out.println(testGroup.add(new Tile(10, TileColor.RED)));
        System.out.println(testGroup.add(new Tile(5, TileColor.RED)));
        System.out.println(testGroup.add(new Tile(6, TileColor.RED)));
        System.out.println(testGroup.add(new Tile(11, TileColor.RED)));
        System.out.println(testGroup.add(new Tile(5, TileColor.RED)));
        System.out.println(testGroup.list());

        // Color Test
        TileGroup testGroup2 = new TileGroup(
            new ArrayList<>(Arrays.asList(
                new Tile(2, TileColor.RED),
                new Tile(2, TileColor.BLUE),
                new Tile(2, TileColor.WHITE)
            ))
        );
        System.out.println(testGroup2.add(new Tile(3, TileColor.YELLOW)));
        System.out.println(testGroup2.add(new Tile(2, TileColor.BLUE)));
        System.out.println(testGroup2.add(new Tile(2, TileColor.YELLOW)));
        System.out.println(testGroup2.list());

    }
}
