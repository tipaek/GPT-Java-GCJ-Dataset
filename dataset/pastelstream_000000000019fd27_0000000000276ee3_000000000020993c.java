import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] matrix= new int[n][n];
      int row =0;
      while (row<n){
          int column =0;
          while (column<n){
              matrix[row][column]=in.nextInt();
              column+=1;
          }
          row +=1;
      }      
          
      int index = 0;
      int trace = 0;
      
      while (index<n){
          trace += matrix[index][index];
          index +=1;
      }
      
      
      int column_dup=0;
      int row_dup=0;
      
      
      int row_no=0;
      
      //iterate through all the rows to look for within-row duplicates
      while (row_no <n){
          int[] my_row = new int[n];
          int row_flag = 0;
          int column_no=0;
          
          while ((column_no<n)&&(row_flag==0)){
              my_row[matrix[row_no][column_no]-1]+=1;
              if (my_row[matrix[row_no][column_no]-1]>1){
                  row_flag=1;
              }
              column_no+=1;
          }
          
          if (row_flag != 0){
              row_dup+=1;
          }
          row_no+=1;
      }
      
      
      //iterate through all the columns to look for within-row duplicates
      int column_no=0;
      while (column_no <n){
          int[] my_column = new int[n];
          int column_flag = 0;
          ow_no=0;
          
          while ((row_no<n)&&(column_flag==0)){
              my_column[matrix[column_no][row_no]-1]+=1;
              if (my_column[matrix[column_no][row_no]-1]>1){
                  column_flag=1;
              }
              row_no+=1;
          }
          
          if (column_flag != 0){
              column_dup+=1;
          }
          column_no+=1;
      }
      
     
      System.out.println("Case #" + i + ": " + trace + " " + row_dup+ " " + column_dup);
    }
  }
}