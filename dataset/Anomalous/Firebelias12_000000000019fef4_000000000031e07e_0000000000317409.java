import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the number of cases

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int currentX = 0;
            int currentY = 0;

            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the coordinates

            String path = scanner.nextLine();
            int steps = 0;

            for (int pathIndex = 0; pathIndex < path.length(); pathIndex++) {
                if (currentX == targetX && currentY == targetY) {
                    break;
                }

                char direction = path.charAt(pathIndex);
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

                steps++;
            }

            if (currentX == targetX && currentY == targetY) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + steps);
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}