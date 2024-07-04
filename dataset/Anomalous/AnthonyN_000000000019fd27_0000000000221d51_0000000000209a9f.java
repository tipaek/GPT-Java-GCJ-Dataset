import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println("Case #" + (i + 1) + ": " + addParentheses(scanner.nextLine()));
        }
    }

    private static int countUnmatchedParentheses(StringBuilder sb, int index) {
        int balance = 0;
        for (int i = 0; i < index; i++) {
            char ch = sb.charAt(i);
            if (ch == '(') balance++;
            else if (ch == ')') balance--;
        }
        return balance;
    }

    private static String generateParentheses(int count, char parenthesis) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(parenthesis);
        }
        return sb.toString();
    }

    private static int findLeftIndex(StringBuilder sb, int digit, int currentIndex) {
        for (int i = currentIndex - 1; i >= 0; i--) {
            int num = sb.charAt(i) - '0';
            if (num >= 0 && num < digit) {
                return i + 1;
            }
        }
        return 0;
    }

    private static int findRightIndex(StringBuilder sb, int digit, int currentIndex) {
        for (int i = currentIndex + 1; i < sb.length(); i++) {
            int num = sb.charAt(i) - '0';
            if (num >= 0 && num < digit) {
                return i;
            }
        }
        return sb.length();
    }

    private static String addParentheses(String input) {
        StringBuilder sb = new StringBuilder(input);

        for (int digit = 1; digit <= 9; digit++) {
            int startIndex = 0;
            int nextIndex;

            while ((nextIndex = sb.indexOf(Integer.toString(digit), startIndex)) != -1) {
                int unmatchedParentheses = digit - countUnmatchedParentheses(sb, nextIndex);

                if (unmatchedParentheses != 0) {
                    int leftIndex = findLeftIndex(sb, digit, nextIndex);
                    sb.insert(leftIndex, generateParentheses(unmatchedParentheses, '('));

                    int rightIndex = findRightIndex(sb, digit, nextIndex + unmatchedParentheses);
                    sb.insert(rightIndex, generateParentheses(unmatchedParentheses, ')'));
                }

                startIndex = nextIndex + unmatchedParentheses + 1;
            }
        }

        return sb.toString();
    }
}