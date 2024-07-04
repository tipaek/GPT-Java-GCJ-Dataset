import java.util.*;
import java.io.*;

public class Solution {
    private static int n;
    private static int[][] mat;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(scanner, i);
        }
    }

    private static void solve(Scanner scanner, int testCaseIndex) {
        n = scanner.nextInt();
        mat = new int[n][n];
        int trace = 0;
        int badRows = 0;
        int badCols = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        // Check bad rows
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(mat[i])) {
                badRows++;
            }
        }

        // Check bad columns
        for (int j = 0; j < n; j++) {
            if (hasDuplicates(getColumn(mat, j))) {
                badCols++;
            }
        }

        System.out.println("Case #" + (testCaseIndex + 1) + ": " + trace + " " + badRows + " " + badCols);
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}