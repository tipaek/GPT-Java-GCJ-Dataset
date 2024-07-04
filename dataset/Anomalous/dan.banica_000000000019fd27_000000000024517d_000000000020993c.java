import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private void run() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numberOfTests = scanner.nextInt();
        int[][] matrix = new int[100][100];
        
        for (int test = 0; test < numberOfTests; test++) {
            int n = scanner.nextInt();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int invalidRows = countInvalidRows(matrix, n);
            int invalidCols = countInvalidColumns(matrix, n);
            
            System.out.printf("%d %d %d%n", trace, invalidRows, invalidCols);
        }
    }
    
    private int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private int countInvalidRows(int[][] matrix, int size) {
        int invalidRows = 0;
        for (int i = 0; i < size; i++) {
            if (!hasAllDistinctElements(matrix[i], size)) {
                invalidRows++;
            }
        }
        return invalidRows;
    }
    
    private int countInvalidColumns(int[][] matrix, int size) {
        int invalidCols = 0;
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (!hasAllDistinctElements(column, size)) {
                invalidCols++;
            }
        }
        return invalidCols;
    }
    
    private boolean hasAllDistinctElements(int[] array, int size) {
        boolean[] seen = new boolean[size + 1];
        for (int value : array) {
            if (seen[value]) {
                return false;
            }
            seen[value] = true;
        }
        return true;
    }
    
    public static void main(String[] args) {
        new Solution().run();
    }
}