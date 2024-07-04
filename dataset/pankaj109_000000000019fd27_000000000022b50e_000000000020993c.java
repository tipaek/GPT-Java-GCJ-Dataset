import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int[][]M=new int[n][n];
          for(int j=0;j<n;j++){
              for(int k=0;k<n;k++){
                  M[j][k]=in.nextInt();
              }
          }
          int trace=0;
          for(int j=0;j<n;j++){
              trace+=M[j][j];
          }
          int r=0;
          int c=0;
          for(int j=0;j<n;j++){
              int rj[]=new int[n];
              for(int k=0;k<n;k++){
                  if(rj[M[j][k]-1]==1){
                      r++;
                      break;
                  }
                  rj[M[j][k]-1]=1;
              }
          }
          for(int j=0;j<n;j++){
              int cj[]=new int[n];
              for(int k=0;k<n;k++){
                  if(cj[M[k][j]-1]==1){
                      c++;
                      break;
                  }
                  cj[M[k][j]-1]=1;
              }
          }
          System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
      }
    }