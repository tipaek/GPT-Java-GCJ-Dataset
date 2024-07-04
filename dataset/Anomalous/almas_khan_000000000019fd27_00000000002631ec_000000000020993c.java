import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

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
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colCount++;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
            caseNumber++;
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}