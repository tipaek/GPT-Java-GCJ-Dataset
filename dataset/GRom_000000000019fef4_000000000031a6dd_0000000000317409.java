import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private Scanner scanner;
    private PrintStream printStream;

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }

    Solution() {
        // No-op.
    }

    void execute(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        printStream = out;

        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int caseNo) {
        String[] items = scanner.nextLine().split(" ");
        int x = Integer.parseInt(items[0]);
        int y = Integer.parseInt(items[1]);
        String path = items[2];

        printStream.printf("Case #%d: %s\n", caseNo, solve(x, y, path));


    }

    private String solve(int x, int y, String path) {
        Peppurr peppurr = new Peppurr(x, y);

        if (peppurr.timeToGo() == 0) {
            return "0";
        } else {
            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                peppurr.move(direction);

                if (peppurr.timeToGo() <= (i + 1)) {
                    return Integer.toString(i + 1);
                }
            }

            return "IMPOSSIBLE";
        }
    }

    private static class Peppurr {
        private int x;
        private int y;

        private Peppurr(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private void move(char direction) {
            if (direction == 'W') {
                x--;
            } else if (direction == 'E') {
                x++;
            } else if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            } else {
                throw new IllegalArgumentException("Incorrect move direction: " + direction);
            }
        }

        private int timeToGo() {
            return Math.abs(x) + Math.abs(y);
        }
    }
}
