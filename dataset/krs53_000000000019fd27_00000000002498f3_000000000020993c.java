import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
      int matrix[][];
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int repeatRowCount = 0;
          int repeatColumnCount = 0;
          int trace = 0;
          int n = in.nextInt();
          matrix = new int[n][n];
          // init matrix
          for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
              matrix[r][c] = in.nextInt();
            }
          }
          //trace
          for(int k = 0; k < n; k++){
            trace += matrix[k][k];
          }
          //repeatRowCount
          for(int k = 0; k < n; k++){
            if(duplicate(matrix[k])){
              repeatRowCount++;
            }
          }
          //repeatColumnCount
          for(int k = 0; k < n; k++){
             if(duplicate(getColumnArray(matrix, k))){
              repeatColumnCount++;
            }
          }
          System.out.println("Case #" + i + ": " + (trace) + " " + (repeatRowCount) + " " + (repeatColumnCount));
        }
      }
      
      private static int[] getColumnArray(int[][] array, int index){
        int[] column = new int[array[0].length];
        for(int i = 0; i < column.length; i++){
          column[i] = array[i][index];
        }
        return column;
      }
      
      private static boolean duplicate(int[] array){
      for(int i = 0; i < array.length; i++){
        for(int j = 0; j < array.length; j++){
          if(i!=j && array[i] == array[j]){
            return true;
          }
        }
      }
      return false;
      }
    }