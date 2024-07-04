import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the sum of the diagonal elements
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Counting rows with duplicate values
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (rowSet.contains(matrix[i][j])) {
                        hasDuplicate = true;
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Counting columns with duplicate values
            int duplicateCols = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (colSet.contains(matrix[j][i])) {
                        hasDuplicate = true;
                    }
                    colSet.add(matrix[j][i]);
                }
                if (hasDuplicate) {
                    duplicateCols++;
                }
            }

            // Printing the results
            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }

        sc.close();
    }
}