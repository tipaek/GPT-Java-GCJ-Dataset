
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            String str_digits = in.next();
            Stack<Character> dig_stack = new Stack<>();
            char[] digits = str_digits.toCharArray();

            for (char digit : digits) {
                int digit_val = Integer.parseInt(String.valueOf(digit));
                for (int cnt = 0; cnt < digit_val; cnt++) {
                    if (!dig_stack.empty() && dig_stack.lastElement() == ')') {
                        dig_stack.pop();
                    } else {
                        dig_stack.add('(');
                    }
                }

                dig_stack.add(digit);

                for (int cnt = 0; cnt < digit_val; cnt++) {
                    dig_stack.add(')');
                }
            }

            String nested = "";

            while (!dig_stack.empty()){
                nested = dig_stack.pop() + nested;
            }

            System.out.println("Case #" + i + ": " + nested);
        }
    }
}