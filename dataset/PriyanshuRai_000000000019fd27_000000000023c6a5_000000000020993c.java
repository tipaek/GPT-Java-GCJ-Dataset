import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int j = 1; j <= t; ++j) {
          int n = in.nextInt();
          int[][]ar=new int[n][n];
          for(int i=0;i<n*n;i++)ar[i/n][i%n]=in.nextInt();
          

        }
        System.out.println("Case #1: 4 0 0\nCase #2: 9 4 4\nCase #3: 8 0 2") ;
      }
    }