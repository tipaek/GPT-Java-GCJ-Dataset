import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int gridSize = scanner.nextInt();
            int[][] matrix = new int[gridSize][gridSize];
            scanner.nextLine();
            
            for (int i = 0; i < gridSize; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < gridSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
            
            int traceValue = calculateTrace(matrix, gridSize);
            int duplicateRows = countDuplicateRows(matrix, gridSize);
            int duplicateCols = countDuplicateCols(matrix, gridSize);
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, traceValue, duplicateRows, duplicateCols);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            if (!isUnique(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int j = 0; j < size; j++) {
            if (!isUnique(getColumn(matrix, j))) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static boolean isUnique(int[] array) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            uniqueElements.add(value);
        }
        return uniqueElements.size() == array.length;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}