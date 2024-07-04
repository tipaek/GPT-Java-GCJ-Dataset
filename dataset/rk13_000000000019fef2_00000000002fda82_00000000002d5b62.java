import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    static int X,Y;
    enum Directions {
        N,
        S,
        E,
        W
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(
                in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            String[] s = in.nextLine().split(" ");
             X = Integer.parseInt(s[0]);
             Y = Integer.parseInt(s[1]);

            if (X % 2 == 1 && Y % 2 == 1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int max = log2(Math.abs(X) + Math.abs(Y));

            ArrayList<Directions> path = new ArrayList<>();
            String resultv = "IMPOSSIBLE";
            if (nextsss(0, max+1, path)) {
                resultv = path.stream().map(Directions::toString).collect(Collectors.joining(""));
            }

            System.out.println("Case #" + i + ": "+resultv);
        }
    }

    private static boolean nextsss(int pos, int max, List<Directions> path) {
        if (path.size() == max) {
            return checkPath(path);
        }

        for(Directions d : Directions.values()) {
            path.add(d);
            if (nextsss(pos + 1, max, path)) {
                return true;
            }
            path.remove(pos);
        }
        return false;
    }

    private static boolean checkPath(List<Directions> path) {
        int n = 1;
        int x = 0;
        int y = 0;
        for(Directions d : path) {
            switch (d) {
                case N:
                    y += n;
                    break;
                case S:
                    y -= n;
                    break;
                case E:
                    x += n;
                    break;
                case W:
                    x -= n;
                    break;
            }
            n = n * 2;
        }
        return x == X && y == Y;
    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}
