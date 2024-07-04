import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static String ans = "";

    private static void findPath(int targetX, int targetY, int step, int currentX, int currentY, String path) {
        if (Math.abs(currentX) > Math.abs(targetX) || Math.abs(currentY) > Math.abs(targetY)) {
            return;
        }
        if (currentX == targetX && currentY == targetY) {
            if (ans.isEmpty() || ans.length() > path.length()) {
                ans = path;
            }
            return;
        }

        int moveDistance = (int) Math.pow(2, step - 1);
        findPath(targetX, targetY, step + 1, currentX + moveDistance, currentY, path + "E");
        findPath(targetX, targetY, step + 1, currentX, currentY + moveDistance, path + "N");
        findPath(targetX, targetY, step + 1, currentX - moveDistance, currentY, path + "W");
        findPath(targetX, targetY, step + 1, currentX, currentY - moveDistance, path + "S");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int test = 1; test <= testCases; test++) {
            String[] coordinates = reader.readLine().split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            findPath(x, y, 1, 0, 0, "");
            if (ans.isEmpty()) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + ans);
            }
            ans = "";
        }
    }
}