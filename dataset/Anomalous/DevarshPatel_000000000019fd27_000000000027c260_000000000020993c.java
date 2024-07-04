import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            results.add(processMatrix(matrix, matrixSize));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i) + " ");
        }
    }

    private static String processMatrix(int[][] matrix, int size) {
        int trace = calculateTrace(matrix, size);
        int duplicateRows = countDuplicateRows(matrix, size);
        int duplicateCols = countDuplicateCols(matrix, size);

        return trace + " " + duplicateRows + " " + duplicateCols;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int row = 0; row < size; row++) {
            Map<Integer, Integer> valueMap = new HashMap<>();
            for (int col = 0; col < size; col++) {
                if (valueMap.containsKey(matrix[row][col])) {
                    duplicateCount++;
                    break;
                } else {
                    valueMap.put(matrix[row][col], 1);
                }
            }
        }

        return duplicateCount;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int col = 0; col < size; col++) {
            Map<Integer, Integer> valueMap = new HashMap<>();
            for (int row = 0; row < size; row++) {
                if (valueMap.containsKey(matrix[row][col])) {
                    duplicateCount++;
                    break;
                } else {
                    valueMap.put(matrix[row][col], 1);
                }
            }
        }

        return duplicateCount;
    }
}