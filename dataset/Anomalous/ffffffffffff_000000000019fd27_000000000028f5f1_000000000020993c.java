import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int sum = 0;

            // Read matrix values and calculate the sum of the diagonal
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = in.nextInt();
                    if (j == k) {
                        sum += matrix[j][k];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check for duplicate values in rows
            for (int j = 0; j < N; j++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int k = 0; k < N; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}