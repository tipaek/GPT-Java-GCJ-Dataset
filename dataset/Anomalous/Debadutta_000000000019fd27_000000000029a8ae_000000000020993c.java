import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int duplicateColumns = 0;
            int duplicateRows = 0;

            // Checking for duplicate elements in columns
            for (int col = 0; col < n; col++) {
                int duplicatesInColumn = 0;
                for (int row = 0; row < n; row++) {
                    for (int k = row + 1; k < n; k++) {
                        if (matrix[row][col] == matrix[k][col]) {
                            duplicatesInColumn++;
                        }
                    }
                }
                if (duplicatesInColumn > 0) {
                    duplicateColumns++;
                }
            }

            // Checking for duplicate elements in rows
            for (int row = 0; row < n; row++) {
                int duplicatesInRow = 0;
                for (int col = 0; col < n; col++) {
                    for (int k = col + 1; k < n; k++) {
                        if (matrix[row][col] == matrix[row][k]) {
                            duplicatesInRow++;
                        }
                    }
                }
                if (duplicatesInRow > 0) {
                    duplicateRows++;
                }
            }

            // Calculating the trace of the matrix
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            System.out.println("case #" + testCases + ": " + trace + " " + duplicateColumns + " " + duplicateRows);
            testCases--;
        }
        sc.close();
    }
}