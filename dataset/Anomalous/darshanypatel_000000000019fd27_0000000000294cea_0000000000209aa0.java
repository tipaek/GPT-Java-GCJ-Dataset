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

            boolean solutionFound = false;
            for (List<Integer> trace : possibleTraces) {
                int[][] matrix = new int[N][N];
                List<Set<Integer>> rows = initializeSets(N);
                List<Set<Integer>> cols = initializeSets(N);

                fillDiagonal(matrix, trace, rows, cols);

                if (fillMatrix(matrix, rows, cols)) {
                    System.out.println(String.format("Case #%d: POSSIBLE", t));
                    printMatrix(matrix);
                    solutionFound = true;
                    break;
                }
            }

            if (!solutionFound) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            }
        }
    }

    private static List<Set<Integer>> initializeSets(int N) {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sets.add(new HashSet<>());
        }
        return sets;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
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
        return fillMatrixRecursive(matrix, rows, cols, 0, 0);
    }

    private static boolean fillMatrixRecursive(int[][] matrix, List<Set<Integer>> rows, List<Set<Integer>> cols, int row, int col) {
        int N = matrix.length;

        if (row == N) return true;
        if (col == N) return fillMatrixRecursive(matrix, rows, cols, row + 1, 0);

        if (matrix[row][col] != 0) return fillMatrixRecursive(matrix, rows, cols, row, col + 1);

        for (int num = 1; num <= N; num++) {
            if (!rows.get(row).contains(num) && !cols.get(col).contains(num)) {
                matrix[row][col] = num;
                rows.get(row).add(num);
                cols.get(col).add(num);

                if (fillMatrixRecursive(matrix, rows, cols, row, col + 1)) {
                    return true;
                }

                matrix[row][col] = 0;
                rows.get(row).remove(num);
                cols.get(col).remove(num);
            }
        }

        return false;
    }

    private static Set<List<Integer>> generatePossibleTraces(int n, int k) {
        Set<List<Integer>> traces = new HashSet<>();
        generateTracesRecursively(n, k, new ArrayList<>(), traces);
        return traces;
    }

    private static void generateTracesRecursively(int n, int k, List<Integer> currentTrace, Set<List<Integer>> traces) {
        if (currentTrace.size() == n) {
            if (k == 0) {
                traces.add(new ArrayList<>(currentTrace));
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (k - i >= 0) {
                currentTrace.add(i);
                generateTracesRecursively(n, k - i, currentTrace, traces);
                currentTrace.remove(currentTrace.size() - 1);
            }
        }
    }
}