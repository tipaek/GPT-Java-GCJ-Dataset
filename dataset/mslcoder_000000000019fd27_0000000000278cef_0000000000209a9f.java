
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 1;
        while (n-- > 0) {
            String a = sc.next();
            String s = "";
            Stack<Character> stack = new Stack<>();

            int length = a.length();
            int i = 1;
            for (int j = 1; j <= Character.getNumericValue(a.charAt(0)); j++) {
                s = s + "(";
                stack.push('(');
            }
            s = s + a.charAt(0);
            while (i < length) {

                if (a.charAt(i) - a.charAt(i - 1) > 0) {
                    s = s + "(";
                    stack.push('(');
                } else if (a.charAt(i) - a.charAt(i - 1) < 0) {
                    s = s + ")";
                    stack.pop();
                }
                s = s + a.charAt(i);
                i++;
            }

            while (!stack.isEmpty()) {
                stack.pop();
                s = s + ")";
            }
           System.out.println("Case #" + m++ + ": " + s );

        }
    }
}
