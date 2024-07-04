import java.util.*;
import java.io.*;

public class Solution {
    private static String calculateMatrixProperties(int[][] matrix) {
        int trace = 0, duplicateRows = 0, duplicateColumns = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSet.size() != size) {
                duplicateRows++;
            }
            if (colSet.size() != size) {
                duplicateColumns++;
            }
        }

        return String.format("%d %d %d", trace, duplicateRows, duplicateColumns);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            String result = calculateMatrixProperties(matrix);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}