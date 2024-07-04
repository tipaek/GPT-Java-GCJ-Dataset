import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            String result = analyzeMatrix(matrixSize, matrix);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String analyzeMatrix(int size, int[][] matrix) {
        int trace = 0;
        int faultyRows = 0;
        int faultyColumns = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            if (hasDuplicate(matrix[i])) {
                faultyRows++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicate(column)) {
                faultyColumns++;
            }
        }

        return trace + " " + faultyRows + " " + faultyColumns;
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}