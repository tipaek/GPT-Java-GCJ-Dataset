import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }
                }
                if (rowHasDuplicates) {
                    rowRepeats++;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicates = true;
                    }
                }
                if (colHasDuplicates) {
                    colRepeats++;
                }
            }

            // Print the result for the current test case
            System.out.println("case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}