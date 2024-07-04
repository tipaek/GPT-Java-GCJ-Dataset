import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long numCases = scanner.nextLong();
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            String result = calculateVestigium(matrix, size);
            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }
    }

    private static String calculateVestigium(int[][] matrix, int size) {
        int traceValue = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix, size);
        int duplicateCols = countDuplicateColumns(matrix, size);

        return traceValue + " " + duplicateRows + " " + duplicateCols;
    }

    private static int calculateTrace(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> seenElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!seenElements.add(matrix[row][col])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> seenElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!seenElements.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        return duplicateCols;
    }
}