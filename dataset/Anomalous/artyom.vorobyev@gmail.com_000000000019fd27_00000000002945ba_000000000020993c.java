import java.util.Scanner;

public class Solution {

    static int duplicateRows, duplicateCols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, duplicateRows, duplicateCols);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int size = matrix.length;
        duplicateRows = 0;
        duplicateCols = 0;
        
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }
        
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateCols++;
            }
        }

        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}