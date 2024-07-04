import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner in;

    public static int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static String solve(int x, int y, String path) {
        int time = 0;
        if (manhattan(0, 0, x, y) <= time) {
            return Integer.toString(time);
        }
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                case 'W':
                    x--;
            }
            time++;

            // System.out.println(String.format("x = %d y = %d time = %d", x, y, time));
            if (manhattan(0, 0, x, y) <= time) {
                return Integer.toString(time);
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Solution.in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {

            int x, y;
            x = in.nextInt(); y = in.nextInt();
            String path = in.next();

            System.out.println("Case #" + caseNumber + ": " + solve(x, y, path));
        }
    }
}
