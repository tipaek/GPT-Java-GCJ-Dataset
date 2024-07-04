import java.io.*;
import java.util.*;

public class Solution {
    public static int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static boolean isOdd(long value) {
        return Math.abs(value % 2) == 1;
    }

    public static boolean step(String path, long destX, long destY, long x, long y, int i) {
        //System.out.println("Exploring " + x + ", " + y + " path: " + path);

        if (i >= 10) {
            return false;
        }

        // overshot
        long dist = (long)Math.pow(2, i - 1);
        long xDiff = Math.abs(x - destX);
        long yDiff = Math.abs(y - destY);
        if ((xDiff > 0 && xDiff < dist) || (yDiff > 0 && yDiff < dist)) {
            //System.out.println("overshot");
            return false;
        }

        if (x == destX && y == destY) {
            System.out.println(path);
            return true;
        }

        boolean xSols, ySols;

        if (x < destX) {
            xSols = step(path + "E", destX, destY, x + dist, y,  i + 1) || step(path + "W", destX, destY, x - dist, y,  i + 1);
        } else {
            xSols = step(path + "W", destX, destY, x - dist, y,  i + 1) || step(path + "E", destX, destY, x + dist, y,  i + 1);
        }

        if (y < destY) {
            ySols = step(path + "N", destX, destY, x, y + dist,i + 1) || step(path + "S", destX, destY, x, y - dist,  i + 1);
        } else {
            ySols = step(path + "S", destX, destY, x, y - dist,  i + 1) || step(path + "N", destX, destY, x, y + dist,i + 1);
        }

        return xSols || ySols;
    }

    public static void solve(long destX, long destY) {
        if (Solution.isOdd(destX) == Solution.isOdd(destY)) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        if (!step("", destX, destY, 0, 0, 1)) {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int q = 1; q <= t; ++q) {
            System.out.print("Case #" + q + ": ");
            long destX = in.nextLong(), destY = in.nextLong();
            Solution.solve(destX, destY);
        }
    }
}