import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0, colRepeats = 0;

            // Check column repeats
            for (int col = 0; col < n; col++) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!seen.add(matrix[row][col])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            // Check row repeats
            for (int row = 0; row < n; row++) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!seen.add(matrix[row][col])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
        scanner.close();
    }
}