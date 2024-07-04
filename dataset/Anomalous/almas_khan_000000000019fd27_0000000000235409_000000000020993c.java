import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Checking rows for duplicates
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowCount++;
                }
            }

            // Checking columns for duplicates
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(getColumn(matrix, i))) {
                    colCount++;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    // Function to check if an array has duplicates
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Function to get a column from the matrix as an array
    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}