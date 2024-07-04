import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
   Scanner in = new Scanner(System.in);
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
     for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int k = in.nextInt();
          
          if(k%n!=0)
          System.out.println("Case #"+i+": "+"IMPOSSIBLE");
          else{
              System.out.println("Case #"+i+": "+"POSSIBLE");
              int x=n+1;
              for(int j=1;j<=n;j++){
                  int temp=x;
                  while(temp<=n){
                      System.out.print(temp+" ");
                      temp++;
                  }
                  for(int p=1;p<x;p++){
                      System.out.print(p+" ");
                  }
                  x--;
                  System.out.println();
                  
              }
              
              
              
          
          
        }
      }
    }
}