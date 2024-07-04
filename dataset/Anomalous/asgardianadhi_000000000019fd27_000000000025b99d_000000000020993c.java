import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            
            int rowCount = 0, colCount = 0, diagonalSum = 0;
            
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowCount++;
                }
                
                int[] column = new int[n];
                for (int k = 0; k < n; k++) {
                    column[k] = matrix[k][j];
                }
                
                if (hasDuplicates(column)) {
                    colCount++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }
            
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + rowCount + " " + colCount);
        }
    }
    
    public static boolean hasDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}