import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = reader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            Set<List<Integer>> possibleTraces = generatePossibleTraces(N, K);

            boolean isPossible = false;
            for (List<Integer> trace : possibleTraces) {
                int[][] matrix = new int[N][N];
                List<Set<Integer>> rows = initializeSets(N);
                List<Set<Integer>> cols = initializeSets(N);

                fillDiagonal(matrix, trace, rows, cols);

                if (fillMatrix(matrix, rows, cols)) {
                    System.out.println(String.format("Case #%d: POSSIBLE", t));
                    printMatrix(matrix);
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            }
        }
    }

    private static Set<List<Integer>> generatePossibleTraces(int n, int k) {
        Set<List<Integer>> traces = new HashSet<>();
        findTraces(n, k, traces, new ArrayList<>());
        return traces;
    }

    private static void findTraces(int n, int k, Set<List<Integer>> traces, List<Integer> currentTrace) {
        if (currentTrace.size() == n && k == 0) {
            List<Integer> sortedTrace = new ArrayList<>(currentTrace);
            Collections.sort(sortedTrace);
            traces.add(sortedTrace);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (k - i >= 0) {
                currentTrace.add(i);
                findTraces(n, k - i, traces, new ArrayList<>(currentTrace));
                currentTrace.remove(currentTrace.size() - 1);
            }
        }
    }

    private static List<Set<Integer>> initializeSets(int n) {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sets.add(new HashSet<>());
        }
        return sets;
    }

    private static void fillDiagonal(int[][] matrix, List<Integer> trace, List<Set<Integer>> rows, List<Set<Integer>> cols) {
        for (int i = 0; i < trace.size(); i++) {
            int value = trace.get(i);
            matrix[i][i] = value;
            rows.get(i).add(value);
            cols.get(i).add(value);
        }
    }

    private static boolean fillMatrix(int[][] matrix, List<Set<Integer>> rows, List<Set<Integer>> cols) {
        return tryFill(matrix, rows, cols, 0, 0);
    }

    private static boolean tryFill(int[][] matrix, List<Set<Integer>> rows, List<Set<Integer>> cols, int row, int col) {
        int N = matrix.length;
        if (row == N) {
            return true;
        }
        if (col == N) {
            return tryFill(matrix, rows, cols, row + 1, 0);
        }
        if (matrix[row][col] != 0) {
            return tryFill(matrix, rows, cols, row, col + 1);
        }

        for (int k = 1; k <= N; k++) {
            if (!rows.get(row).contains(k) && !cols.get(col).contains(k)) {
                matrix[row][col] = k;
                rows.get(row).add(k);
                cols.get(col).add(k);
                if (tryFill(matrix, rows, cols, row, col + 1)) {
                    return true;
                }
                matrix[row][col] = 0;
                rows.get(row).remove(k);
                cols.get(col).remove(k);
            }
        }
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}