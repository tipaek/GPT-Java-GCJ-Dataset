import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            resultBuilder.append("Case #").append(caseIndex).append(": ");
            int targetY = scanner.nextInt();
            int targetX = scanner.nextInt();
            String directions = scanner.next();
            int currentY = 0, currentX = 0;
            int minimumTime = Integer.MAX_VALUE;

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
                    minimumTime = i + 1;
                    break;
                }
            }

            if (minimumTime == Integer.MAX_VALUE) {
                resultBuilder.append("IMPOSSIBLE");
            } else {
                resultBuilder.append(minimumTime);
            }

            if (caseIndex != numberOfCases) {
                resultBuilder.append("\n");
            }
        }

        System.out.print(resultBuilder);
    }

    private static int calculateDistance(int currentY, int currentX, int targetY, int targetX) {
        return Math.abs(currentY - targetY) + Math.abs(currentX - targetX);
    }
}