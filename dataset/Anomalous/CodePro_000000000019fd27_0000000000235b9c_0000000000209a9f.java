import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            Stack<Integer> stack = new Stack<>();
            StringBuilder output = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));

                if (digit > 0) {
                    if (stack.isEmpty()) {
                        stack.push(digit);
                        output.append("(".repeat(digit)).append(digit);
                    } else {
                        int top = stack.peek();
                        if (top > digit) {
                            stack.pop();
                            stack.push(digit);
                            output.append(")".repeat(top - digit)).append(digit);
                        } else if (digit > top) {
                            output.append("(".repeat(digit - top)).append(digit).append(")".repeat(digit - top));
                        } else {
                            output.append(digit);
                        }
                    }
                } else {
                    if (!stack.isEmpty()) {
                        while (!stack.isEmpty()) {
                            int top = stack.pop();
                            output.append(")".repeat(top));
                        }
                    }
                    output.append(digit);
                }
            }

            while (!stack.isEmpty()) {
                int top = stack.pop();
                output.append(")".repeat(top));
            }

            results[i] = "Case #" + (i + 1) + ": " + output.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}