 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int[][] m = new int[n][n];
          int sum=0;
          int col=0,row=0;
          for(int j=0;j<n;j++)for(int k=0;k<n;k++)m[j][k] = in.nextInt();
          for(int j=0;j<n;j++)sum += m[j][j];
          
          for(int j=0;j<n;j++)
          {
              boolean[] check = new boolean[n+1];
              int k;
              for(k=0;k<n;k++)
              {
                  if(check[m[j][k]])break;
                  check[m[j][k]]=true;
              }
              if(k<n)row++;
          }
          
          for(int j=0;j<n;j++)
          {
              boolean[] check = new boolean[n+1];
              int k;
              for(k=0;k<n;k++)
              {
                  if(check[m[k][j]])break;
                  check[m[k][j]]=true;
              }
              if(k<n)col++;
          }
          
          System.out.println("Case #"+i+": "+sum+ " "+row+ " "+ col);
          
        }
      }
    }