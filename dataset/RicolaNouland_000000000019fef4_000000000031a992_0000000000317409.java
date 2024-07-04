import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;


public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String[] line = in.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            String path = line[2];

            String result = solve(x, y, path);

            System.out.println(String.format("Case #%d: %s", i, result));
        }

    }

    private static String solve(int x, int y, String path) {
        int d = x + y;

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (!goingAway(x, y, c)) {
                d -= 2;
            }
            if (d <= 0) return "" + (i + 1);
            switch (c) {
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }
        }
        return "IMPOSSIBLE";
    }

    public static boolean goingAway(int x, int y, char c) {
        switch (c) {
            case 'S':
                return y <= 0;
            case 'N':
                return y >= 0;
            case 'W':
                return x <= 0;
            case 'E':
                return x >= 0;
        }
        return false;
    }

    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] lineToInt(String line) {
        return lineToInt(line, " ");
    }
}