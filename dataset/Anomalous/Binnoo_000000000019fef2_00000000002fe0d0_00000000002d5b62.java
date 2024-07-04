import java.util.Scanner;

public class Solution {

    private int t;
    private Scanner scanner;
    private int x;
    private int y;
    private static final String[] DIRECTIONS_STRINGS = { "N", "S", "E", "W" };
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private String bestSolution = "";
    private boolean foundSolution = false;

    public Solution(int t, Scanner scanner) {
        this.t = t;
        this.scanner = scanner;
    }

    public void solve() {
        // Read input and solve
        x = scanner.nextInt();
        y = scanner.nextInt();
        if (x % 2 == 1 && y % 2 == 1) {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
            return;
        }

        StringBuilder solution = new StringBuilder();
        solveRecursive(solution, 0, 0, 0);
        if (!foundSolution) {
            bestSolution = "IMPOSSIBLE";
        }

        System.out.println("Case #" + t + ": " + bestSolution);
    }

    private void solveRecursive(StringBuilder solution, int x_i, int y_i, int i) {
        if (i == 9) {
            return;
        }

        if (x_i == x && y_i == y) {
            if (solution.length() < bestSolution.length() || !foundSolution) {
                bestSolution = solution.toString();
                foundSolution = true;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            x_i += DIRECTIONS[d][0] * (1 << i);
            y_i += DIRECTIONS[d][1] * (1 << i);
            solution.append(DIRECTIONS_STRINGS[d]);
            solveRecursive(solution, x_i, y_i, i + 1);
            solution.setLength(solution.length() - 1);
            x_i -= DIRECTIONS[d][0] * (1 << i);
            y_i -= DIRECTIONS[d][1] * (1 << i);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                new Solution(i + 1, scanner).solve();
            }
        }
    }
}