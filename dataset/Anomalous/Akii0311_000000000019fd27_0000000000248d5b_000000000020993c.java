import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowCount = countDuplicateRows(matrix, n);
            int colCount = countDuplicateCols(matrix, n);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
            caseNumber++;
        }

        sc.close();
    }

    public static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRowCount = 0;

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    public static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateColCount = 0;

        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicates(column)) {
                duplicateColCount++;
            }
        }

        return duplicateColCount;
    }

    public static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}