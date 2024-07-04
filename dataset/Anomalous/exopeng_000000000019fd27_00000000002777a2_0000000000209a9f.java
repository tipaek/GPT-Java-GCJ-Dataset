import java.io.*;
import java.util.*;

public class Solution {
    public static int[] lTally;
    public static int[] rTally;
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        int cases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < cases; i++) {
            String input = reader.readLine();
            rTally = new int[input.length()];
            lTally = new int[input.length()];
            nums = new int[input.length()];

            for (int j = 0; j < input.length(); j++) {
                nums[j] = Character.getNumericValue(input.charAt(j));
            }

            int elementIndex = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(' || input.charAt(j) == ')') {
                    continue;
                }

                input = extendLeft(input, nums[j], j, elementIndex);
                while (j < input.length() && (input.charAt(j) == ')' || input.charAt(j) == '(')) {
                    j++;
                }

                if (j < input.length()) {
                    input = extendRight(input, nums[j], j, elementIndex);
                    elementIndex++;
                    lTally = Arrays.copyOf(rTally, rTally.length);
                }
            }

            writer.println("Case #" + (i + 1) + ": " + input);
        }
        writer.close();
    }

    public static String extendRight(String str, int currElement, int strIndex, int elementIndex) {
        if (rTally[elementIndex] == currElement) {
            return str;
        }

        int parens = currElement - rTally[elementIndex];
        for (int i = strIndex; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                continue;
            }

            rTally[elementIndex] += parens;
            if (elementIndex == rTally.length - 1) {
                return addParentheses(str, parens, i, true);
            }

            elementIndex++;
            int needed = nums[elementIndex] - rTally[elementIndex];
            if (needed < parens) {
                str = addParentheses(str, parens - needed, i, true);
                parens = needed;
            }
        }
        return str;
    }

    public static String extendLeft(String str, int currElement, int strIndex, int elementIndex) {
        if (lTally[elementIndex] == currElement) {
            return str;
        }

        int parens = currElement - lTally[elementIndex];
        for (int i = strIndex; i >= 0; i--) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                continue;
            }

            lTally[elementIndex] += parens;
            if (elementIndex == 0) {
                return addParentheses(str, parens, i - 1, false);
            }

            elementIndex--;
            int needed = nums[elementIndex] - lTally[elementIndex];
            if (needed < parens) {
                str = addParentheses(str, parens - needed, i - 1, false);
                parens = needed;
            }
        }
        return str;
    }

    public static String addParentheses(String str, int num, int index, boolean isEnd) {
        StringBuilder parens = new StringBuilder();
        for (int i = 0; i < num; i++) {
            parens.append(isEnd ? ")" : "(");
        }

        if (isEnd) {
            return str.substring(0, index + 1) + parens + str.substring(index + 1);
        } else {
            return str.substring(0, index + 1) + parens + str.substring(index + 1);
        }
    }
}