import java.io.*;
import java.util.*;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.regex.*;
import java.io.*;
import java.math.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.text.*;
import java.util.Locale;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      
      int n = Integer.parseInt(in.nextLine());
      Integer[][] map = new Integer[n][n];
      Integer[][] map2 = new Integer[n][n];
        int dia = 0;     
      for(int j = 0; j < n; j++ ){
          String[] pom = in.nextLine().split(" ");
          for(int k = 0; k < n; k++ ){
              if(j == k) dia += Integer.parseInt(pom[k]);
              map[j][k] = Integer.parseInt(pom[k]);
              map2[k][j] = Integer.parseInt(pom[k]);
          }
      }
      int rowC = 0;
      int colC = 0;
      for(int j = 0; j < n; j++ ){
          List<Integer> list = Arrays.asList( map[j] );
          Set<Integer> set = new HashSet<Integer>(list);
           if(set.size() < n) rowC++;
      }
      
      for(int j = 0; j < n; j++ ){
          List<Integer> list = Arrays.asList( map2[j] );
          Set<Integer> set = new HashSet<Integer>(list);
           if(set.size() < n) colC++;
      }
       
      System.out.println("Case #" + i + ": " + (dia) + " " + (rowC) + " " + (colC));
    }
  }
}