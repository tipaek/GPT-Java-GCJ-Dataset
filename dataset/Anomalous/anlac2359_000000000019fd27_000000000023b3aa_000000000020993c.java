import java.util.*;
import java.io.*;

public class Solution {
    private static boolean hasDuplicates(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.merge(num, 1, Integer::sum);
        }
        for (int count : countMap.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            int rowDuplicates = 0;
            for (int i = 0; i < matrixSize; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            int columnDuplicates = 0;
            for (int j = 0; j < matrixSize; j++) {
                int[] column = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}