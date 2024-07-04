import java.util.*;

public class Solution {

    public static String solve(String s) {
        int open = 0; //no of open brackets
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int  current = s.charAt(i) - '0';
            int diff = current - open;
            open += diff;
            if (diff >= 0) {//insert open parenthesis
                for (int j = 0; j < diff; j++) {
                    result += "(";
                }
            }
            else { // insert close paranthesis
                diff = Math.abs(diff);
                for (int j = 0; j < diff; j++) {
                    result += ")";
                }
            }
            result += s.charAt(i);
        }
        for (int i = 0; i < open; i++) {
            result += ")";
        }
        return result;
    }  
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      int T = input.nextInt();
      for (int ks = 1; ks <= T; ks++) {
        String s = input.next();
        System.out.println("Case #" + ks + ": " + solve(s));
      }
    }
  }
  