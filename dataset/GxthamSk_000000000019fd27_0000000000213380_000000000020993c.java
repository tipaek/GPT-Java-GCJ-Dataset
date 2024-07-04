import java.util.*;
import java.io.*;
    
    public class Solution {

      public static int[] answer(int[][] matrix, int n){
          int rowsR = 0;
          int colsR = 0;
          int trace = 0;
          
          for(int i = 0; i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++){
              if(set.contains(matrix[i][j])){
                  rowsR++;
                  break;
              }else{
                set.add(matrix[i][j]);
              }
            }
            set.clear();
          }
          // columns
          for(int i = 0; i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++){
              if(set.contains(matrix[j][i])){
                  colsR++;
                  break;
              }else{
                set.add(matrix[j][i]);
              }
            }
            set.clear();
          }
          for(int i = 0; i < n; i++){
            trace += matrix[i][i];
          }
        return new int[]{trace,rowsR,colsR};
      }
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        int n = 0;
        for (int i = 1; i <= t; ++i) {
           n = in.nextInt();  
           int[][] matrix = new int[n][n];
          for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
              matrix[r][c] = in.nextInt();
            }
          //int n = in.nextInt();
          //int m = in.nextInt();
          }
          int[] out = answer(matrix, n);
          System.out.println("Case #" + i + ": " + out[0] + " " + out[1] + " " + out[2]);
        } 

        /* OUTPUT
          System.out.println();
          for (int i = 1; i <= t; ++i) {
            for(int r = 0; r < n; r++){
              for(int c = 0; c < n; c++){
                System.out.print(matrix[r][c] + " ");
              }
              System.out.println();
            }
          }
        }
        */
    }
  }