import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            long trace = 0;
            long rowCount = 0;
            long colCount = 0;
            
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;
                
                for (int j = 0; j < N; j++) {
                    int value = sc.nextInt();
                    matrix[i][j] = value;
                    
                    if (!rowSet.add(value)) {
                        hasDuplicateInRow = true;
                    }
                    
                    if (i == j) {
                        trace += value;
                    }
                }
                
                if (hasDuplicateInRow) {
                    rowCount++;
                }
            }
            
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicateInCol = false;
                
                for (int i = 0; i < N; i++) {
                    int value = matrix[i][j];
                    
                    if (!colSet.add(value)) {
                        hasDuplicateInCol = true;
                    }
                }
                
                if (hasDuplicateInCol) {
                    colCount++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        sc.close();
    }
}