
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    static List<String> moves = new ArrayList<>();

    static void go(int fromX, int fromY, int X, int Y, Integer stop, String step) {
        int dis = (int) Math.pow(2, stop);
        if (Math.abs(fromX) > Math.abs(X) || Math.abs(fromY) > Math.abs(Y)) {
            return;
        }

        if (fromX == X && fromY == Y) {
            moves.add(step);
        }

        go(fromX + dis, fromY, X, Y, new Integer(stop + 1), new String(step + "E"));
        go(fromX - dis, fromY, X, Y, new Integer(stop + 1), new String(step + "W"));
        go(fromX, fromY + dis, X, Y, new Integer(stop + 1), new String(step + "N"));
        go(fromX, fromY - dis, X, Y, new Integer(stop + 1), new String(step + "S"));
    }

    public static void main(String[] args) {
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int X = in.nextInt();
            int Y = in.nextInt();

            int tmpX = Math.abs(X);
            int tmpY = Math.abs(Y);
            String flag = "IMPOSSIBLE";
            if (tmpX % 2 == 1 && tmpY % 2 == 1) {
                flag = "";
            } else {
                boolean fX = false;
                boolean fY = false;
                if ((tmpX + 1) % 4 == 0 || tmpX % 4 == 0) {
                    fX = true;
                }
                if ((tmpY + 1) % 4 == 0 || tmpY % 4 == 0) {
                    fY = true;
                }
                if (fX || fY) {
                    go(0, 0, X, Y, 0, "");
                    if (!moves.isEmpty()) {
                        Collections.sort(moves);
                        flag = moves.get(0);
                    }
                } 
            }

            String res = "Case #" + t + ": " + flag;
            System.out.println(res);
            moves.clear();
        }
    }
}
