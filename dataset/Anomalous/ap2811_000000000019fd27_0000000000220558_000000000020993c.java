import java.io.*;
import java.util.*;

public class MatrixAnalysis {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(getColumn(matrix, j))) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
    
    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}