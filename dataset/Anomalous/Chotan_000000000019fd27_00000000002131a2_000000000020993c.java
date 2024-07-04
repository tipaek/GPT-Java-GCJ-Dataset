import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            
            // Calculate trace and row repetitions
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowCount++;
                }
            }
            
            // Calculate column repetitions
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                    }
                }
                if (colHasDuplicate) {
                    colCount++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        sc.close();
    }
}