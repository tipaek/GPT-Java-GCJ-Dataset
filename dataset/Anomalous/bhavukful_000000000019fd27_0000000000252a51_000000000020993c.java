import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Calculate row repeats
            int rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Boolean> rowMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (rowMap.containsKey(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    } else {
                        rowMap.put(matrix[i][j], true);
                    }
                }
            }

            // Calculate column repeats
            int colRepeats = 0;
            for (int j = 0; j < n; j++) {
                HashMap<Integer, Boolean> colMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    if (colMap.containsKey(matrix[i][j])) {
                        colRepeats++;
                        break;
                    } else {
                        colMap.put(matrix[i][j], true);
                    }
                }
            }

            // Print results for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}