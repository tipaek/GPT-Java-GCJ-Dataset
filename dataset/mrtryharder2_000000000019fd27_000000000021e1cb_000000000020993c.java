/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MTH2
 */
import java.util.Scanner;
public class Vestigium {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int t = input.nextInt();
        
         int[] cases = new int[t + 1];
         int[] repeated_rows = new int[t + 1];
         int[] repeated_cols = new int[t + 1];
         int[] traces = new int[t + 1];
        
        for(int h = 1; h <= t; h++) {
            
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
           
            
            cases[h] = h;
            
            for(int i = 0; i < matrix.length; i++)
                for(int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = input.nextInt();
        
            int r_row_count = getRepeatedRows(matrix);
            if(r_row_count != 0) repeated_rows[h] = r_row_count;
            
            int r_col_count = getRepeatedColumns(matrix);
            if(r_col_count != 0) repeated_cols[h] = r_col_count;
            
            traces[h] = getTrace(matrix);
            
            if(h == t) printResults(cases, traces, repeated_rows, repeated_cols);
        }
        
        
       
       
    }
    
 
     public static int getRepeatedRows(int[][] matrix) {
        
         int r_row_count = 0;
        //find number of rows with repeated values
        for(int i = 0; i < matrix.length; i++) {
           outer_loop1:
            for(int j = 0; j < matrix[0].length; j++) {
                
                for(int k = j + 1; k < matrix.length; k++)
                    if(matrix[i][j] == matrix[i][k]) {
                        r_row_count++;
                        break outer_loop1;
                    } 
                
                
            }
        }
        return r_row_count;
     } 
     
     public static int getRepeatedColumns(int[][] matrix) {
         
         int r_col_count = 0;
        //find number of columns with repeated values 
       for(int i = 0; i < matrix.length; i++) {
           outer_loop2:
            for(int j = 0; j < matrix[0].length; j++) {
                
                for(int k = j + 1; k < matrix.length; k++)
                    if(matrix[j][i] == matrix[k][i]) {
                        r_col_count++;
                        break outer_loop2;
                    } 
                
                
            }
        }
        
       return r_col_count;
     }  
       
     public static int getTrace(int[][] matrix) {
         
        int trace = 0;
        for(int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
 
        }
            
            
            
        return trace;
    }
    
    public static void printResults(int[] cases, int[] traces, int[] repeated_rows, int[] repeated_cols) {
        
        for(int i = 1; i <= cases.length - 1; i++)
            System.out.println("Case #" + cases[i] + ": " + traces[i]+ " " + repeated_rows[i] + " " + repeated_cols[i]);
    }
    
}