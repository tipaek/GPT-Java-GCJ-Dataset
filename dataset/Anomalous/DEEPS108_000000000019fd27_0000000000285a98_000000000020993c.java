import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int duplicateRows = 0;
            int duplicateCols = 0;
            int diagonalSum = 0;

            int[][] matrix = new int[N][N];

            // Read matrix and check for duplicate rows
            for (int row = 0; row < N; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = sc.nextInt();
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != N) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != N) {
                    duplicateCols++;
                }
            }

            // Calculate the sum of the diagonal elements
            for (int j = 0; j < N; j++) {
                diagonalSum += matrix[j][j];
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }

        sc.close();
    }
}