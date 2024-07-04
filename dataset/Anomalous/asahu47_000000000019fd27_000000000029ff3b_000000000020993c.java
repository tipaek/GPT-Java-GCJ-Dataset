import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            // Read matrix and calculate trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scan.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check rows for duplicates
            for (int j = 0; j < n; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Check columns for duplicates
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}