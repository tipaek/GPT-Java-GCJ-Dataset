import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            execute(scanner, System.out);
        }
    }

    public static void execute(Scanner scanner, PrintStream out) {
        int numberOfTestCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String movementPath = scanner.next();
            int resultTime = calculateTimeToReach(startX, startY, movementPath);
            String output = (resultTime >= 0) ? String.valueOf(resultTime) : "IMPOSSIBLE";
            out.printf("Case #%d: %s%n", testCase, output);
        }
    }

    public static int calculateTimeToReach(int x, int y, String path) {
        int pathLength = path.length();
        int currentX = x;
        int currentY = y;

        for (int time = 0; time < pathLength; time++) {
            char direction = path.charAt(time);
            if (direction == 'N') {
                currentY++;
            } else if (direction == 'S') {
                currentY--;
            }

            int totalDistance = Math.abs(currentX) + Math.abs(currentY);
            if (time + 1 >= totalDistance) {
                return time + 1;
            }
        }

        return -1;
    }
}