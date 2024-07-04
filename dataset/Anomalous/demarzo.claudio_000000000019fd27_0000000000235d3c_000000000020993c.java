import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt(); // number of test cases

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt(); // size of the matrix
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Counting rows with duplicate elements
            int rowDuplicates = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Counting columns with duplicate elements
            int colDuplicates = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}