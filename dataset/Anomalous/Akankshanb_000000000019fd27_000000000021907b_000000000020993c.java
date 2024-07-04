import java.util.*;
import java.io.*;

class Solution {

    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int[] countRepeatedRowsAndCols(int[][] matrix) {
        int n = matrix.length;
        Set<Integer>[] rowSets = new HashSet[n];
        Set<Integer>[] colSets = new HashSet[n];
        int repeatedRows = 0;
        int repeatedCols = 0;

        for (int i = 0; i < n; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSets[i].add(matrix[i][j]);
                colSets[j].add(matrix[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (rowSets[i].size() < n) repeatedRows++;
            if (colSets[i].size() < n) repeatedCols++;
        }

        return new int[]{repeatedRows, repeatedCols};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int[] repeatedCounts = countRepeatedRowsAndCols(matrix);
            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedCounts[0] + " " + repeatedCounts[1]);
        }
    }
}