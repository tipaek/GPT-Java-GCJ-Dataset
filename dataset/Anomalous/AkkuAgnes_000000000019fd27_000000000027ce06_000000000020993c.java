import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] results = calculateDuplicates(matrix, n);
            System.out.println("Case #" + (t + 1) + ": " + results[0] + " " + results[1] + " " + results[2]);
        }

        scanner.close();
    }

    private static int[] calculateDuplicates(int[][] matrix, int size) {
        int[] results = new int[3];
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];

            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (!rowCheck[matrix[i][j]]) {
                    rowCheck[matrix[i][j]] = true;
                } else if (!rowHasDuplicate) {
                    rowDuplicates++;
                    rowHasDuplicate = true;
                }

                if (!colCheck[matrix[j][i]]) {
                    colCheck[matrix[j][i]] = true;
                } else if (!colHasDuplicate) {
                    colDuplicates++;
                    colHasDuplicate = true;
                }
            }
        }

        results[0] = trace;
        results[1] = rowDuplicates;
        results[2] = colDuplicates;

        return results;
    }
}