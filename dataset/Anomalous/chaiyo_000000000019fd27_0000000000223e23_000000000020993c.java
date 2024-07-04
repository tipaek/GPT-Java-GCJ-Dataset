package ggcj_2020;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    
    public static void analyzeMatrix(int[][] matrix, int N, int caseNumber) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;
        
        for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (rowSet.size() != N) {
                repeatedRows++;
            }
            if (colSet.size() != N) {
                repeatedCols++;
            }
        }
        
        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedCols);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            analyzeMatrix(matrix, N, t);
        }
        
        scanner.close();
    }
}