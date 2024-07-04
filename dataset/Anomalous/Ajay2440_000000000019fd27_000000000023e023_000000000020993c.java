import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int maxRowDuplicates = 0, maxColDuplicates = 0;
            boolean rowFlag = false, colFlag = false;

            for (int c = 0; c < n; c++) {
                for (int r = 0; r < n; r++) {
                    int currentRowDuplicates = 0, currentColDuplicates = 0;
                    int value = matrix[r][c];

                    for (int i = 0; i < n; i++) {
                        if (value == matrix[r][i] && r != i && c != i) {
                            currentRowDuplicates++;
                            rowFlag = true;
                        }
                        if (value == matrix[i][c] && c != i && r != i) {
                            currentColDuplicates++;
                            colFlag = true;
                        }
                    }

                    maxRowDuplicates = Math.max(currentRowDuplicates, maxRowDuplicates);
                    maxColDuplicates = Math.max(currentColDuplicates, maxColDuplicates);

                    if (maxRowDuplicates >= n && maxColDuplicates >= n) {
                        break;
                    }
                }
                if (maxRowDuplicates >= n && maxColDuplicates >= n) {
                    break;
                }
            }

            if (rowFlag) {
                maxRowDuplicates += 1;
            }
            if (colFlag) {
                maxColDuplicates += 1;
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + maxRowDuplicates + " " + maxColDuplicates);
        }
    }
}