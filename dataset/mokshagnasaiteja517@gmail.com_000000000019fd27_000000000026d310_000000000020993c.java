import java.util.*;
import java.io.*;
public class Solution {
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int p= 1; p <= t; ++p) {
        HashSet<Integer> h=new HashSet<Integer>();
          int r=0;
          int c=0;
          int trace=0;
          boolean flag=false;
          int n = in.nextInt();
          int[][] a=new int[n][n];
          for(int i=0;i<n;i++){
              flag=false;
              for(int j=0;j<n;j++){
                  a[i][j]=in.nextInt();
                  if(i==j)
                  trace+=a[i][j];
                  if(!h.contains(a[i][j]))
                  h.add(a[i][j]);
                  else{
                      if(!flag){
                      r++;
                      flag=true;
                      }
                  }
                  
              }
              h.clear();
          }
          for(int j=0;j<n;j++){
              flag=false;
              for(int i=0;i<n;i++){
                  
                  
                  if(!h.contains(a[i][j]))
                  h.add(a[i][j]);
                  else{
                      if(!flag){
                      c++;
                      flag=true;
                      }
                  }
                  
              }
              h.clear();
          }
          System.out.println("Case #"+p+": "+trace+" "+r+" "+c);
          
    }
}
}
