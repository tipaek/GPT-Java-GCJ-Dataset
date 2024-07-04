import java.util.Scanner;

public class Solution {

    static String generateOpenBrackets(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append('(');
        }
        return result.toString();
    }

    static String generateCloseBrackets(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(')');
        }
        return result.toString();
    }

    static String processString(String str) {
        int currentDepth = 0;
        int lastDigit = str.charAt(str.length() - 1) - '0';
        StringBuilder result = new StringBuilder();
        result.append(str.charAt(str.length() - 1));
        result.append(generateCloseBrackets(lastDigit));
        currentDepth = lastDigit;

        for (int i = str.length() - 2; i >= 0; i--) {
            int currentDigit = str.charAt(i) - '0';
            if (currentDepth != currentDigit) {
                if (currentDepth > currentDigit) {
                    result.insert(0, generateOpenBrackets(currentDepth - currentDigit));
                    currentDepth = currentDigit;
                } else {
                    result.insert(0, generateCloseBrackets(currentDigit - currentDepth));
                    currentDepth = currentDigit;
                }
            }
            result.insert(0, str.charAt(i));
        }
        result.insert(0, generateOpenBrackets(currentDepth));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String output = "Case #" + caseNumber + ": " + processString(input);
            System.out.println(output);
        }
        scanner.close();
    }
}