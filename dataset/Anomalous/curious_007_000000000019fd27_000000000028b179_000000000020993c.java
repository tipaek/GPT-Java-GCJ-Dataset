import java.util.*;

public class Glad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            long trace = 0;
            int rowCount = 0;
            int colCount = 0;
            
            boolean[] rowHasDuplicate = new boolean[n];
            boolean[] colHasDuplicate = new boolean[n];
            
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    int value = sc.nextInt();
                    matrix[j][k] = value;
                    
                    if (j == k) {
                        trace += value;
                    }
                    
                    if (!rowSet.add(value)) {
                        rowHasDuplicate[j] = true;
                    }
                }
            }
            
            for (int k = 0; k < n; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colHasDuplicate[k] = true;
                    }
                }
            }
            
            for (boolean hasDuplicate : rowHasDuplicate) {
                if (hasDuplicate) {
                    rowCount++;
                }
            }
            
            for (boolean hasDuplicate : colHasDuplicate) {
                if (hasDuplicate) {
                    colCount++;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        sc.close();
    }
}