import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read matrix and compute trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check for row and column duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowFlag = false;
                boolean colFlag = false;

                for (int j = 0; j < n; j++) {
                    // Check row duplicates
                    if (!rowSet.add(matrix[i][j]) && !rowFlag) {
                        rowDuplicates++;
                        rowFlag = true;
                    }

                    // Check column duplicates
                    if (!colSet.add(matrix[j][i]) && !colFlag) {
                        colDuplicates++;
                        colFlag = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}