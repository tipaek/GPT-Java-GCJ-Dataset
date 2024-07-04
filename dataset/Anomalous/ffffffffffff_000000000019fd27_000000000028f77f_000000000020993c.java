import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;

            // Read the matrix and calculate the diagonal sum
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = in.nextInt();
                    if (j == k) {
                        diagonalSum += matrix[j][k];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for duplicate values in rows
            for (int j = 0; j < N; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowRepeats++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < N; j++) {
                int[] column = new int[N];
                for (int k = 0; k < N; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
        in.close();
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}