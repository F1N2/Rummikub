package rummikub.common.event;

import rummikub.common.Tile;
import rummikub.common.TileGroup;
import rummikub.common.enums.GameStatus;
import rummikub.common.enums.InputStatus;
import rummikub.common.util.Color;
import rummikub.common.util.Sort;

import java.util.*;

public class Console {
    public static void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void init() throws InterruptedException {
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

    public static void tile() {
        Console.clear();
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println((Game.status.nowPlayer().equals("AI") ? "  " : "")+"                      현재 턴 : "+Color.YELLOW.toString(Game.status.nowPlayer()));
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println("                      "+Color.YELLOW.toString("AI")+"의 타일 : "+Color.RED.toString(AI.tile.size())+"개");
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println("                     현재 타일 그룹 : "+Color.RED.toString(Game.tileGroups.size())+"개");
        if (Game.tileGroups.size() > 0)
            for (int i=0;i<Game.tileGroups.size(); i++)
                System.out.println((i+1)+". "+Game.tileGroups.get(i).list());
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
        System.out.println("                       "+Color.YELLOW.toString("Player")+"의 타일");
        System.out.println(TileGroup.list(Player.tile));
        System.out.println(Color.BLUE.toString("----------------------------------------------------------"));
    }

    public static void playing() throws InterruptedException {
        Console.tile();
        if (Game.status == GameStatus.PLAYER_TURN)
            Console.initInput();
        else
            AI.turn();
    }

    public static void initInput() throws InterruptedException {
        System.out.println(Color.RED.toString("----------------------------------------------------------"));
        System.out.println("               현재 턴에서 무엇을 할지 선택해주세요");
        System.out.println("                    "+Color.RED.toString("1. ")+"타일 그룹 선택하기");
        System.out.println("                   "+Color.RED.toString("2. ")+"여러개의 타일 선택하기");
        System.out.println("                      "+Color.RED.toString("3. ")+(
            ( Player.first >= 30 || Player.first == -1 ) && Player.registered ? Color.GREEN.toString("턴 넘기기") : "턴 스킵하기"
        ));
        System.out.println("                    "+Color.RED.toString("4. ")+"타일 숫자별로 정렬");
        System.out.println("                     "+Color.RED.toString("5. ")+"타일 색별로 정렬");
        System.out.println(Color.RED.toString("----------------------------------------------------------"));
        Scanner sc = new Scanner(System.in);
        System.out.print("Number : ");
        int number = sc.nextInt();
        switch(number) {
            case 1:
                if (Game.tileGroups.size() > 0)
                    Console.selectTileGroup();
                break;
            case 2: Console.selectTiles(); break;
            case 3: Player.skipTurn(); break;
            case 4: Sort.number(Player.tile); break;
            case 5: Sort.color(Player.tile); break;
        }
        Game.inspection();
        Console.playing();
    }

    public static void selectTileGroup() throws InterruptedException {
        Player.inputStatus = InputStatus.SELECT_GROUP;
        Console.tile();
        System.out.println(Color.RED.toString("----------------------------------------------------------"));
        System.out.println("                  수정할 타일 그룹을 선택해주세요");
        for (int i=0;i<Game.tileGroups.size(); i++)
            System.out.println((i+1)+". "+Game.tileGroups.get(i).list());
        System.out.println(Color.RED.toString("----------------------------------------------------------"));
        Scanner sc = new Scanner(System.in);
        System.out.print("Group Number : ");
        int number = sc.nextInt();
        Console.playing();
    }

    public static void selectTiles() throws InterruptedException {
        Player.inputStatus = InputStatus.SELECT_TILES;
        Console.tile();
        System.out.println(Color.RED.toString("----------------------------------------------------------"));
        System.out.println("                 그룹을 만들 타일들을 선택해주세요");
        System.out.println("                "+Color.PURPLE.toString("ex)")+" 1, 3, 5번째 타일 선택할 때");
        System.out.println("                      Tiles : "+Color.GREEN.toString("1,3,5"));
        for (int i=0; i<Player.tile.size(); i++) {
            Tile tile = Player.tile.get(i);
            System.out.println((i + 1) + ". " + tile.color.toString(tile.number));
        }
        System.out.println(Color.RED.toString("----------------------------------------------------------"));
        Scanner sc = new Scanner(System.in);
        System.out.print("Tiles : ");
        String[] str = sc.next().split(",");
        ArrayList<Integer> tileNumber = new ArrayList<>();
        ArrayList<Tile> tileList = new ArrayList<>();
        for (String number: str)
            tileNumber.add(Integer.parseInt(number));
        tileNumber.sort(Comparator.reverseOrder());
        for (int i: tileNumber)
            tileList.add(Player.tile.get(i - 1));
        int groupTest = TileGroup.canRegister(
            new ArrayList<>(Collections.singletonList(tileList))
        );
        System.out.println(TileGroup.list(tileList));
        System.out.println(groupTest);
        if (groupTest != -1) {
            Player.first += groupTest;
            if (Player.first >= 30 || Player.first == -1)
                Player.registered = true;
            TileGroup tileGroup = new TileGroup(tileList);
            Player.tempGroup.add(tileGroup);
            Game.tileGroups.add(tileGroup);
            for (int number: tileNumber)
                Player.tile.remove(number - 1);
        }
        Console.playing();
    }
}
