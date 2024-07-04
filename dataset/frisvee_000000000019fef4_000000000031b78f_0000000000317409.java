import java.io.*;
import java.util.*;

public class Solution {
    private static String solve(int x, int y, String s) {
        int xx = x, yy = y;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'S': yy--; break;
                case 'N': yy++; break;
                case 'W': xx--; break;
                case 'E': xx++; break;
            }

            int dist = Math.abs(xx) + Math.abs(yy);
            if (dist <= (i + 1)) {
                return Integer.toString(i + 1);
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.nextLine().trim();

            System.out.println("Case #" + t + ": " + solve(X, Y, M));
        }

        in.close();
    }
}