import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            
            // Read the matrix and calculate the sum of the diagonal elements
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            // Check for repeated elements in each row
            for (int i = 0; i < n; i++) {
                if (hasRepeatedElements(matrix[i])) {
                    repeatedRows++;
                }
            }
            
            // Check for repeated elements in each column
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasRepeatedElements(column)) {
                    repeatedColumns++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
        
        scanner.close();
    }
    
    private static boolean hasRepeatedElements(int[] array) {
        boolean[] seen = new boolean[array.length];
        Arrays.fill(seen, false);
        
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        
        return false;
    }
}