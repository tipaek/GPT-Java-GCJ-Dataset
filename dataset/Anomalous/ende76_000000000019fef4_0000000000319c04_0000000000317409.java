import java.util.Scanner;

public class Solution {

    private static int manhattanDistance(int x1, int y1) {
        return Math.abs(x1) + Math.abs(y1);
    }

    private static int findMinimumTime(int startX, int startY, String movements) {
        int currentX = startX;
        int currentY = startY;

        for (int minute = 0; minute < movements.length(); minute++) {
            char move = movements.charAt(minute);
            switch (move) {
                case 'N':
                    currentY += 1;
                    break;
                case 'S':
                    currentY -= 1;
                    break;
                case 'E':
                    currentX += 1;
                    break;
                case 'W':
                    currentX -= 1;
                    break;
            }

            if (manhattanDistance(currentX, currentY) <= minute + 1) {
                return minute + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String movements = scanner.next();

            int result = findMinimumTime(startX, startY, movements);

            System.out.printf("Case #%d: %s\n", testCase, result == -1 ? "IMPOSSIBLE" : result);
        }

        scanner.close();
    }
}