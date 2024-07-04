import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                System.out.printf("Case #%d: ", i);
                processTestCase(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(Scanner scanner) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        HashMap<Integer, Integer> valueCount = new HashMap<>(matrixSize);

        long trace = 0;
        int duplicateRows = 0, duplicateCols = 0;

        for (int i = 1; i <= matrixSize; i++) {
            valueCount.put(i, 0);
        }

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        duplicateRows = countDuplicates(matrix, valueCount, matrixSize, true);
        duplicateCols = countDuplicates(matrix, valueCount, matrixSize, false);

        System.out.println(trace + " " + duplicateRows + " " + duplicateCols);
    }

    private static int countDuplicates(int[][] matrix, HashMap<Integer, Integer> valueCount, int size, boolean isRow) {
        int duplicateCount = 0;

        for (int i = 0; i < size; i++) {
            valueCount.replaceAll((k, v) -> 0);

            for (int j = 0; j < size; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (valueCount.get(value) > 0) {
                    duplicateCount++;
                    break;
                }
                valueCount.put(value, valueCount.get(value) + 1);
            }
        }

        return duplicateCount;
    }
}