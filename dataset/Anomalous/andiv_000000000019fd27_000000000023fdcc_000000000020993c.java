import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= totalTests; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int[] result = solve(matrix, N);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    public static int[] solve(int[][] matrix, int N) {
        int diagonalSum = 0, duplicateRows = 0, duplicateCols = 0;

        // Calculate the sum of the main diagonal
        for (int i = 0; i < N; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int row = 0; row < N; row++) {
            Set<Integer> rowValues = new HashSet<>();
            for (int col = 0; col < N; col++) {
                if (!rowValues.add(matrix[row][col])) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Check for duplicate values in columns
        for (int col = 0; col < N; col++) {
            Set<Integer> colValues = new HashSet<>();
            for (int row = 0; row < N; row++) {
                if (!colValues.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        return new int[]{diagonalSum, duplicateRows, duplicateCols};
    }
}