import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String nestingDepth(String input) {
        StringBuilder builder = new StringBuilder();

        int lastDigit = 0;
        int pre = 0;
        int cur = 0;
        for (char c : input.toCharArray()) {
            pre = cur;
            cur = c - '0';

            if (pre > cur) {
                builder.append(add(pre-cur, ')'));
            } else if (pre < cur) {
                builder.append(add(cur-pre, '('));
            }

            builder.append(c);
            lastDigit = cur;
        }

        builder.append(add(lastDigit, ')'));
        return builder.toString();
    }

    private static String add(int num, char bracket) {
        StringBuilder builder = new StringBuilder();
        while (num-- > 0)
            builder.append(bracket);
        return builder.toString();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSize = Integer.valueOf(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testSize; ++i) {
            String input = in.nextLine();
            String output = nestingDepth(input);
            StringBuilder builder = new StringBuilder();
            builder.append("Case #" + i + ": ");
            builder.append(output);
            System.out.println(builder.toString().trim());
        }
    }
}