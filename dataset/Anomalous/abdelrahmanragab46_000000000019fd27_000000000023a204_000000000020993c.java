import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int T = input.nextInt();  // Number of test cases
        
        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];
            
            // Read matrix values
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = input.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, N);
            int repeatedRows = countRepeatedRows(matrix, N);
            int repeatedColumns = countRepeatedColumns(matrix, N);
            
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, repeatedRows, repeatedColumns);
        }
        
        input.close();
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;
        for (int row = 0; row < size; row++) {
            if (hasDuplicates(matrix[row])) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }
    
    private static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatedColumns = 0;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}