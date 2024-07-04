import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int t = Integer.parseInt(line);
        for (int i = 1; i <= t; ++i) {
            String input = in.nextLine();
            NestingDepth solution = new NestingDepth(input);
            System.out.println("Case #" + i + ": " + solution.toNestingDepthString());
        }
    }
    private static class NestingDepth {

        private static final char OPEN = '(';
        private static final char CLOSE = ')';

        private char[] array;
        private Stack<Character> stack;

        NestingDepth(String input) {
            array = input.toCharArray();
            stack = new Stack<>();
        }

        String toNestingDepthString() {
            if (array.length == 0) {
                return "";
            }

            StringBuilder stringBuilder = new StringBuilder();
            int num = array[0] - '0';
            for (int i = 0; i < num; i++) {
                stack.push(CLOSE);
                stringBuilder.append(OPEN);
            }
            stringBuilder.append(num);
            for (int i = 1; i < array.length; i++) {
                int next = array[i] - '0';
                if (num > next) {
                    while(stack.size() > next) {
                        stringBuilder.append(stack.pop());
                    }
                } else if (num < next) {
                    while(stack.size() < next) {
                        stack.push(CLOSE);
                        stringBuilder.append(OPEN);
                    }
                }
                stringBuilder.append(next);
                num = next;
            }
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }
            return stringBuilder.toString();
        }
    }
}