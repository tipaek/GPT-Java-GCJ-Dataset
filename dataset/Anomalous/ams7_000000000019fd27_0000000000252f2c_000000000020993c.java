import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() != matrixSize) {
                    rowCount++;
                }
                if (colSet.size() != matrixSize) {
                    colCount++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowCount, colCount);
        }

        scanner.close();
    }
}