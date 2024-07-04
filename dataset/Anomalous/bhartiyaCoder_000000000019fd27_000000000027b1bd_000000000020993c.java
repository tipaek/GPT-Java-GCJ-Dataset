import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
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
                
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
                if (colSet.size() != n) {
                    duplicateCols++;
                }
            }
            
            System.out.println("Case #" + c + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        sc.close();
    }
}