import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static int n;
    private static int k;
    private static List<Set<Integer>> rows;
    private static List<Set<Integer>> cols;
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases ; testCase++) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            initializeStructures();

            boolean isPossible = fillMatrix(0, 0, 0);
            System.out.println(String.format("Case #%d: %s", testCase, isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
            if (isPossible) {
                printMatrix();
            }
        }
    }

    private static void initializeStructures() {
        rows = new ArrayList<>();
        cols = new ArrayList<>();
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 1; j <= n; j++) {
                rowSet.add(j);
                colSet.add(j);
            }
            rows.add(rowSet);
            cols.add(colSet);
        }
    }

    private static boolean fillMatrix(int row, int col, int diagonalSum) {
        if (row == n - 1 && col == n - 1) {
            int finalValue = rows.get(n - 1).iterator().next();
            matrix[row][col] = finalValue;
            diagonalSum += finalValue;
            return diagonalSum == k;
        }

        Set<Integer> possibleValues = new HashSet<>(rows.get(row));
        possibleValues.retainAll(cols.get(col));
        for (Integer value : possibleValues) {
            rows.get(row).remove(value);
            cols.get(col).remove(value);
            matrix[row][col] = value;
            int newDiagonalSum = diagonalSum + (row == col ? value : 0);

            boolean success = col == n - 1 ? fillMatrix(row + 1, 0, newDiagonalSum) : fillMatrix(row, col + 1, newDiagonalSum);
            if (success) return true;

            rows.get(row).add(value);
            cols.get(col).add(value);
        }
        return false;
    }

    private static void printMatrix() {
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(row[j]);
                if (j < n - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}