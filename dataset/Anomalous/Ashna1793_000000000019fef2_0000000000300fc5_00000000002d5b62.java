import java.util.*;
import java.io.*;

public class Solution {
    static String answer;

    public static String findPath(int X, int Y) {
        answer = "";
        StringBuilder path = new StringBuilder();
        explorePath(0, 0, X, Y, path, 1);
        return answer.isEmpty() ? "IMPOSSIBLE" : answer;
    }

    public static void explorePath(int currentX, int currentY, int targetX, int targetY, StringBuilder path, int step) {
        if (currentX == targetX && currentY == targetY) {
            String currentPath = path.toString();
            if (answer.isEmpty() || currentPath.length() < answer.length()) {
                answer = currentPath;
            }
            return;
        }

        if (Math.abs(currentX) > Math.abs(targetX) || Math.abs(currentY) > Math.abs(targetY)) {
            return;
        }

        int stepValue = (int) Math.pow(2, step - 1);
        step++;

        // Move North
        path.append('N');
        explorePath(currentX, currentY + stepValue, targetX, targetY, path, step);
        path.deleteCharAt(path.length() - 1);

        // Move South
        path.append('S');
        explorePath(currentX, currentY - stepValue, targetX, targetY, path, step);
        path.deleteCharAt(path.length() - 1);

        // Move East
        path.append('E');
        explorePath(currentX + stepValue, currentY, targetX, targetY, path, step);
        path.deleteCharAt(path.length() - 1);

        // Move West
        path.append('W');
        explorePath(currentX - stepValue, currentY, targetX, targetY, path, step);
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String result = findPath(X, Y);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}