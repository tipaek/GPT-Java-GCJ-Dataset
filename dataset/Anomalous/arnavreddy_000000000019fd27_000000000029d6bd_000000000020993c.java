import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int traceValue = calculateTrace(matrix, n);
            int rowCount = countRepeatedRows(matrix, n);
            int colCount = countRepeatedCols(matrix, n);
            
            System.out.println("Case #" + i + ": " + traceValue + " " + rowCount + " " + colCount);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int count = 0;
        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size + 1];
            for (int col = 0; col < size; col++) {
                if (seen[matrix[row][col]]) {
                    count++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return count;
    }

    private static int countRepeatedCols(int[][] matrix, int size) {
        int count = 0;
        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size + 1];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col]]) {
                    count++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return count;
    }
}