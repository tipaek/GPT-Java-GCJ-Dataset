import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            
            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    repeatedRows++;
                }
            }
            
            // Check for repeated elements in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    repeatedColumns++;
                }
            }
            
            System.out.println("Case #" + t + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
        
        sc.close();
    }
}