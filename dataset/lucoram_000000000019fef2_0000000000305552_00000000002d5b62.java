
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static boolean found;
    static String path;
    static int[] target;
    static char[] enws = { 'E', 'N', 'W', 'S' };

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        outer: for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            found = false;
            path = "";
            target = new int[] { x, y };

            for (char start : enws) {
                String currentPath = path + start;
                int[] newXY = doJump(start, 1, new int[] { 0, 0 });
                check(currentPath, 1, newXY);
                if (found) {
                    System.out.println("Case #" + i + ": " + path);
                    continue outer;
                }
            }

            System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }

    private static void check(String currentPath, int pow, int[] newXY) {
        if (eq(newXY)) {
            found = true;
            path = path.isEmpty() || currentPath.length() < path.length() ? currentPath : path;
        }

        if (pow > 10) {
            return;
        }

        // if (outside(newXY)) {
        //     return;
        // }

        for (char start : enws) {
            int jump = (int) Math.pow(2, pow);
            String newPath = currentPath + start;
            int[] newNewXY = doJump(start, jump, newXY);
            check(newPath, pow + 1, newNewXY);
        }
    }

    private static int[] doJump(char start, int jump, int[] oldXY) {
        int[] newXY = Arrays.copyOf(oldXY, 2);

        if (start == 'E') {
            newXY[0] += jump;
        } else if (start == 'N') {
            newXY[1] += jump;
        } else if (start == 'W') {
            newXY[0] -= jump;
        } else {
            newXY[1] -= jump;
        }

        return newXY;
    }

    private static boolean eq(int[] right) {
        return target[0] == right[0] && right[1] == target[1];
    }

    private static boolean outside(int[] right) {
        return Math.abs(target[0]) < Math.abs(right[0]) || Math.abs(target[1]) < Math.abs(right[1]);
    }
}