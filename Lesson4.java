import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '.';

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {

            humanTurn();
            printMap();
            if (isWinner(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (isWinner(DOT_O)) {
                System.out.println("Победил Т-1000");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            System.out.print((row + 1) + " ");
            for (int column = 0; column < SIZE; column++) {
                System.out.print(map[row][column] + " ");
            }
            System.out.println();
        }
    }
    public static void humanTurn() {
        Scanner scanner = new Scanner(System.in);

        int x;
        int y;

        do {
            System.out.println("Введите координаты в стиле X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        Random random = new Random();

        int x;
        int y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));

        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));

        map[y][x] = DOT_O;
    }


    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean isWinner(char symb) {
        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) {
            return true;
        }
        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) {
            return true;
        }
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) {
            return true;
        }
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) {
            return true;
        }
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) {
            return true;
        }
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) {
            return true;
        }
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) {
            return true;
        }
        if (map[0][2] == symb && map[1][1] == symb && map[2][0] == symb) {
            return true;
        }
        return false;
    }
    public static boolean isMapFull () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY) {
                    return true;
                }
            }
            return true;
        }
    }
























