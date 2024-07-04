import java.util.*;
import java.io.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scan.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scan.nextInt();
            int trace = 0;
            int rowCount = n;
            int colCount = n;

            int[][] matrix = new int[n][n];

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowCount--;
                        break;
                    }
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colCount--;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}