import java.util.*;
import java.io.*;

public class Solution {

    private static boolean hasDuplicates(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        for (int count : frequencyMap.values()) {
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

            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            int rowDuplicates = 0;
            int[] rowArray = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    rowArray[j] = matrix[i][j];
                }
                if (hasDuplicates(rowArray)) {
                    rowDuplicates++;
                }
            }

            int colDuplicates = 0;
            int[] colArray = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    colArray[j] = matrix[j][i];
                }
                if (hasDuplicates(colArray)) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}