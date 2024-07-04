import java.util.*;

public class Solution {

    public static void vestigium() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test-cases
        List<String> outputs = new ArrayList<>();

        for (int k = 0; k < T; k++) {
            int N = scanner.nextInt(); // Size of matrix
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Check for row repeats
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for column repeats
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            outputs.add("Case #" + (k + 1) + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }

        // Print all outputs
        for (String output : outputs) {
            System.out.println(output);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        vestigium();
    }
}