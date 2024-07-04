import java.io.*;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Count rows with repeated elements
            int repeatedRows = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Count columns with repeated elements
            int repeatedCols = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            // Print the result for this test case
            System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}