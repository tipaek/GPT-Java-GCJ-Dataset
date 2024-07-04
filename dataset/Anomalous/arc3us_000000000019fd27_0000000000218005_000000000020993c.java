import java.util.Scanner;
import java.io.IOException;

class Solution {
    public static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    public static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> columnSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < matrix.length; j++) {
                if (!columnSet.add(matrix[j][i])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            int caseNumber = 1;
            while (t-- > 0) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }

                int diagonalSum = 0;
                for (int i = 0; i < n; i++) {
                    diagonalSum += matrix[i][i];
                }

                int duplicateRows = countDuplicateRows(matrix);
                int duplicateColumns = countDuplicateColumns(matrix);

                System.out.printf("Case #%d: %d %d %d%n", caseNumber++, diagonalSum, duplicateRows, duplicateColumns);
            }
        } catch (Exception e) {
            System.out.println("weird");
        }
    }
}