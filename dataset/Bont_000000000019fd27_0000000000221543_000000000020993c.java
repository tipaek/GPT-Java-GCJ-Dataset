import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 0; t <  T; t++) {
      int N = in.nextInt();
      int[][] arr = new int[N][N];
      int countrow=0;
      int countcol=0;
      int sum = 0;
      for(int i=0;i<N;i++)
      {
          int[] check = new int[N];
          boolean flag = false;
          for(int j=0;j<N;j++)
          {
              arr[i][j] = in.nextInt();
              check[arr[i][j] - 1]++;
              if(check[arr[i][j] - 1]>1)
                  flag=true;
          
              if(i==j)
                  sum = sum + arr[i][j] ;
          }
          if(flag==true)
             countrow++;
      }
      for(int i=0;i<N;i++)
      {
          int[] check1 = new int[N];
          boolean flag = false;
          for(int j=0;j<N;j++)
          {
              
              check1[arr[j][i]-1]++;
              if(check1[arr[j][i]-1]>1)
                  flag=true;
              
          }
          if(flag==true)
             countcol++;
      }
      
      System.out.println("Case #" + t + ": " + (sum) + " " + (countrow) + " " + countcol);
    }
  }
}