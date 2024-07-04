import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            int num = Integer.parseInt(input);
            char[] digits = input.toCharArray();
            int length = digits.length;
            int currentIndex = 0;
            ArrayList<String> result = new ArrayList<>(4);

            for (int i = 0; i < length; i++) {
                int currentDigit = digits[i] - '0';

                if (i == 0) {
                    if (currentDigit == 0) {
                        currentIndex++;
                    } else {
                        currentIndex = currentDigit + 1;
                    }
                    addParentheses(result, currentDigit, currentDigit);
                    result.add(Character.toString(digits[i]));
                    addParentheses(result, currentDigit, 0);
                } else {
                    int previousDigit = digits[i - 1] - '0';
                    if (currentDigit >= previousDigit) {
                        int difference = currentDigit - previousDigit;
                        addParentheses(result, difference, difference);
                        result.add(Character.toString(digits[i]));
                        addParentheses(result, difference, 0);
                    } else {
                        int difference = previousDigit - currentDigit;
                        currentIndex += difference;
                        result.add(Character.toString(digits[i]));
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (String s : result) {
                output.append(s);
            }

            System.out.println("Case #" + caseNumber + ": " + output.toString());
            caseNumber++;
        }

        scanner.close();
    }

    private static void addParentheses(ArrayList<String> result, int count, int openCloseFlag) {
        for (int i = 0; i < count; i++) {
            if (openCloseFlag > 0) {
                result.add("(");
            } else {
                result.add(")");
            }
        }
    }
}