import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String n = in.next();
      System.out.println("Case #" + i + ": " + calculate(n));
    }
  }
  public static String calculate(String input) {
      char element = ' ';
      char zero = '0';
      String ans = "";
      Stack<String> leftStack = new Stack<String>();
      for (int i = 0; i < input.length(); i++) {
          if (element == ' ') {
              element = input.charAt(i);
              int count = element - zero;
              for (int cp = 0; cp < count; cp++) {
                  ans += "(";
                  leftStack.push("(");
              }
              ans += element;
           } else {
               char curElement = input.charAt(i);
               if (element == curElement) {
                   ans += curElement;
                   continue;
               } else {
                   while (!leftStack.isEmpty()) {
                       ans += ")";
                       leftStack.pop();
                   }
                   element = input.charAt(i);
                   int count = element - zero;
                   for (int cp = 0; cp < count; cp++) {
                       ans += "(";
                       leftStack.push("(");
                   }
                   ans += element;
               }
           }
        }
        while (!leftStack.isEmpty()) {
            ans += ")";
            leftStack.pop();
        }
     return ans;
    }

} 