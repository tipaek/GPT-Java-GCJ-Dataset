import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            long diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate diagonal sum and check for duplicates in rows and columns
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);

                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }

                if (rowSet.size() < n) {
                    rowDuplicates++;
                }

                if (colSet.size() < n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }

        sc.close();
    }
}