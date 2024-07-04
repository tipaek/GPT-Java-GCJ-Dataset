import java.io.*;
import java.util.*;

public class Solution {
    private static String answer = "";

    public static void findPath(long targetX, long targetY, long step, long currentX, long currentY, String path) {
        if (Math.abs(currentX) > 4 * Math.abs(targetX) || Math.abs(currentY) > 4 * Math.abs(targetY)) {
            return;
        }
        if (currentX == targetX && currentY == targetY) {
            if (answer.isEmpty() || path.length() < answer.length()) {
                answer = path;
            }
            return;
        }

        long moveDistance = (long) Math.pow(2, step - 1);
        findPath(targetX, targetY, step + 1, currentX + moveDistance, currentY, path + "E");
        findPath(targetX, targetY, step + 1, currentX, currentY + moveDistance, path + "N");
        findPath(targetX, targetY, step + 1, currentX - moveDistance, currentY, path + "W");
        findPath(targetX, targetY, step + 1, currentX, currentY - moveDistance, path + "S");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] coordinates = reader.readLine().split(" ");
            long x = Long.parseLong(coordinates[0]);
            long y = Long.parseLong(coordinates[1]);

            findPath(x, y, 1, 0, 0, "");

            if (answer.isEmpty()) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + answer);
            }
            answer = "";
        }
    }
}