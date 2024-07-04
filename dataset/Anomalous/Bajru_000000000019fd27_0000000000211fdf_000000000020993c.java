import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            processMatrix(matrix, n, testCase);
        }
        scanner.close();
    }

    private static void processMatrix(int[][] matrix, int n, int testCase) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int expectedSum = n * (n + 1) / 2;
        int duplicateRows = 0, duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n + 1];
            boolean[] colCheck = new boolean[n + 1];
            boolean rowHasDuplicate = false, colHasDuplicate = false;

            for (int j = 0; j < n; j++) {
                if (rowCheck[matrix[i][j]]) {
                    rowHasDuplicate = true;
                }
                rowCheck[matrix[i][j]] = true;

                if (colCheck[matrix[j][i]]) {
                    colHasDuplicate = true;
                }
                colCheck[matrix[j][i]] = true;
            }

            if (rowHasDuplicate) {
                duplicateRows++;
            }
            if (colHasDuplicate) {
                duplicateCols++;
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }
}