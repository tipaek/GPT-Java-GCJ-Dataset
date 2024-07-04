import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int[][] mat=new int[100][100];
        for (int i1 = 1; i1 <= t; ++i1) {
          int n = in.nextInt();
          //size of matrix
          
          int r=0,c=0,sum=0;
          
          //initial duplicate row-col count
          
          for (int i=0;i<n;i++){
              for (int j=0;j<n;j++){
                  mat[i][j]=in.nextInt();
                  if(i==j){
                      sum+=mat[i][j];
                  }
              }
          }
          for(int i=1,j=1;i<n || j<n;){
                  if(mat[i][j]==mat[i][j-1]){
                    r++;
                    i++;
                  }
                  if(mat[i][j]==mat[i-1][j]){
                      c++;
                      j++;
                  }
          }
          
          
          
          
          System.out.println("Case #" + i1 + ": " + sum + " " + r+" "+c);
        }
      }
    }
  
