/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vestigium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author mertyentur
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();

        for(int i = 1; i <= testCases; i++){
            traceSystem(s, i);
        }
    }
    
    private static void traceSystem(Scanner s, int testCase){
        int N = s.nextInt();
        int[][] matrix = new int[N][N];
        int t = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                matrix[i][j] = s.nextInt();
                
                if(i == j)
                    t += matrix[i][j];
            }
        }
        
        int repeatRow = 0;
        int repeatColumn = 0;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        
        for(int i = 0; i < N; i++){
            rowSet.clear();
            columnSet.clear();
            
            for(int j = 0; j < N; j++){
                rowSet.add(matrix[i][j]);
                columnSet.add(matrix[j][i]);
            }
            
            if(rowSet.size() != N)
                repeatRow++;
            
            if(columnSet.size() != N)
                repeatColumn++;
        }
        
        System.out.println(String.format("Case #%d: %d %d %d", testCase, t, repeatRow, repeatColumn));
    }
}
