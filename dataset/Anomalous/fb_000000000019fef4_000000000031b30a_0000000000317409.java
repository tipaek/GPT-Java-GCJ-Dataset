import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        int initialX = scanner.nextInt();
        int initialY = scanner.nextInt();
        String movements = scanner.next();

        int currentX = 0;
        int currentY = 0;

        if (initialX == 0 && initialY == 0) {
            System.out.println("Case #" + caseId + ": 0");
            return;
        }

        for (int i = 0; i < movements.length(); i++) {
            char move = movements.charAt(i);
            switch (move) {
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
                default:
                    throw new IllegalArgumentException("Invalid movement character: " + move);
            }

            if (Math.abs(currentY + initialY) + Math.abs(currentX + initialX) <= i + 1) {
                System.out.println("Case #" + caseId + ": " + (i + 1));
                return;
            }
        }

        System.out.println("Case #" + caseId + ": IMPOSSIBLE");
    }
}