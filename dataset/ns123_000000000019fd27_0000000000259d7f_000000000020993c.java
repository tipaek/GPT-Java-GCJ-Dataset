import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static int calculateTrace(int[][] matrix) {
        int sum = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        Set<Integer> rowSet = new HashSet<>();
        for (int[] rows : matrix) {
            for (int colIndex = 0; colIndex < matrix.length; colIndex++) {
                if (rowSet.contains(rows[colIndex])) {
                    duplicateRowCount++;
                    break;
                } else {
                    rowSet.add(rows[colIndex]);
                }
            }
            rowSet.clear();
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        Set<Integer> columnSet = new HashSet<>();
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (columnSet.contains(matrix[i][j])) {
                    duplicateColumnCount++;
                    break;
                } else {
                     columnSet.add(matrix[i][j]);
                }
            }
            columnSet.clear();
        }

        return duplicateColumnCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int caseId = 1; caseId <= tests; ++caseId) {
            int matrixSize = in.nextInt();

            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int duplicateRowCount = countDuplicateRows(matrix);
            int duplicateColCount = countDuplicateColumns(matrix);

            System.out.println(String.format("Case #%d: %d %d %d", caseId, trace, duplicateRowCount, duplicateColCount));
        }
    }
}