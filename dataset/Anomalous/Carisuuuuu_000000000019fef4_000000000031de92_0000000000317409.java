import java.util.Scanner;
import java.io.PrintStream;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream out = System.out;
    private static final PrintStream log = System.err;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();

            if (moves.length() < x) {
                printResponse(caseNumber, "IMPOSSIBLE");
                continue;
            }

            moves = new StringBuilder(moves.length() + 1).append(moves).insert(x, ',').toString();
            String[] routes = moves.split(",", -1);

            y -= countOccurrences(routes[0], 'N');
            y += countOccurrences(routes[0], 'S');

            if (routes[1].length() < y / 2) {
                printResponse(caseNumber, "IMPOSSIBLE");
                continue;
            }

            boolean isNorth = y > 0;
            int i;
            for (i = 0; i < routes[1].length() && !hasReachedEnd(y, isNorth); i++) {
                char currentMove = routes[1].charAt(i);
                if (currentMove == 'N' && !isNorth) {
                    y += 2;
                }
                if (currentMove == 'S' && isNorth) {
                    y -= 2;
                }
            }

            if (hasReachedEnd(y, isNorth)) {
                printResponse(caseNumber, x + i);
            } else {
                printResponse(caseNumber, "IMPOSSIBLE");
            }
        }
    }

    private static boolean hasReachedEnd(int y, boolean isNorth) {
        return y == 0 || (Math.abs(y) == 1 && isNorth != (y > 0));
    }

    private static void printResponse(int caseNumber, Object message) {
        out.println("Case #" + caseNumber + ": " + message);
    }

    private static int countOccurrences(String str, char ch) {
        return (int) str.chars().filter(c -> c == ch).count();
    }
}