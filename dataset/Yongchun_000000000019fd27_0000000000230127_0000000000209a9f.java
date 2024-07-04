import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    static String matchParen(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> paren = new Stack<>();
        for (int i = 0; i < s.length() - 1; i++) {
            int current = Character.getNumericValue(s.charAt(i));
            int next = Character.getNumericValue(s.charAt(i + 1));
            int s1 = paren.size();

            for (int j = 0; j < current - s1; j++) {
                paren.push('(');
                result.append('(');
            }
            result.append(current);
            if (current - next > 0) {
                for (int k = 0; k < current - next; k++) {
                    paren.pop();
                    result.append(')');
                }
            }
        }
        int last = Character.getNumericValue(s.charAt(s.length() - 1));
        int s2 = paren.size();
        for (int i = 0; i < last - s2; i++) {
            paren.push('(');
            result.append('(');
        }
        result.append(last);
        int s3 = paren.size();
        for (int j = 0; j < s3; j++) {
            paren.pop();
            result.append(')');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + matchParen(s));
        }
    }
}