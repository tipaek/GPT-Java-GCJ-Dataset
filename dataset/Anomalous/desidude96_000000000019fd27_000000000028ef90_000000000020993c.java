import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            List<List<Integer>> matrixRows = new ArrayList<>();
            List<Integer> currentRow = new ArrayList<>();
            for (int elementIndex = 0; elementIndex < matrixSize * matrixSize; elementIndex++) {
                currentRow.add(scanner.nextInt());
                if (currentRow.size() == matrixSize) {
                    matrixRows.add(currentRow);
                    currentRow = new ArrayList<>();
                }
            }
            int[][] matrix = convertToMatrix(matrixRows);
            System.out.println("Case #" + caseIndex + ": " + evaluateMatrix(matrix));
        }
    }

    private static int[][] convertToMatrix(List<List<Integer>> rows) {
        int size = rows.size();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            List<Integer> row = rows.get(i);
            for (int j = 0; j < size; j++) {
                matrix[i][j] = row.get(j);
            }
        }
        return matrix;
    }

    private static String evaluateMatrix(int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                rowSet.add(matrix[i][j]);
                columnSet.add(matrix[j][i]);
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            if (rowSet.size() != matrix.length) {
                duplicateRows++;
            }
            if (columnSet.size() != matrix.length) {
                duplicateColumns++;
            }
        }

        return trace + " " + duplicateRows + " " + duplicateColumns;
    }
}