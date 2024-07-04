import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int repeatedRows = countRowsWithRepeatedElements(matrix);
            int repeatedCols = countColsWithRepeatedElements(matrix);
            
            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithRepeatedElements(int[][] matrix) {
        int repeatedRows = 0;
        for (int[] row : matrix) {
            if (hasRepeatedElements(row)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countColsWithRepeatedElements(int[][] matrix) {
        int repeatedCols = 0;
        int size = matrix.length;
        
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasRepeatedElements(column)) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }

    private static boolean hasRepeatedElements(int[] array) {
        int[] count = new int[array.length + 1];
        for (int num : array) {
            count[num]++;
            if (count[num] > 1) {
                return true;
            }
        }
        return false;
    }
}