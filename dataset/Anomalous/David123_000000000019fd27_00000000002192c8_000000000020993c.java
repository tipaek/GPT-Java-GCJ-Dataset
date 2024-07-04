import java.util.*;
import java.io.*;

public class Solution {

    public static String findSolution(int n, int[][] matrix) {
        int trace = 0;
        List<Set<Integer>> rowSets = new ArrayList<>(n);
        List<Set<Integer>> colSets = new ArrayList<>(n);
        boolean[] rowDuplicates = new boolean[n];
        boolean[] colDuplicates = new boolean[n];

        for (int i = 0; i < n; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value = matrix[row][col];

                if (row == col) {
                    trace += value;
                }

                Set<Integer> rowSet = rowSets.get(row);
                Set<Integer> colSet = colSets.get(col);

                if (!rowSet.add(value)) {
                    rowDuplicates[row] = true;
                }

                if (!colSet.add(value)) {
                    colDuplicates[col] = true;
                }
            }
        }

        int numRowDuplicates = 0;
        int numColDuplicates = 0;

        for (int i = 0; i < n; i++) {
            if (rowDuplicates[i]) {
                numRowDuplicates++;
            }
            if (colDuplicates[i]) {
                numColDuplicates++;
            }
        }

        return trace + " " + numRowDuplicates + " " + numColDuplicates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = scanner.nextInt();

        for (int i = 1; i <= numTestCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            String solution = findSolution(n, matrix);
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}