import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sum = new int[n];
        int[] rowDuplicates = new int[n];
        int[] colDuplicates = new int[n];

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int[][] matrix = new int[m][m];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            // Calculate the sum of the main diagonal
            for (int j = 0; j < m; j++) {
                sum[i] += matrix[j][j];
            }

            // Check for duplicates in rows and columns
            for (int j = 0; j < m; j++) {
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int k = 0; k < m; k++) {
                    for (int l = k + 1; l < m; l++) {
                        if (matrix[j][k] == matrix[j][l]) {
                            rowHasDuplicate = true;
                        }
                        if (matrix[k][j] == matrix[l][j]) {
                            colHasDuplicate = true;
                        }
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates[i]++;
                }
                if (colHasDuplicate) {
                    colDuplicates[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Case #" + (i + 1) + ": " + sum[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
        }
    }
}