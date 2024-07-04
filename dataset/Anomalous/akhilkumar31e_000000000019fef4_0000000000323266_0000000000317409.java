import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final int IMPOSSIBLE = 100000;

    public static int findMinimumSteps(int startX, int startY, int targetX, int targetY, String path, int stepIndex) {
        if (startX == targetX && startY == targetY) {
            return 0;
        }
        if (stepIndex == path.length()) {
            return IMPOSSIBLE;
        }

        int minSteps = IMPOSSIBLE;
        char direction = path.charAt(stepIndex);

        switch (direction) {
            case 'N':
                targetY++;
                break;
            case 'S':
                targetY--;
                break;
            case 'E':
                targetX++;
                break;
            case 'W':
                targetX--;
                break;
        }

        minSteps = Math.min(minSteps, 1 + findMinimumSteps(startX, startY, targetX, targetY, path, stepIndex + 1));
        minSteps = Math.min(minSteps, 1 + findMinimumSteps(startX + 1, startY, targetX, targetY, path, stepIndex + 1));
        minSteps = Math.min(minSteps, 1 + findMinimumSteps(startX, startY + 1, targetX, targetY, path, stepIndex + 1));
        minSteps = Math.min(minSteps, 1 + findMinimumSteps(startX - 1, startY, targetX, targetY, path, stepIndex + 1));
        minSteps = Math.min(minSteps, 1 + findMinimumSteps(startX, startY - 1, targetX, targetY, path, stepIndex + 1));

        return minSteps;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] input = reader.readLine().split(" ");
            int targetX = Integer.parseInt(input[0]);
            int targetY = Integer.parseInt(input[1]);
            String path = input[2];

            int result = findMinimumSteps(0, 0, targetX, targetY, path, 0);

            if (result != IMPOSSIBLE) {
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}