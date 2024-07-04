 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int d = in.nextInt();
          int[][] input = new int[d][d];
          for(int m = 0; m < d; ++m){
              for(int n = 0; n < d; ++n){
                  input[m][n] = in.nextInt();
              }
          }
          System.out.println("Case #" + i + ": " + trace(input)
                                + " " + getR(input) + " " + getC(input));
        }
      }
      
      public static int trace(int[][] input){
          int d = input.length;
          int trace = 0;
          for(int i = 0; i < d; ++i) trace += input[i][i];
          return trace;
      }
      
      public static int getR(int[][] input){
          int d = input.length;
          int res = 0;
          
           for(int m = 0; m < d; ++m){
              HashSet<Integer> nums = new HashSet();
              for(int n = 0; n < d; ++n){
                  if(!nums.add(input[m][n])){
                      ++res;
                      break;
                  }
              }
           }
           
           return res;
      }
      
       public static int getC(int[][] input){
          int d = input.length;
          int res = 0;
          
           for(int m = 0; m < d; ++m){
              HashSet<Integer> nums = new HashSet();
              for(int n = 0; n < d; ++n){
                  if(!nums.add(input[n][m])){
                      ++res;
                      break;
                  }
              }
           }
           
           return res;
      }
    }
  
