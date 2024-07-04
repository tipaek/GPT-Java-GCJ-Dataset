import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            System.out.print("Case #" + t + ": " + diagonalSum + " ");

            int maxRowRepeats = -1;
            int maxColRepeats = -1;

            // Calculate the maximum repeats in any row and column
            for (int i = 0; i < n; i++) {
                int[] rowCount = new int[n + 1];
                int[] colCount = new int[n + 1];

                for (int j = 0; j < n; j++) {
                    rowCount[matrix[i][j]]++;
                    colCount[matrix[j][i]]++;
                }

                for (int k = 0; k <= n; k++) {
                    if (rowCount[k] > 1) {
                        maxRowRepeats = Math.max(maxRowRepeats, rowCount[k] - 1);
                    }
                    if (colCount[k] > 1) {
                        maxColRepeats = Math.max(maxColRepeats, colCount[k] - 1);
                    }
                }
            }

            System.out.print(maxRowRepeats + " ");
            System.out.print(maxColRepeats + " ");
            System.out.println();

            t--;
        }

        scanner.close();
    }
}