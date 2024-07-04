import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[] moves = in.next().toCharArray();

            int meet = meetAtMinute(n, m, moves);
            System.out.println("Case #" + i + ": " + (meet == -1 ? "IMPOSSIBLE" : meet));
        }
    }

    public static int meetAtMinute(int x, int y, char[] moves) {
        int rollingX = x;
        int rollingY = y;
        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case 'N': rollingY += 1; break;
                case 'S': rollingY -= 1; break;
                case 'E': rollingX += 1; break;
                case 'W': rollingX -= 1; break;
            }

            if (canIBeThere(rollingX, rollingY, i+1)) {
                return i+1;
            }

        }
        return -1;
    }

    public static boolean canIBeThere(int x, int y, int minute) {
        int distance = Math.abs(x) + Math.abs(y);
        return minute >= distance;
    }


}