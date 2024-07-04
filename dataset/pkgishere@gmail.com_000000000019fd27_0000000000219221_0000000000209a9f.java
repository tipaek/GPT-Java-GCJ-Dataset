import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution{
    
    public static String  process(String s){
        StringBuilder sb = new StringBuilder();
      int currentOpenParanthesis = 0;
      for(char c: s.toCharArray()){
          int current = ((int) c) - 48;
          if(current > currentOpenParanthesis){
              while(current> currentOpenParanthesis){
                  sb.append("(");
                  currentOpenParanthesis++;
              }
          }
          if(current < currentOpenParanthesis){
              while(current< currentOpenParanthesis){
                  sb.append(")");
                  currentOpenParanthesis--;
              }
          }
          sb.append(c);
      }
      while(currentOpenParanthesis>0){
          sb.append(")");
          currentOpenParanthesis--;
      }
      
      return sb.toString();
    
    }

    public static void main(String args[]){
      
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= test_cases; ++i) {
      String s = in.next();
      System.out.println("Case #" + i + ": " + process(s));
    }
  }
}