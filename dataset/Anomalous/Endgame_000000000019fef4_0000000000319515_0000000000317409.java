import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.println("Case #" + caseNumber + ": " + findStepsToReachDestination());
        }
    }

    private static String findStepsToReachDestination() {
        int x = scanner.nextInt(); // East-West coordinate
        int y = scanner.nextInt(); // North-South coordinate
        char[] moves = scanner.next().toCharArray(); // Sequence of moves (N/E/S/W)

        for (int step = 1; step <= moves.length; step++) {
            char direction = moves[step - 1];

            switch (direction) {
                case 'E':
                    x++;
                    break;
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
            }

            if (isReachableInSteps(x, y, step)) {
                return String.valueOf(step);
            }
        }

        return IMPOSSIBLE;
    }

    private static boolean isReachableInSteps(int x, int y, int steps) {
        int manhattanDistance = Math.abs(x) + Math.abs(y);
        return steps >= manhattanDistance;
    }
}