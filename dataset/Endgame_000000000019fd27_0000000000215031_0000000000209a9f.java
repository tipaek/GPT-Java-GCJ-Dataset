import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + secret());
        }
    }

    private static String secret() {
        String value = in.next();

        String withParentheses = "";


        char[] tavs = value.toCharArray();
        int VALUE_LEN = value.length();
        int[] parentheses = new int[VALUE_LEN]; // { 0, 0 .. 0 }
        Stack<Integer> balances = new Stack<>();

        for (int i = 0; i < VALUE_LEN; i++) {
            char tav = tavs[i];
            int digitVal = tav - '0';

            if (i == 0) {
                balances.add(digitVal);

                for (int k = 0; k < balances.peek(); k++) {
                    withParentheses += '(';
                }
            } else /* i > 0 */ {
                int diff = digitVal - balances.peek();

                if (diff > 0) { // CLOSE NOW!!!!!
                    for (int k = 0; k < diff; k++) {
                        withParentheses += '(';
                    }
                    balances.pop();
                    balances.push(digitVal);
                } else if (diff < 0) {
                    for (int k = 0; k < -diff; k++) {
                        withParentheses += ')';
                    }
                    balances.pop();
                    balances.push(digitVal);
                } else {
                    // Do nothing, as you are the same number as before... Or same balance
                }
            }

            // Pop or peek?

            withParentheses += tav;
        }

        // if balance... close!!!!!

        for (int k = 0; k < balances.peek(); k++) {
            withParentheses += ')';
        }

        return withParentheses;
    }
}
