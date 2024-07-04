import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          if(n>1){
              long trace = 0l;
          int rows=0,cols=0;
          int[][] arr = new int[n][n];
          
          //trace & rows
          int one=0,two=0,three=0,four=0;
          for(int j=0;j<n;j++){
              one=two=three=four=0;
              for(int k=0;k<n;k++){
                  arr[j][k]=in.nextInt();
                  if(j==k){
                      trace+=arr[j][k];
                  }
                  if(arr[j][k]==1){
                      one++;
                  }
                  else if(arr[j][k]==2){
                      two++;
                  }
                  else if(arr[j][k]==3){
                      three++;
                  }
                  else if(arr[j][k]==4){
                      four++;
                  }
              }
              if(one>1||two>1||three>1||four>1){
                  rows++;
              }
          }
          
          //cols
          
          for(int j=0;j<n;j++){
              one=two=three=four=0;
              for(int k=0;k<n;k++){
                  if(arr[k][j]==1){
                      one++;
                  }
                  else if(arr[k][j]==2){
                      two++;
                  }
                  else if(arr[k][j]==3){
                      three++;
                  }
                  else if(arr[k][j]==4){
                      four++;
                  }
                  if(one>1||two>1||three>1||four>1){
                    cols++;
                    break;
                  }
              }
          }
          
          
          System.out.println("Case #"+i+": "+trace+" "+rows+
          " "+cols);
          }
          
          
        }
      }
    }