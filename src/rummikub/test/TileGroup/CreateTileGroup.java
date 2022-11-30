package rummikub.test.TileGroup;

import rummikub.common.Tile;
import rummikub.common.TileColor;
import rummikub.common.TileGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateTileGroup {
    public static void main(String[] args) {
        ArrayList<Tile> testList1 = new ArrayList<>(Arrays.asList(
            new Tile(8, TileColor.RED),
            new Tile(9, TileColor.RED),
            new Tile(6, TileColor.RED),
            new Tile(7, TileColor.RED)
        ));
        boolean test1 = TileGroup.canRegister(new ArrayList<>(Arrays.asList(testList1)));
        System.out.println(test1); // true
        System.out.println();

        ArrayList<Tile> testList2 = new ArrayList<>(Arrays.asList(
            new Tile(8, TileColor.RED),
            new Tile(6, TileColor.RED),
            new Tile(7, TileColor.RED)
        ));
        boolean test2 = TileGroup.canRegister(new ArrayList<>(Arrays.asList(testList2)));
        System.out.println(test2); // true
        System.out.println();

        ArrayList<Tile> testList3 = new ArrayList<>(Arrays.asList(
            new Tile(8, TileColor.RED),
            new Tile(6, TileColor.RED),
            new Tile(7, TileColor.RED),
            new Tile(10, TileColor.RED)
        ));
        boolean test3 = TileGroup.canRegister(new ArrayList<>(Arrays.asList(testList3)));
        System.out.println(test3); // false
        System.out.println();

        ArrayList<Tile> testList4 = new ArrayList<>(Arrays.asList(
            new Tile(9, TileColor.RED),
            new Tile(9, TileColor.BLUE),
            new Tile(9, TileColor.YELLOW),
            new Tile(9, TileColor.WHITE)
        ));
        boolean test4 = TileGroup.canRegister(new ArrayList<>(Arrays.asList(testList4)));
        System.out.println(test4); // false
        System.out.println();

        ArrayList<Tile> testList5 = new ArrayList<>(Arrays.asList(
            new Tile(9, TileColor.RED),
            new Tile(9, TileColor.BLUE),
            new Tile(9, TileColor.YELLOW),
            new Tile(10, TileColor.WHITE)
        ));
        boolean test5 = TileGroup.canRegister(new ArrayList<>(Arrays.asList(testList5)));
        System.out.println(test5); // false
        System.out.println();

        ArrayList<Tile> testList6 = new ArrayList<>(Arrays.asList(
            new Tile(9, TileColor.RED),
            new Tile(9, TileColor.BLUE),
            new Tile(9, TileColor.YELLOW)
        ));
        boolean test6 = TileGroup.canRegister(new ArrayList<>(Arrays.asList(testList6)));
        System.out.println(test6); // false
        System.out.println();

        ArrayList<Tile> testList7 = new ArrayList<>(Arrays.asList(
            new Tile(9, TileColor.RED),
            new Tile(9, TileColor.BLUE),
            new Tile(9, TileColor.YELLOW),
            new Tile(9, TileColor.RED)
        ));
        boolean test7 = TileGroup.canRegister(new ArrayList<>(Arrays.asList(testList7)));
        System.out.println(test7); // false
        System.out.println();
    }
}
