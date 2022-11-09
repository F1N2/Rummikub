package rummikub.common.event;

import com.sun.istack.internal.Nullable;
import rummikub.common.Tile;
import rummikub.common.TileColor;

import java.util.ArrayList;

public class Game {
    static void init() {

    }

    static boolean canRegister(ArrayList<ArrayList<Tile>> tileLists) {
        int sum = 0;
        for (ArrayList<Tile> tileList : tileLists) {
            @Nullable TileColor color;
            int number = -1;
            int min = 14;
            int max = -1;

            if (tileList.size() < 3 || (
                tileList.get(0).color != tileList.get(1).color &&
                    tileList.get(0).number != tileList.get(1).number
            ))
                return false;

            if (tileList.get(0).number == tileList.get(1).number)
                number = tileList.get(0).number;
            else
                color = tileList.get(0).color;
        }
        return true;
    }
}
