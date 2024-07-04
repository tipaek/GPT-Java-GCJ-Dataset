import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowCount = countDuplicateRows(matrix, n);
            int colCount = countDuplicateColumns(matrix, n);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
            caseNumber++;
        }
    }

    public static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRowCount = 0;

        for (int i = 0; i < n; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < n - 1; j++) {
                int currentElement = matrix[i][j];
                for (int k = j + 1; k < n; k++) {
                    if (currentElement == matrix[i][k]) {
                        duplicateRowCount++;
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    break;
                }
            }
        }

        return duplicateRowCount;
    }

    public static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumnCount = 0;

        for (int i = 0; i < n; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < n - 1; j++) {
                int currentElement = matrix[j][i];
                for (int k = j + 1; k < n; k++) {
                    if (currentElement == matrix[k][i]) {
                        duplicateColumnCount++;
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    break;
                }
            }
        }

        return duplicateColumnCount;
    }
}