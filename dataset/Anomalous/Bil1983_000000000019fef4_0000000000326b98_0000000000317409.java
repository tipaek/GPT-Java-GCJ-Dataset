import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            solve(test);
        }
    }

    static void solve(int test) {
        int X = sc.nextInt();
        int Y = sc.nextInt();
        String path = sc.next();

        if (X == 0 && Y == 0) {
            printResult(test, 0);
            return;
        }

        if ((X + Y) % 2 == 1) {
            if (moveFirstStep(path.charAt(0), new int[]{X, Y})) {
                printResult(test, 1);
                return;
            }

            for (int i = 1; i < path.length(); i++) {
                if (moveStep(path.charAt(i), new int[]{X, Y})) {
                    printResult(test, i + 1);
                    return;
                }
            }
        } else {
            for (int i = 0; i < path.length(); i++) {
                if (moveStep(path.charAt(i), new int[]{X, Y})) {
                    printResult(test, i + 1);
                    return;
                }
            }
        }

        printResult(test, "IMPOSSIBLE");
    }

    static boolean moveFirstStep(char direction, int[] coordinates) {
        switch (direction) {
            case 'N':
                coordinates[1]++;
                break;
            case 'S':
                coordinates[1]--;
                break;
            case 'E':
                coordinates[0]++;
                break;
            case 'W':
                coordinates[0]--;
                break;
        }
        return coordinates[0] == 0 && coordinates[1] == 0;
    }

    static boolean moveStep(char direction, int[] coordinates) {
        switch (direction) {
            case 'S':
                coordinates[1]--;
                coordinates[0]--;
                break;
            case 'W':
                coordinates[0]--;
                coordinates[1]--;
                break;
        }
        return coordinates[0] == 0 && coordinates[1] == 0;
    }

    static void printResult(int test, Object result) {
        System.out.println("Case #" + test + ": " + result);
    }
}