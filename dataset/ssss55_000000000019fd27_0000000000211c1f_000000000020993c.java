    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int[][] arr = new int[n][n];
          for (int j = 0; j < n; ++j){
            for(int k = 0; k < n; ++k){
                arr[j][k] = in.nextInt();
            }
          }
          int r = 0;
          int c = 0;
          int[] testing = new int[n];
          for(int j = 0; j < n; ++j){
            for(int k = 0; k < n; ++k){
                ++testing[arr[j][k] -1];
                if(testing[arr[j][k] - 1] > 1){
                    //System.out.println("j: " + j + " k: " + k);
                    ++c;
                    break;
                }
            }
            testing = new int[n];
          }
          testing = new int[n];
          for(int j = 0; j < n; ++j){
            for(int k = 0; k < n; ++k){
                ++testing[arr[k][j] - 1];
                if(testing[arr[k][j] - 1] > 1){
                    ++r;
                    break;
                }
            }
            testing = new int[n];
          }
          int k = 0;
          for(int j = 0; j < n; ++j){
            k += arr[j][j];
          }
          System.out.println("Case #" + i + ":"+ " " + k + " " + c + " " + r);
      }
    }
    }