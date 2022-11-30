package rummikub.common.event;

import com.sun.istack.internal.Nullable;
import rummikub.common.Tile;
import rummikub.common.TileGroup;
import rummikub.common.enums.GameStatus;
import rummikub.common.enums.TileColor;
import rummikub.common.util.Sort;

import java.util.ArrayList;

public class AI {
    public int first = 0;
    public boolean registered = false;
    public static ArrayList<AI> ai = new ArrayList<>();
    public ArrayList<Tile> tile = new ArrayList<>();

    public void turn() throws InterruptedException {
        useTile();
        Thread.sleep(100);
        Game.status = Game.status == GameStatus.AI_TURN ? GameStatus.AI2_TURN : GameStatus.AI_TURN;
        Console.playing();
    }

    public void useTile() {
        ArrayList<TileGroup> tileGroup = new ArrayList<>();
        for (int i=0; i<2; i++) {
            if (i==0)
                Sort.number(this.tile);
            else
                Sort.color(this.tile);
            ArrayList<Tile> tileList = new ArrayList<>();
            int min = 15, max = -1, number = 0;
            TileColor color = null;
            ArrayList<TileColor> colors = new ArrayList<>();
            System.out.println(TileGroup.list(this.tile));
            for (int j=0; j<tile.size(); j++) {
                Tile value = tile.get(j);
                if (tileList.size() < 1) {
                    tileList.add(value);
                    min = max = number = value.number;
                    color = value.color;
                } else if (i == 0) {
                    System.out.println("color : "+value.color+", number : "+value.number+", first : "+this.first);
                    if (value.number != number) {
                        colors = new ArrayList<>();
                        tileList = new ArrayList<>();
                        tileList.add(value);
                        min = max = number = value.number;
                        color = value.color;
                        colors.add(value.color);
                    } else {
                        for (int k=0; k<tileList.size(); k++) {
                            Tile value2 = tileList.get(k);
                            if (!colors.contains(value2.color)) {
                                colors.add(value2.color);
                                tileList.add(value2);
                            } else {
                                if (value2.number == number)
                                    continue;
                                colors = new ArrayList<>();
                                tileList = new ArrayList<>();
                                tileList.add(value);
                                number = value.number;
                                color = value.color;
                                colors.add(value2.color);
                            }
                        }
                    }
                } else if (i == 1 && color == value.color) {
                    if (min - 1 == value.number) {
                        tileList.add(value);
                        min--;
                    } else if (max + 1 == value.number) {
                        tileList.add(value);
                        max++;
                    } else {
                        if (value.number == number)
                            continue;
                        tileList = new ArrayList<>();
                        tileList.add(value);
                        min = max = number = value.number;
                        color = value.color;
                    }
                } else {
                    tileList = new ArrayList<>();
                    tileList.add(value);
                    min = max = number = value.number;
                    color = value.color;
                }
                if (tileList.size() >= 3) {
                    tileGroup.add(new TileGroup(tileList));
                    colors = new ArrayList<>();
                    for (Tile tile : tileList) {
                        this.first += tile.number;
                        this.tile.remove(tile);
                        j--;
                    }
                    tileList = new ArrayList<>();
                }
            }
        }
        if (Game.unusedTiles.size() < 1)
            return;
        if (first >= 30) {
            this.registered = true;
            this.first = -1;
            Game.tileGroups.addAll(tileGroup);
        } else if (first == -1) {
            if (tileGroup.size() > 0)
                Game.tileGroups.addAll(tileGroup);
            else
                this.tile.add(Game.unusedTiles.remove(0));
        } else {
            for (TileGroup group : tileGroup)
                this.tile.addAll(group.tiles);
            this.first = 0;
            this.tile.add(Game.unusedTiles.remove(0));
        }
    }
}
