import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int sumDiagonal = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            // Calculating the sum of the main diagonal
            for (int j = 0; j < n; j++) {
                sumDiagonal += matrix[j][j];
            }

            // Checking for repeated elements in rows
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Checking for repeated elements in columns
            for (int k = 0; k < n; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            // Outputting the results
            System.out.println("Case #" + i + ": " + sumDiagonal + " " + rowRepeats + " " + colRepeats);
        }
    }
}