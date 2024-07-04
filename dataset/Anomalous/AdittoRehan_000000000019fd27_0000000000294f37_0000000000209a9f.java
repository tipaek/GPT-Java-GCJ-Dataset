import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static ArrayList<Character> chars = new ArrayList<>();

    private static void appendParentheses(int count, char parenthesis) {
        for (int i = 0; i < count; i++) {
            chars.add(parenthesis);
        }
    }

    private static void appendOpeningParentheses(int count) {
        appendParentheses(count, '(');
    }

    private static void appendClosingParentheses(int count) {
        appendParentheses(count, ')');
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCaseCount = input.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            String s = input.next();
            int length = s.length();
            boolean firstSegment = true;

            for (int j = 0; j < length; j++) {
                char currentChar = s.charAt(j);
                int currentDigit = Character.getNumericValue(currentChar);
                chars.add(currentChar);

                if (firstSegment) {
                    appendOpeningParentheses(currentDigit);
                    firstSegment = false;
                }

                if (j < length - 1) {
                    int nextDigit = Character.getNumericValue(s.charAt(j + 1));
                    if (nextDigit > currentDigit) {
                        appendOpeningParentheses(nextDigit - currentDigit);
                    } else if (nextDigit < currentDigit) {
                        appendClosingParentheses(currentDigit - nextDigit);
                    }
                } else {
                    appendClosingParentheses(currentDigit);
                }
            }

            System.out.print("Case #" + i + ": ");
            for (Character c : chars) {
                System.out.print(c);
            }
            System.out.println();
            chars.clear();
        }

        input.close();
    }
}