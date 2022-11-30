package rummikub.common.event;

import rummikub.common.TileList;
import rummikub.common.status.GameStatus;
import rummikub.common.util.Color;

import java.util.Scanner;

public class Console {
    public static void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void init() {
        Console.clear();
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println();
        System.out.println("                        "+Color.CYAN.toString("Rummikub"));
        System.out.println();
        System.out.println("                    "+Color.YELLOW.toString("Press the Number"));
        System.out.println();
        System.out.println("                  "+Color.GREEN.toString("1. ")+Color.PURPLE.toString("Play Player vs AI"));
        System.out.println("                      "+Color.RED.toString("2. ")+Color.PURPLE.toString("Nothing ;("));
        System.out.println();
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        Scanner sc = new Scanner(System.in);
        System.out.print("Number : ");
        int number = sc.nextInt();
        if (number == 1) {
            Game.status = GameStatus.PLAYER_TURN;
            Console.playing();
        } else
            Console.init();
    }

    public static void playing() {
        Console.clear();
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println("                      현재 턴 : "+Color.YELLOW.toString(Game.status.nowPlayer()));
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println("                      "+Color.YELLOW.toString("AI")+"의 타일 : "+Color.RED.toString(AI.tile.size())+"개");
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println("                     현재 타일 그룹 : "+Color.RED.toString(TileList.group.size())+"개");
        System.out.println();
        for (int i=0;i<TileList.group.size(); i++) {
            System.out.println((i+1)+". "+TileList.group.get(i).list());
        }
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println("                       "+Color.YELLOW.toString("Player")+"의 타일");
        System.out.println(Player.printTile());
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
    }
}
