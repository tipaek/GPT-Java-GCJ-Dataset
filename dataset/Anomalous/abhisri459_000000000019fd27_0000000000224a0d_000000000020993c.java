import java.util.Scanner;

class Trace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            // Check for duplicate rows
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}