import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        String S = in.next();
    
        Integer prevChar = null;
        Integer currentChar;
    
        Stack<Character> stack = new Stack<>();
        StringBuilder SS = new StringBuilder();
    
        for(int j = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            currentChar = Integer.parseInt(String.valueOf(c));
    
            if(prevChar != null && currentChar <= prevChar) {
                int diff = prevChar - currentChar;
                while (diff != 0) {
                    diff--;
                    stack.pop();
                    SS.append(")");
                }
    
                SS.append(c);
            }
            else if(prevChar== null || currentChar > prevChar) {
                int diff = 0;
                if(prevChar == null) {
                    diff = currentChar;
                } else {
                    diff = currentChar - prevChar;
                }
    
                while (diff != 0) {
                    diff--;
                    stack.push(c);
                    SS.append("(");
                }
    
                SS.append(c);
            }
            prevChar = currentChar;
        }
    
        //add remaining )
        while (stack.size() != 0) {
            stack.pop();
            SS.append(")");
        }
    
        System.out.println("Case #" + i + ": " +  SS);
    }
  }
}