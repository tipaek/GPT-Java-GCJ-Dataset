import java.util.*;
import java.io.*;

class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = sc.nextInt();

        for (int caseIndex = 1; caseIndex <= testCaseCount; caseIndex++) {
            System.out.println("Enter the matrix size");
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, size);
            int duplicateRowsCount = countDuplicateRows(matrix, size);
            int duplicateColumnsCount = countDuplicateColumns(matrix, size);

            System.out.println("Case #" + caseIndex + ": " + diagonalSum + " " + duplicateRowsCount + " " + duplicateColumnsCount);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int j = 0; j < size; j++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!columnSet.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }
}