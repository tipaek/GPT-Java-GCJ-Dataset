import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int maxRowDuplicates = 0, maxColDuplicates = 0;

            // Check for duplicates in rows and columns
            for (int c = 0; c < n; c++) {
                for (int r = 0; r < n; r++) {
                    int currentElement = matrix[r][c];
                    int rowDuplicates = 0, colDuplicates = 0;

                    for (int i = 0; i < n; i++) {
                        if (currentElement == matrix[r][i]) {
                            rowDuplicates++;
                        }
                        if (currentElement == matrix[i][c]) {
                            colDuplicates++;
                        }
                    }

                    maxRowDuplicates = Math.max(maxRowDuplicates, rowDuplicates);
                    maxColDuplicates = Math.max(maxColDuplicates, colDuplicates);

                    if (maxRowDuplicates >= n && maxColDuplicates >= n) {
                        break;
                    }
                }

                if (maxRowDuplicates >= n && maxColDuplicates >= n) {
                    break;
                }
            }

            if (maxRowDuplicates == 1) {
                maxRowDuplicates = 0;
            }

            if (maxColDuplicates == 1) {
                maxColDuplicates = 0;
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + maxRowDuplicates + " " + maxColDuplicates);
        }

        scanner.close();
    }
}