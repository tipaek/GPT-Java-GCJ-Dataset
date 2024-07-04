import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Read the matrix values
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the diagonal sum
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            System.out.print("Case #" + t + ": " + diagonalSum + " ");

            // Variables to keep track of max duplicates in rows and columns
            int maxRowDuplicates = -1;
            int maxColDuplicates = -1;

            // Check duplicates in rows and columns
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = matrix[i][j];
                    int rowDuplicates = 0;
                    int colDuplicates = 0;

                    // Count duplicates in the current row
                    for (int k = 0; k < n; k++) {
                        if (value == matrix[i][k]) {
                            rowDuplicates++;
                        }
                    }

                    // Count duplicates in the current column
                    for (int k = 0; k < n; k++) {
                        if (value == matrix[k][j]) {
                            colDuplicates++;
                        }
                    }

                    // Update max duplicates if necessary
                    maxRowDuplicates = Math.max(maxRowDuplicates, rowDuplicates - 1);
                    maxColDuplicates = Math.max(maxColDuplicates, colDuplicates - 1);
                }
            }

            System.out.print(maxRowDuplicates + " ");
            System.out.print(maxColDuplicates + " ");
            System.out.println();

            t--;
        }

        scanner.close();
    }
}