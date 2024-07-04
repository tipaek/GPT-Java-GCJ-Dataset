import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static PrintStream output;

    private static final String CASE_PREFIX = "Case #";
    private static final String COLON_SPACE = ": ";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        output = System.out;

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            output.print(CASE_PREFIX);
            output.print(testCase);
            output.print(COLON_SPACE);
            output.println(solve(x, y));
        }
        output.flush();
    }

    static class Position {
        private final int x;
        private final int y;
        private final String path;

        Position(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    private static String solve(int x, int y) {
        LinkedList<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y, ""));

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.x == 0 && current.y == 0) {
                return current.path;
            }

            if (Math.abs(current.x + current.y) % 2 == 0) {
                continue;
            }

            if (Math.abs(current.x) % 2 == 1) {
                queue.add(new Position((current.x - 1) / 2, current.y / 2, current.path + 'E'));
                queue.add(new Position((current.x + 1) / 2, current.y / 2, current.path + 'W'));
            } else {
                queue.add(new Position(current.x / 2, (current.y - 1) / 2, current.path + 'N'));
                queue.add(new Position(current.x / 2, (current.y + 1) / 2, current.path + 'S'));
            }
        }

        return IMPOSSIBLE;
    }
}