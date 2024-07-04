package google_code_jam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
                
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        duplicateCols++;
                        break;
                    }
                }
            }
            
            System.out.println(trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}