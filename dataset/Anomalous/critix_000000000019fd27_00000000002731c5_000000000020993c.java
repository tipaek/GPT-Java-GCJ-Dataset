import java.util.Scanner;

class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            boolean[][] rowCheck = new boolean[n][n];
            boolean[][] columnCheck = new boolean[n][n];
            boolean[] rowCounted = new boolean[n];
            boolean[] columnCounted = new boolean[n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();

                    if (row == col) {
                        trace += value;
                    }

                    if (rowCheck[row][value - 1] && !rowCounted[row]) {
                        duplicateRows++;
                        rowCounted[row] = true;
                    }

                    if (columnCheck[col][value - 1] && !columnCounted[col]) {
                        duplicateColumns++;
                        columnCounted[col] = true;
                    }

                    rowCheck[row][value - 1] = true;
                    columnCheck[col][value - 1] = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}