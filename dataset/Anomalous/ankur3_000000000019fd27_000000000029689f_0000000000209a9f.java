import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int totalCases = testCases;

        for (int i = 1; i <= totalCases; i++) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + generateBalancedParentheses(input));
        }
    }

    public static String generateBalancedParentheses(String input) {
        String[] segments = input.split("0", -1);
        StringBuilder result = new StringBuilder();
        int segmentIndex = 0;

        for (String segment : segments) {
            result.append(processSegment(segment));
            if (shouldConcatZero(segmentIndex, segments.length)) {
                result.append("0");
            }
            segmentIndex++;
        }
        return result.toString();
    }

    private static String processSegment(String segment) {
        if (segment.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        int minDigit = Integer.MAX_VALUE;

        for (char ch : segment.toCharArray()) {
            int digit = ch - '0';
            if (digit < minDigit) {
                minDigit = digit;
            }
        }

        for (char ch : segment.toCharArray()) {
            int digit = ch - '0';
            StringBuilder temp = new StringBuilder(String.valueOf(ch));
            for (int j = 0; j < (digit - minDigit); j++) {
                temp.insert(0, '(').append(')');
            }
            result.append(temp);
        }

        for (int i = 0; i < minDigit; i++) {
            result.insert(0, '(').append(')');
        }

        return result.toString();
    }

    private static boolean shouldConcatZero(int index, int totalSegments) {
        return index < totalSegments - 1;
    }
}