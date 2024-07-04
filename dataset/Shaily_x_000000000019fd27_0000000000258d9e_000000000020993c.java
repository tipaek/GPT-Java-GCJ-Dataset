import java.util.*;
import java.io.*;

public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          long trace = 0l;
          int rows=0,cols=0;
          int[][] arr = new int[n][n];
          
          //trace & rows
          int[] values = new int[n+1];
          for(int j=0;j<n;j++){
              for(int m=1;m<=n;m++){
                  values[m]=0;
              }
              int isInc=0;
              for(int k=0;k<n;k++){
                  arr[j][k]=in.nextInt();
                  if(j==k){
                      trace+=arr[j][k];
                  }
                  values[arr[j][k]]++;
                  if(values[arr[j][k]]>1&&isInc==0){
                      rows++;
                      isInc=1;
                  }
              }
          }
          
          //cols
          
          for(int j=0;j<n;j++){
              for(int m=1;m<=n;m++){
                  values[m]=0;
              }
              for(int k=0;k<n;k++){
                  values[arr[k][j]]++;
                  if(values[arr[k][j]]>1){
                    cols++;
                    break;
                  }
              }
          }
          
          
          System.out.println("Case #"+i+": "+trace+" "+rows+" "+cols);
          
        }
      }
}