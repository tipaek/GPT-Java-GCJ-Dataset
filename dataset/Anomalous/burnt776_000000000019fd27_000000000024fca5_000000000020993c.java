import java.util.Scanner;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Input matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }

            // Output results
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}