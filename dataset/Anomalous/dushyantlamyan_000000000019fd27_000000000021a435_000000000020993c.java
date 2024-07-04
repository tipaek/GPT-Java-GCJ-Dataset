import java.util.*;
import java.io.*;

public class Solution {
    static int total = 0;
    static int duplicateRows = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposeMatrix = new int[matrixSize][matrixSize];
            int duplicateCols = 0;

            for (int row = 0; row < matrixSize; ++row) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = scanner.nextInt();
                    rowSet.add(matrix[row][col]);
                    if (rowSet.size() < col + 1) {
                        duplicateCols++;
                    }
                    transposeMatrix[col][row] = matrix[row][col];
                }
            }

            calculateTraceAndDuplicates(matrix, matrixSize, transposeMatrix);
            System.out.println("Case #" + caseNum + ": " + total + " " + duplicateCols + " " + duplicateRows);
        }
    }

    public static void calculateTraceAndDuplicates(int[][] matrix, int matrixSize, int[][] transposeMatrix) {
        for (int row = 0; row < matrixSize; ++row) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int col = 0; col < matrixSize; ++col) {
                if (row == col) {
                    total += matrix[row][col];
                }
                rowSet.add(matrix[row][col]);
                if (rowSet.size() < col + 1) {
                    duplicateRows++;
                }
            }
        }
    }
}