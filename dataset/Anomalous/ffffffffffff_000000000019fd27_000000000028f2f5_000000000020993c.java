import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = 0; // Number of test cases
        for (int i = 0; i < T; i++) {
            int N = 0; // Size of the matrix
            int[][] matrix = new int[N][N];
            int trace = 0;

            // Calculate the trace of the matrix
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check for duplicate values in rows
            for (int j = 0; j < N; j++) {
                boolean hasDuplicate = false;
                for (int k = 0; k < N; k++) {
                    for (int m = k + 1; m < N; m++) {
                        if (matrix[j][m] == matrix[j][k]) {
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) {
                        break;
                    }
                }
                if (hasDuplicate) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < N; j++) {
                boolean hasDuplicate = false;
                for (int k = 0; k < N; k++) {
                    for (int m = k + 1; m < N; m++) {
                        if (matrix[m][j] == matrix[k][j]) {
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) {
                        break;
                    }
                }
                if (hasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}