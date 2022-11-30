package rummikub.common.event;

import com.sun.istack.internal.Nullable;
import rummikub.common.Tile;
import rummikub.common.TileGroup;
import rummikub.common.enums.GameMode;
import rummikub.common.enums.GameStatus;
import rummikub.common.enums.TileColor;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    public static GameMode mode;
    public static GameStatus status = GameStatus.NOT_PLAYING;
    public static ArrayList<Tile> unusedTiles = new ArrayList<>();
    public static ArrayList<TileGroup> tileGroups = new ArrayList<>();
    @Nullable
    public static String winner;

    public static void init() {
        // 타일들을 추가하고 셔플
        for (int i=1;i<=13;i++)
            for (TileColor color : TileColor.values())
                for (int j=0; j<2; j++)
                    unusedTiles.add(new Tile(i, color));
//        unusedTiles.add(new Tile(0, TileColor.RED));
//        unusedTiles.add(new Tile(0, TileColor.WHITE));
        Collections.shuffle(unusedTiles);

        // Player와 AI에게 각각 14개의 타일 주기
        AI.ai.add(new AI());
        if (Game.mode == GameMode.PLAYER_VS_AI)
            for (int i=0; i<14; i++) {
                AI.ai.get(0).tile.add(unusedTiles.remove(0));
                Player.tile.add(unusedTiles.remove(0));
            }
        else {
            AI.ai.add(new AI());
            for (int i = 0; i < 14; i++) {
                AI.ai.get(0).tile.add(unusedTiles.remove(0));
                AI.ai.get(1).tile.add(unusedTiles.remove(0));
            }
        }
        System.out.println(unusedTiles.size());
    }

    public static void inspection() throws InterruptedException {
        if (Game.mode == GameMode.PLAYER_VS_AI && Player.tile.size() < 1) {
            Game.status = GameStatus.NOT_PLAYING;
            Game.winner = "Player";
        } else if (AI.ai.get(0).tile.size() < 1) {
            Game.status = GameStatus.NOT_PLAYING;
            Game.winner = "1st AI";
        } else if (Game.mode == GameMode.AI_VS_AI && AI.ai.get(1).tile.size() < 1) {
            Game.status = GameStatus.NOT_PLAYING;
            Game.winner = "2nd AI";
        }
        if (Game.unusedTiles.size() < 1) {
            if (Game.mode == GameMode.PLAYER_VS_AI) {
                int player = 0;
                int ai = 0;
                for (Tile tile: Player.tile) player -= tile.number;
                for (Tile tile: AI.ai.get(0).tile) ai -= tile.number;
                Game.winner = player > ai ? "Player" : "1st AI";
            } else {
                int ai1 = 0;
                int ai2 = 0;
                for (Tile tile: AI.ai.get(0).tile) ai1 -= tile.number;
                for (Tile tile: AI.ai.get(1).tile) ai2 -= tile.number;
                Game.winner = ai1 > ai2 ? "1st AI" : "2nd AI";
            }
        }
        if (Game.winner != null)
            Console.winner();
        else
            Console.playing();
    }
}
