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

    private static void execute(Scanner scanner, PrintStream out) {
        int testCaseCount = scanner.nextInt();
        for (int i = 1; i <= testCaseCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            int time = calculateTime(x, y, path);
            String result = (time >= 0) ? String.valueOf(time) : "IMPOSSIBLE";
            out.printf("Case #%d: %s%n", i, result);
        }
    }

    private static int calculateTime(int x, int y, String path) {
        int pathLength = path.length();
        int currentX = x;
        int currentY = y;

        for (int i = 0; i < pathLength; i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'N':
                    currentY++;
                    break;
                case 'S':
                    currentY--;
                    break;
                case 'E':
                    currentX++;
                    break;
                case 'W':
                    currentX--;
                    break;
            }

            int elapsedTime = i + 1;
            int distanceToTarget = Math.abs(currentX) + Math.abs(currentY);
            if (elapsedTime >= distanceToTarget) {
                return elapsedTime;
            }
        }
        return -1;
    }
}