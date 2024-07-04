import java.util.Scanner;

public class Solution {

    private static int[] solve(int[][] matrix) {
        int size = matrix.length;
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        // Calculate the trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate entries in rows
        for (int r = 0; r < size; r++) {
            boolean[] seen = new boolean[size + 1];
            for (int c = 0; c < size; c++) {
                if (seen[matrix[r][c]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[r][c]] = true;
            }
        }

        // Check for duplicate entries in columns
        for (int c = 0; c < size; c++) {
            boolean[] seen = new boolean[size + 1];
            for (int r = 0; r < size; r++) {
                if (seen[matrix[r][c]]) {
                    duplicateColumns++;
                    break;
                }
                seen[matrix[r][c]] = true;
            }
        }

        return new int[] { trace, duplicateRows, duplicateColumns };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            int[] result = solve(matrix);
            System.out.printf("Case #%d: %d %d %d\n", t, result[0], result[1], result[2]);
        }
        
        scanner.close();
    }
}