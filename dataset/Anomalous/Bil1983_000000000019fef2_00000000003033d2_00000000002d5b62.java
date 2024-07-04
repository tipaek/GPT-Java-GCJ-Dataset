import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            solve(test);
        }
    }

    static void solve(int test) {
        char[] directions = {'N', 'S', 'E', 'W'};
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int maxSteps = (int) (Math.log(Math.max(Math.abs(X), Math.abs(Y))) / Math.log(2)) + 2;

        for (int i = maxSteps / 2; i <= maxSteps; i++) {
            int combinations = (int) Math.pow(4, i);
            for (int j = 0; j < combinations; j++) {
                String s = String.format("%0" + i + "d", Integer.parseInt(Integer.toString(j, 4)))
                        .replaceAll("0", "N")
                        .replaceAll("1", "E")
                        .replaceAll("2", "S")
                        .replaceAll("3", "W");

                if (isValidPath(s, X, Y)) {
                    System.out.println("Case #" + test + ": " + s);
                    return;
                }
            }
        }
        System.out.println("Case #" + test + ": IMPOSSIBLE");
    }

    static boolean isValidPath(String path, int targetX, int targetY) {
        int[] position = move(path);
        return position[0] == targetX && position[1] == targetY;
    }

    static int[] move(String path) {
        int[] position = new int[2];
        for (int i = 0; i < path.length(); i++) {
            int step = (int) Math.pow(2, i);
            switch (path.charAt(i)) {
                case 'N':
                    position[1] += step;
                    break;
                case 'S':
                    position[1] -= step;
                    break;
                case 'E':
                    position[0] += step;
                    break;
                case 'W':
                    position[0] -= step;
                    break;
            }
        }
        return position;
    }
}