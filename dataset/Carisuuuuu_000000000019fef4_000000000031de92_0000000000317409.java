import java.awt.*;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;
    private static final PrintStream LOG = System.err;

    public static void main(String[] args) {
        int t = IN.nextInt();
        for (int g = 1; g <= t; ++g) {
            int x = IN.nextInt();
            int y = IN.nextInt();
            String m = IN.next();
            if (m.length() < x) {
                response(g, "IMPOSSIBLE");
                continue;
            }
            m = new StringBuffer(m.length()+1).append(m).insert(x, ',').toString();
            String [] routes = m.split(",", -1);
            y -= routes[0].replaceAll("N", "").length();
            y += routes[0].replaceAll("S", "").length();
            if (routes[1].length() < y/2) {
                response(g, "IMPOSSIBLE");
                continue;
            }
            final boolean north = y > 0;
            int i;
            for (i = 0; i < routes[1].length() && !atEnd(y, north); ++i) {
                if (routes[1].charAt(i) == 'N' && !north) {
                    y += 2;
                }
                if (routes[1].charAt(i) == 'S' && north) {
                    y -= 2;
                }
            }
            if (atEnd(y, north)) {
                response(g, x+i);
            } else {
                response(g, "IMPOSSIBLE");
            }
        }
    }

    private static boolean atEnd(int y, boolean north) {
        return y == 0 || Math.abs(y) == 1 && north != y > 0;
    }

    private static <R> void response(int go, R message) {
        OUT.println("Case #" + go + ": " + message);
    }
}