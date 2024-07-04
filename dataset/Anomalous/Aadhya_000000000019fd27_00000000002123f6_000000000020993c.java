import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numMatrices = scanner.nextInt();

        for (int caseNum = 0; caseNum < numMatrices; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowCount = countRepeatedRows(matrix, n);
            int colCount = countRepeatedCols(matrix, n);

            System.out.println("Case #" + (caseNum + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int rowCount = 0;
        for (int row = 0; row < n; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    rowCount++;
                    break;
                }
            }
        }
        return rowCount;
    }

    private static int countRepeatedCols(int[][] matrix, int n) {
        int colCount = 0;
        for (int col = 0; col < n; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    colCount++;
                    break;
                }
            }
        }
        return colCount;
    }
}