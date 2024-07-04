import java.util.Scanner;

public class CJ_20R1C_PEPPURR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int currentX = 0;
            int currentY = 0;

            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            int steps = 0;
            scanner.nextLine();  // Consume the newline character
            String movements = scanner.nextLine();

            boolean reached = false;
            for (int moveIndex = 0; moveIndex < movements.length(); moveIndex++) {
                if (currentX == targetX && currentY == targetY) {
                    reached = true;
                    break;
                }

                char move = movements.charAt(moveIndex);

                switch (move) {
                    case 'N':
                        targetY++;
                        break;
                    case 'S':
                        targetY--;
                        break;
                    case 'W':
                        targetX--;
                        break;
                    case 'E':
                        targetX++;
                        break;
                    default:
                        continue;
                }

                if (currentX != targetX) {
                    currentX++;
                } else if (currentY != targetY) {
                    currentY++;
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