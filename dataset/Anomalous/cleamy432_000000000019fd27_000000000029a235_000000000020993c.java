import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= numberOfTestCases; testCaseNumber++) {
            int matrixDimension = scanner.nextInt();
            int[][] matrix = new int[matrixDimension][matrixDimension];

            int traceSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int row = 0; row < matrixDimension; row++) {
                for (int col = 0; col < matrixDimension; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                traceSum += matrix[row][row];
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }
            duplicateColumns = countColumnDuplicates(matrix);
            System.out.printf("Case #%d: %d %d %d\n", testCaseNumber, traceSum, duplicateRows, duplicateColumns);
        }
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}