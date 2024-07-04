import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static final String CASE_PREFIX = "Case #";
    private static final String COLON_SPACE = ": ";
    private static final int MAX_MOVES = 1001;

    private static Scanner scanner;
    private static PrintStream output;

    private static int[][] positions = new int[MAX_MOVES][2];

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        output = System.out;

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String moves = scanner.next();

            positions[0][0] = startX;
            positions[0][1] = startY;

            for (int i = 0; i < moves.length(); i++) {
                int index = i + 1;
                char move = moves.charAt(i);

                positions[index][0] = positions[index - 1][0] + getDeltaX(move);
                positions[index][1] = positions[index - 1][1] + getDeltaY(move);
            }

            int result = findMinTime(moves.length());
            output.printf("%s%d%s%s%n", CASE_PREFIX, t, COLON_SPACE, result < 0 ? "IMPOSSIBLE" : result);
        }
        output.flush();
    }

    private static int findMinTime(int moveLength) {
        for (int i = 1; i <= moveLength; i++) {
            if (calculateManhattanDistance(positions[i][0], positions[i][1]) <= i) {
                return i;
            }
        }
        return -1;
    }

    private static int calculateManhattanDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    private static int getDeltaX(char direction) {
        switch (direction) {
            case 'E': return 1;
            case 'W': return -1;
            default: return 0;
        }
    }

    private static int getDeltaY(char direction) {
        switch (direction) {
            case 'N': return 1;
            case 'S': return -1;
            default: return 0;
        }
    }
}