import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace and row repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (!rowFlag && !rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        rowFlag = true;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Calculate column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int i = 0; i < n; i++) {
                    if (!colFlag && !colSet.add(matrix[i][j])) {
                        colRepeats++;
                        colFlag = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}