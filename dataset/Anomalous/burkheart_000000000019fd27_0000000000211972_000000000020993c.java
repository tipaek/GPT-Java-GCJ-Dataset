import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution { 

    public static int N;
    public static int[][] matrix;

    public static class State {
        public int trace, rowCount, colCount;
    }

    public static State solve() {
        State result = new State();
        result.trace = calculateTrace();
        result.rowCount = countDuplicateRows();
        result.colCount = countDuplicateColumns();
        return result;
    }

    private static int calculateTrace() {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows() {
        int duplicateRows = 0;
        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns() {
        int duplicateColumns = 0;
        for (int j = 0; j < N; j++) {
            int[] column = new int[N];
            for (int i = 0; i < N; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[N];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; ++t) {
            N = scanner.nextInt();
            matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            State result = solve();
            System.out.println("Case #" + t + ": " + result.trace + " " + result.rowCount + " " + result.colCount);
        }
    }
}