import java.util.HashSet;
import java.util.Scanner;

class Vestigium {
    
    public static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    public static boolean hasDuplicateInRow(int[][] matrix, int row, int size) {
        HashSet<Integer> seen = new HashSet<>();
        for (int col = 0; col < size; col++) {
            if (!seen.add(matrix[row][col])) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean hasDuplicateInColumn(int[][] matrix, int col, int size) {
        HashSet<Integer> seen = new HashSet<>();
        for (int row = 0; row < size; row++) {
            if (!seen.add(matrix[row][col])) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, size);
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            for (int i = 0; i < size; i++) {
                if (hasDuplicateInRow(matrix, i, size)) {
                    duplicateRows++;
                }
                if (hasDuplicateInColumn(matrix, i, size)) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            caseNumber++;
        }
        
        scanner.close();
    }
}