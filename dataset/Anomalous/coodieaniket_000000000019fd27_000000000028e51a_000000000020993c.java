import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0, repeatedRows = 0, repeatedColumns = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    repeatedRows++;
                }
            }

            // Check for repeated elements in columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != n) {
                    repeatedColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}