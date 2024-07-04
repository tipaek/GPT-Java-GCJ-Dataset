import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int findPath(int startX, int startY, int targetX, int targetY, String path, int step) {
        if (startX == targetX && startY == targetY) return 0;
        if (step == path.length()) return Integer.MAX_VALUE;

        int minSteps = Integer.MAX_VALUE;
        char direction = path.charAt(step);

        switch (direction) {
            case 'N': targetY++; break;
            case 'S': targetY--; break;
            case 'E': targetX++; break;
            case 'W': targetX--; break;
        }

        minSteps = Math.min(minSteps, 1 + findPath(startX, startY, targetX, targetY, path, step + 1));
        minSteps = Math.min(minSteps, 1 + findPath(startX + 1, startY, targetX, targetY, path, step + 1));
        minSteps = Math.min(minSteps, 1 + findPath(startX, startY + 1, targetX, targetY, path, step + 1));
        minSteps = Math.min(minSteps, 1 + findPath(startX, startY - 1, targetX, targetY, path, step + 1));

        return minSteps;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] input = reader.readLine().split(" ");
            int targetX = Math.abs(Integer.parseInt(input[0]));
            int targetY = Math.abs(Integer.parseInt(input[1]));
            String path = input[2];

            int result = findPath(0, 0, targetX, targetY, path, 0);
            if (result != Integer.MAX_VALUE) {
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}