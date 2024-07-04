import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int c = 1; c <= t; c++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int duplicateRows = 0, duplicateCols = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                boolean rowDuplicate = false;
                boolean colDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    if (!rowDuplicate && !rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        rowDuplicate = true;
                    }
                    if (!colDuplicate && !colSet.add(matrix[j][i])) {
                        duplicateCols++;
                        colDuplicate = true;
                    }
                }
            }
            
            System.out.println("Case #" + c + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        sc.close();
    }
}