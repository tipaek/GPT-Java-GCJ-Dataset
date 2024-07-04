import java.util.*;
import java.io.*;
 class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
          int n = in.nextInt();
          int arr[][] = new int[n][n];
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  arr[i][j] = in.nextInt();
              }
          }
          
          int trace = 0;
          for(int i=0;i<n;i++){
              trace+=arr[i][i];
          }
          
          int r = 0, c = 0;
          int row[] = new int[n];
          int col[] = new int[n];
          for(int i=0;i<n;i++){
              Arrays.fill(row,0);
              Arrays.fill(col,0);
              for(int j=0;j<n;j++){
                  if(row[arr[i][j]-1] > 0)
                  {
                      r++;
                      break;
                  }
                  else{
                     row[arr[i][j]-1]++;
                  }
                  
              }
              for(int j=0;j<n;j++){
                  if(col[arr[j][i]-1] > 0)
                  {
                      c++;
                      break;
                  }
                  else{
                     col[arr[j][i]-1]++;
                  }
                  
              }
          }
          
          System.out.println("Case #" + k + ": " + trace + " " + r + " " + c);
        }
      }
    }
  