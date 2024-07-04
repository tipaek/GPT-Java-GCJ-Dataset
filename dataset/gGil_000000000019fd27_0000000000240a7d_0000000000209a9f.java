import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String n = in.next();
      System.out.println("Case #" + i + ": " + solve(n));
    }
  }
  
  public static String solve(String full){
      Stack<String> stack = new Stack<String>();
      String memo;
      String solution = "";
      for(int i = 0; i < full.length(); i++){
          memo = full.substring(i, i + 1);
          if(Integer.parseInt(memo) == stack.size()){
              solution += memo;
              continue;
          } 
          if(Integer.parseInt(memo) > stack.size()){
              for(int j = 0; j < Integer.parseInt(memo) - stack.size(); j++){
                  stack.push(")");
                  solution += "(";
              }
              solution += memo;
              continue;
          }
          if(Integer.parseInt(memo) < stack.size()){
              for(int j = 0; j < stack.size() - Integer.parseInt(memo); j++){
                  solution += stack.pop();
              }
              solution += memo;
              continue;
          }
      }
      for(int j = 0; j < stack.size(); j++){
                 solution += stack.pop();
        }
      return solution;
  } 
}