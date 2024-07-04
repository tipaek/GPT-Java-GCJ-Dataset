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
            String M = line[2];
            String y = solve(X, Y, M);
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }

    static String solve(int X, int Y, String M) {
        if (X == 0 && Y == 0)
            return "0";
        int m  = 0;
        for (int i = 0; i < M.length(); i++) {
            char d = M.charAt(i);
            if (d == 'N')
                Y++;
            if (d == 'S')
                Y--;
            if (d == 'E')
                X++;
            if (d == 'W')
                X--;
            m++;
            if (Math.abs(X) + Math.abs(Y) <= m)
                return m+"";
        }
        return "IMPOSSIBLE";
    }
}
