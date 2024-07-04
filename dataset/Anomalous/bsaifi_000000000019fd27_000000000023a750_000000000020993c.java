import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);
            
            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
    
    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateCount = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        
        return duplicateCount;
    }
    
    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCount = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        
        return duplicateCount;
    }
}