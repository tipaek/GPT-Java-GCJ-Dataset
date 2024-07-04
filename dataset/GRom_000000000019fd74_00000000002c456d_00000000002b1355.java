import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
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

        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int caseNo) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextLong();
            }
        }

        long sum = solve(matrix);

        printStream.println(String.format("Case #%d: %d", caseNo, sum));
    }

    long solve(long[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        long res = 0L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += matrix[i][j];
            }
        }

        int losers = -1;
        long lastRound = res;

        List<int[]> loosers = new ArrayList<>();
        int round = 0;

        while (round == 0 || loosers.size() > 0) {
            loosers.clear();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] > 0 && isLooser(matrix, i, j)) {
                        lastRound -= matrix[i][j];
                        loosers.add(new int[] { i, j });
                    }
                }
            }

            if (loosers.size() > 0) {
                res += lastRound;
                for (int[] position : loosers) {
                    matrix[position[0]][position[1]] = 0;
                }
            }

            round++;
        }

        return res;
    }

    private static int[][] MOVES = new int[][] {
            new int[] {0, 1},
            new int[] {0, -1},
            new int[] {1, 0},
            new int[] {-1, 0},
    };

    private boolean isLooser(long[][] matrix, int x, int y) {
        int competitors = 0;
        long competitorsScores = 0L;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < MOVES.length; i++) {
            int x1 = x + MOVES[i][0];
            int y1 = y + MOVES[i][1];

            while (isValidPosition(n, m, x1, y1)) {
                if (matrix[x1][y1] > 0) {
                    competitors ++;
                    competitorsScores += matrix[x1][y1];
                    break;
                }

                x1 = x1 + MOVES[i][0];
                y1 = y1 + MOVES[i][1];
            }
        }

        if (competitors > 0) {
            return matrix[x][y] * competitors < competitorsScores;
        }

        return false;
    }

    private boolean isValidPosition(int n, int m, int x, int y) {
        return x >=0 && x < n && y >=0 && y < m;
    }

}