import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * Solution
 *
 * @author dongyoung
 * @since 2020-04-04
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            String digits = in.next();

            System.out.println("Case #" + i + ": " + solution(digits));
        }
    }

    public static String solution(String digits) {
        Stack<Character> stack = new Stack();
        stack.add(' ');
        for (char ch : digits.toCharArray()) {
            int num = ch - '0';
            int removedCnt = 0;
            while (removedCnt < num) {
                if (stack.peek() == ')') {
                    stack.pop();
                    removedCnt++;
                } else {
                    break;
                }
            }
            for (int i = 0; i < num - removedCnt; i++) {
                stack.add('(');
            }
            stack.add(ch);
            for (int i = 0; i < num; i++) {
                stack.add(')');
            }
        }
        Character[] reversed = new Character[stack.size()];
        stack.toArray(reversed);

        StringBuilder res = new StringBuilder();
        for (int i = reversed.length - 1; i >= 0; i--) {
            if (reversed[i] == '(') {
                res.append(')');
            } else if (reversed[i] == ')') {
                res.append('(');
            } else {
                res.append(reversed[i]);
            }
        }
        return res.toString();
    }

}
