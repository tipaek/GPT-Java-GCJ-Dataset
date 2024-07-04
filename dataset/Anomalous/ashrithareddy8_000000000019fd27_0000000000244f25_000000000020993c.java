import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= n; caseIndex++) {
            int m = scanner.nextInt();
            int[][] matrix = new int[m][m];

            // Read matrix
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < m; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate diagonal sum
            int diagonalSum = 0;
            for (int i = 0; i < m; i++) {
                diagonalSum += matrix[i][i];
            }

            // Check rows and columns for duplicates
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < m; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
                if (hasDuplicates(getColumn(matrix, i))) {
                    colDuplicates++;
                }
            }

            // Print result for the current case
            System.out.println("Case #" + caseIndex + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    // Helper method to check if an array has duplicates
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[101]; // Assuming values are between 0 and 100
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    // Helper method to get a column from a 2D array
    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}