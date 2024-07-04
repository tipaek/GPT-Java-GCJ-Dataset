import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int sideLength = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[sideLength][sideLength];

            for (int row = 0; row < sideLength; row++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                for (int col = 0; col < sideLength; col++) {
                    matrix[row][col] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = calculateTrace(matrix, sideLength);
            int duplicateRows = countDuplicateRows(matrix, sideLength);
            int duplicateCols = countDuplicateCols(matrix, sideLength);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int calculateTrace(int[][] matrix, int sideLength) {
        int trace = 0;
        for (int i = 0; i < sideLength; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int sideLength) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int sideLength) {
        int duplicateCols = 0;
        for (int col = 0; col < sideLength; col++) {
            int[] columnArray = new int[sideLength];
            for (int row = 0; row < sideLength; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}