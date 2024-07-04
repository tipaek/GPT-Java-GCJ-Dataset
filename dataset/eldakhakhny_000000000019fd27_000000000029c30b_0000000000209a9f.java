import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <s.length() ; j++) {
                char c = s.charAt(j);
                int digit = Integer.parseInt(""+c);
                String prefixOpening = prefixOpening(digit);
                String postfixClosing = postfixClosing(digit);
                sb.append(prefixOpening);
                sb.append(c);
                sb.append(postfixClosing);
            }
            String padded = sb.toString();
            String minimised = minimizeParanthasis(padded);
            System.out.println("Case #" + i + ": " + minimised);
        }
    }
    static String prefixOpening(int d){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < d; i++) {
            sb.append('(');
        }
        return sb.toString();
    }

    static String postfixClosing(int d){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < d; i++) {
            sb.append(')');
        }
        return sb.toString();
    }

    static String minimizeParanthasis(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char c =  s.charAt(i);
            if (stack.empty()){
                stack.push(c);
                continue;
            }
            if (stack.peek() ==')' && c == '(' ){
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(c -> {
            sb.append(c);
        });

        String result =sb.toString();
        return result;
    }
}