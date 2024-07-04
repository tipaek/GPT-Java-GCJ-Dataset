import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            result.append("Case #").append(caseNum).append(": ");
            int targetY = scanner.nextInt();
            int targetX = scanner.nextInt();
            String directions = scanner.next();
            int currentX = 0, currentY = 0;
            int minimumTime = Integer.MAX_VALUE;

            for (int i = 0; i < directions.length(); i++) {
                char move = directions.charAt(i);
                switch (move) {
                    case 'S':
                        currentY++;
                        break;
                    case 'N':
                        currentY--;
                        break;
                    case 'E':
                        currentX--;
                        break;
                    case 'W':
                        currentX++;
                        break;
                }

                if (i + 1 >= calculateDistance(currentX, currentY, targetX, targetY)) {
                    minimumTime = i + 1;
                    break;
                }
            }

            if (minimumTime == Integer.MAX_VALUE) {
                result.append("IMPOSSIBLE");
            } else {
                result.append(minimumTime);
            }

            if (caseNum != testCases) {
                result.append("\n");
            }
        }

        System.out.print(result);
    }

    static int calculateDistance(int currentX, int currentY, int targetX, int targetY) {
        return Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
    }
}