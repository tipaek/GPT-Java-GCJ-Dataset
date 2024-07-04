import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            int number = Integer.parseInt(input);
            List<String> result = new ArrayList<>();
            char[] characters = input.toCharArray();
            int length = characters.length;
            int depth = 0;

            for (int i = 0; i < length; i++) {
                int currentDigit = characters[i] - '0';

                if (i == 0) {
                    depth = currentDigit;
                    appendParentheses(result, currentDigit, true);
                    result.add(String.valueOf(characters[i]));
                    appendParentheses(result, currentDigit, false);
                } else {
                    int previousDigit = characters[i - 1] - '0';

                    if (currentDigit > previousDigit) {
                        int diff = currentDigit - previousDigit;
                        appendParentheses(result, diff, true);
                        result.add(String.valueOf(characters[i]));
                        appendParentheses(result, diff, false);
                    } else if (currentDigit < previousDigit) {
                        int diff = previousDigit - currentDigit;
                        depth += diff;
                        result.add(String.valueOf(characters[i]));
                    } else {
                        result.add(String.valueOf(characters[i]));
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (String str : result) {
                output.append(str);
            }

            System.out.println("Case #" + caseNumber + ": " + output.toString());
            caseNumber++;
        }
        scanner.close();
    }

    private static void appendParentheses(List<String> result, int count, boolean open) {
        for (int i = 0; i < count; i++) {
            result.add(open ? "(" : ")");
        }
    }
}