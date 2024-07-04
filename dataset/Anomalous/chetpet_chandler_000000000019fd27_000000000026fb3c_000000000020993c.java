import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Reading the matrix and calculating the diagonal sum and row duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt();
                    matrix[i][j] = num;
                    rowSet.add(num);
                    if (i == j) {
                        diagonalSum += num;
                    }
                }
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }

            // Calculating column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        scanner.close();
    }
}