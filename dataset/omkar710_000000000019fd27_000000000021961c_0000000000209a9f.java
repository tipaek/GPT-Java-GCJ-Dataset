import java.util.*;
import java.io.*;


public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {
     char[] chars = in.next().toCharArray();

      Stack<Character> stack = new Stack<>();

      StringBuffer sb = new StringBuffer();

      for(char c : chars) {

        int n = Integer.parseInt(String.valueOf(c));

        for(int j = 0; j < n; j++) {
          sb.append('(');
        }
        sb.append(c);

        for(int j = 0; j < n; j++) {
          sb.append(')');
        }
      }

      for(int j = 0; j < sb.length(); j++) {
        if(sb.charAt(j) == '(') {
          if(!stack.isEmpty() && stack.peek() == ')') {
            stack.pop();
          } else {
            stack.push(sb.charAt(j));
          }
        } else {
          stack.push(sb.charAt(j));
        }
      }

      StringBuilder res = new StringBuilder();

      while(!stack.isEmpty()) {
        res.append(stack.pop());
      }

      System.out.printf("Case #%d: ", i+1);
      System.out.println(res.reverse());

    }
  }
}