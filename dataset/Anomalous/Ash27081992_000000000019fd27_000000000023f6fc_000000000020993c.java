import java.util.Scanner;

public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int size = SCANNER.nextInt();
            processTestCase(size, i + 1);
        }
    }
    
    public static void processTestCase(int size, int testCaseNumber) {
        int[][] matrix = new int[size][size];
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;
        
        // Read matrix and calculate the diagonal sum
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = SCANNER.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }
        
        // Check for duplicate elements in rows
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }
        
        // Check for duplicate elements in columns
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        
        System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
    }
    
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (value > 0 && value <= array.length && seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}