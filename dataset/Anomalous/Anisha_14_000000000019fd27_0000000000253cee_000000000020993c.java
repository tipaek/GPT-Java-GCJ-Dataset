import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the sum of the main diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }
            System.out.print("Case #" + t + ": " + diagonalSum + " ");

            // Count occurrences in rows and columns
            int maxRowCount = Integer.MIN_VALUE;
            int maxColCount = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int[] rowCount = new int[n + 1];
                int[] colCount = new int[n + 1];

                for (int j = 0; j < n; j++) {
                    rowCount[matrix[i][j]]++;
                    colCount[matrix[j][i]]++;
                }

                for (int k = 0; k <= n; k++) {
                    maxRowCount = Math.max(maxRowCount, rowCount[k]);
                    maxColCount = Math.max(maxColCount, colCount[k]);
                }
            }

            System.out.print(maxRowCount + " ");
            System.out.print(maxColCount + " ");
            System.out.println();

            t--;
        }

        scanner.close();
    }
}