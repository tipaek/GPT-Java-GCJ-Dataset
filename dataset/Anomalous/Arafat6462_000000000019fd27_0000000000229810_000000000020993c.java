import java.util.Scanner;

class Google1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Input matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int[] rowDuplicates = new int[n];
            int[] colDuplicates = new int[n];

            // Check for row duplicates
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n + 1];
                for (int col = 0; col < n; col++) {
                    if (seen[matrix[row][col]]) {
                        rowDuplicates[row] = 1;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Check for column duplicates
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n + 1];
                for (int row = 0; row < n; row++) {
                    if (seen[matrix[row][col]]) {
                        colDuplicates[col] = 1;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Calculate diagonal sum and count rows and columns with duplicates
            int diagonalSum = 0;
            int rowCountWithDuplicates = 0;
            int colCountWithDuplicates = 0;

            for (int p = 0; p < n; p++) {
                diagonalSum += matrix[p][p];
                if (rowDuplicates[p] == 1) {
                    rowCountWithDuplicates++;
                }
                if (colDuplicates[p] == 1) {
                    colCountWithDuplicates++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + rowCountWithDuplicates + " " + colCountWithDuplicates);
        }
    }
}