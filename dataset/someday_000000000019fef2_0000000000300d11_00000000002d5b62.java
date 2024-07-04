import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = findPath(x, y, 0, 0, 0);
            System.out.println("Case #" + i + ": " + (result == null ? "IMPOSSIBLE" : result));
        }

        scanner.close();
    }

    public static String findPath(int targetX, int targetY, int x, int y, int nthJump) {
        int steps = (int) Math.pow(2, nthJump);

        if (x == targetX && y + steps == targetY) {
            return "N";
        }
        if (x + steps == targetX && y == targetY) {
            return "E";
        }
        if (x == targetX && y - steps == targetY) {
            return "S";
        }
        if (x - steps == targetX && y == targetY) {
            return "W";
        }
        
        if (steps > Math.abs(targetX) + Math.abs(targetY)) {
            return null;
        }

        String r1 = findPath(targetX, targetY, x, y + steps, nthJump + 1); // n
        if (r1 != null) {
            return "N" + r1;
        }

        String r2 = findPath(targetX, targetY, x + steps, y, nthJump + 1); // e
        if (r2 != null) {
            return "E" + r2;
        }

        String r3 = findPath(targetX, targetY, x, y - steps, nthJump + 1); // s
        if (r3 != null) {
            return "S" + r3;
        }

        String r4 = findPath(targetX, targetY, x - steps, y, nthJump + 1); // w
        if (r4 != null) {
            return "W" + r4;
        }

        return null;
    }
}