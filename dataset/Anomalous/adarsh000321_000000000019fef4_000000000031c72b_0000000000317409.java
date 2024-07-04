import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            int targetY = scanner.nextInt();
            int targetX = scanner.nextInt();
            String directions = scanner.next();
            int currentY = 0, currentX = 0;
            int minimumSteps = Integer.MAX_VALUE;

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                if (direction == 'S') {
                    currentY++;
                } else if (direction == 'N') {
                    currentY--;
                } else if (direction == 'E') {
                    currentX--;
                } else if (direction == 'W') {
                    currentX++;
                }

                if (i + 1 >= calculateDistance(currentY, currentX, targetY, targetX)) {
                    minimumSteps = i + 1;
                    break;
                }
            }

            if (minimumSteps == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(minimumSteps);
            }
        }
    }

    static int calculateDistance(int currentY, int currentX, int targetY, int targetX) {
        return Math.abs(currentY - targetY) + Math.abs(currentX - targetX);
    }
}