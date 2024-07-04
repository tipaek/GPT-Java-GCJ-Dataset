import java.util.*;

class Solution {

    public static int getDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    public static int getDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        return duplicateColumnCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            int duplicateRows = getDuplicateRows(matrix);
            int duplicateColumns = getDuplicateColumns(matrix);

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        scanner.close();
    }
}