import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Jam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            int[][] matrix = new int[n][n];

            // Read the matrix and calculate the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for duplicates in rows
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicates in columns
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}