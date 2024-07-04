import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int row = 0; row < n; row++) {
                boolean rowHasRepeat = false;
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                trace += matrix[row][row];
                if (hasDuplicate(matrix[row])) {
                    rowHasRepeat = true;
                }
                if (rowHasRepeat) {
                    rowRepeats++;
                }
            }

            for (int col = 0; col < n; col++) {
                if (hasDuplicate(getColumn(matrix, col))) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}