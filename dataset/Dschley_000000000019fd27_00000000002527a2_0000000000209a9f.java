import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      
      String stringWithParens = putMinParens(s);

      System.out.println("Case #" + i + ": " + stringWithParens);
    }
  }
  
  private static String putMinParens(String s){
      StringBuilder parend = new StringBuilder();
      
      int numOpened = 0;
      
      for(int i = 0; i < s.length(); i++){
          int x = Character.getNumericValue(s.charAt(i));
          
          while(x > numOpened){
              parend.append("(");
              numOpened++;
          }
          
          while(x < numOpened){
              parend.append(")");
              numOpened--;
          }
          
          parend.append(x);
      }
      
      while(numOpened > 0){
          parend.append(")");
          numOpened--;
      }
      
      return parend.toString();
  }
} 