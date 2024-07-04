import java.util.*;

public class CODEJAM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int[] traceResults = new int[t];
        int[] rowDuplicates = new int[t];
        int[] colDuplicates = new int[t];
        
        for (int g = 0; g < t; g++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            int trace = 0;
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowsWithDuplicates++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                    }
                }
                if (colHasDuplicate) {
                    colsWithDuplicates++;
                }
            }
            
            traceResults[g] = trace;
            rowDuplicates[g] = rowsWithDuplicates;
            colDuplicates[g] = colsWithDuplicates;
        }
        
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traceResults[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
        }
    }
}