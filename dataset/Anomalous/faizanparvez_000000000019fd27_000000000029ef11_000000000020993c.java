import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            processMatrix(matrix, n);
        }
    }

    private static void processMatrix(int[][] matrix, int n) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowHasDuplicate = true;
                }
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            
            if (rowHasDuplicate) {
                rowDuplicates++;
            }
        }
        
        for (int j = 0; j < n; j++) {
            HashSet<Integer> colSet = new HashSet<>();
            boolean colHasDuplicate = false;
            
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colHasDuplicate = true;
                }
            }
            
            if (colHasDuplicate) {
                colDuplicates++;
            }
        }
        
        System.out.println(" " + trace + " " + rowDuplicates + " " + colDuplicates);
    }
}