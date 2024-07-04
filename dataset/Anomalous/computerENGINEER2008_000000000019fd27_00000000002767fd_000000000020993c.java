import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                        rowDuplicates++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!colHasDuplicate && !colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                        colDuplicates++;
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d%n", testCase, trace, rowDuplicates, colDuplicates);
        }
    }
}