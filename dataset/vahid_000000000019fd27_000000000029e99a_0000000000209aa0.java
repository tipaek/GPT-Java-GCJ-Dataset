import static java.lang.String.format;
import static java.util.stream.IntStream.range;

import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in, 64 * 1024));

    public static void main(String[] args) {
        new Solution().solveProblem();
    }

    private void solveProblem() {
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int item) {
        Input input = getInput();
        System.out.println(format("Case #%d: %s", item, solve(input)));
    }

    private String solve(Input input) {
        int[][] state = new int[input.n][input.n];
        Set<Integer>[] colStates = new Set[input.n];
        Set<Integer>[] rowStates = new Set[input.n];
        range(0, input.n).forEach(i -> {
            colStates[i] = new HashSet<>(input.n * 2);
            rowStates[i] = new HashSet<>(input.n * 2);
        });
        int[][] solution = latinSquare(input.n, input.k, state, rowStates, colStates, 0, 0);

        if (solution == null) {
            return "IMPOSSIBLE";
        } else {
            StringBuilder buffer = new StringBuilder("POSSIBLE");
            for (int[] row : solution) {
                buffer.append("\n");
                for (int cell : row) {
                    buffer.append(cell).append(" ");
                }
            }
            return buffer.toString();
        }
    }

    private int[][] latinSquare(int n, int k, int[][] state, Set<Integer>[] rowStates, Set<Integer>[] colStates, int row, int col) {
        for (int i = 1; i <= n; i++) {
            if (!colStates[col].contains(i) && !rowStates[row].contains(i)) {
                state[row][col] = i;
                rowStates[row].add(i);
                colStates[col].add(i);
                if (col == n - 1 && row == n - 1) {
                    if (traceMatric(state) == k) return state;
                } else {
                    int newCol = col + 1;
                    int newRow = row;
                    if (newCol == n) {
                        newCol = 0;
                        newRow++;
                    }
                    int[][] result = latinSquare(n, k, state, rowStates, colStates, newRow, newCol);
                    if (result != null) return result;
                }
                state[row][col] = 0;
                rowStates[row].remove(i);
                colStates[col].remove(i);
            }
        }
        return null;
    }

    private int traceMatric(int[][] state) {
        int trace = 0;
        for (int i = 0; i < state.length; i++) {
            trace += state[i][i];
        }
        return trace;
    }

    private Input getInput() {
        return new Input(scanner.nextInt(), scanner.nextInt());
    }

    class Input {
        int n;
        int k;

        public Input(int n, int k) {
            this.n = n;
            this.k = k;
        }
    }

}
