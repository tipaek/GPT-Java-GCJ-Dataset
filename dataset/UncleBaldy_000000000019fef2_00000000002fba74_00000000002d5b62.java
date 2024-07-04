import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            String[] line = in.readLine().split(" ");
            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);
            String y = solve(X, Y);
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }

    static String solve(int X, int Y) {
        int[] x = new int[1398101];
        int[] y = new int[x.length];
        String[] path = new String[x.length];
        path[0] = "";
        int len = 1;
        for (int i = 0, d = 1; d < 1<<10; d *= 2) {
            for (int lim = len; i < lim; i++) {
                path[len] = path[i] + "N";
                x[len] = x[i];
                y[len] = y[i] + d;
                if (x[len] == X && y[len] == Y) return path[len];
                len++;
                path[len] = path[i] + "S";
                x[len] = x[i];
                y[len] = y[i] - d;
                if (x[len] == X && y[len] == Y) return path[len];
                len++;
                path[len] = path[i] + "E";
                x[len] = x[i] + d;
                y[len] = y[i];
                if (x[len] == X && y[len] == Y) return path[len];
                len++;
                path[len] = path[i] + "W";
                x[len] = x[i] - d;
                y[len] = y[i];
                if (x[len] == X && y[len] == Y) return path[len];
                len++;
            }
        }
        return "IMPOSSIBLE";
    }
}
