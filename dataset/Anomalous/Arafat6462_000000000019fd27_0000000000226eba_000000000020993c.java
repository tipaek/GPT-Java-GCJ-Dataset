import java.util.Scanner;

class Google1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Input
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int[] rowDuplicates = new int[n];
            int[] columnDuplicates = new int[n];

            // Check for row duplicates
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int k = 0; k < n; k++) {
                    if (seen[matrix[j][k]]) {
                        rowDuplicates[j] = 1;
                        break;
                    }
                    seen[matrix[j][k]] = true;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int k = 0; k < n; k++) {
                    if (seen[matrix[k][j]]) {
                        columnDuplicates[j] = 1;
                        break;
                    }
                    seen[matrix[k][j]] = true;
                }
            }

            // Calculate the sum of the diagonal
            int diagonalSum = 0;
            int rowDuplicateCount = 0;
            int columnDuplicateCount = 0;

            for (int p = 0; p < n; p++) {
                diagonalSum += matrix[p][p];
                if (rowDuplicates[p] == 1) {
                    rowDuplicateCount++;
                }
                if (columnDuplicates[p] == 1) {
                    columnDuplicateCount++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + rowDuplicateCount + " " + columnDuplicateCount);
        }
    }
}