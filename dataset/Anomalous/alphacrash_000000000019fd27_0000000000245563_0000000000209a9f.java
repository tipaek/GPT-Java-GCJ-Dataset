import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
                String input = sc.next();
                String processedString = processString(input);
                String balancedString = balanceString(processedString);
                System.out.println("Case #" + caseNumber + ": " + balancedString);
            }
        }
    }

    public static String processString(String input) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < input.length()) {
            int currentDigit = Character.getNumericValue(input.charAt(index));
            result.append("(".repeat(currentDigit)).append(currentDigit);
            index++;
            while (index < input.length() && Character.getNumericValue(input.charAt(index)) == currentDigit) {
                result.append(currentDigit);
                index++;
            }
            result.append(")".repeat(currentDigit));
        }

        return result.toString();
    }

    public static String balanceString(String input) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < input.length()) {
            char currentChar = input.charAt(index);
            if (index == input.length() - 1 || !(currentChar == ')' && input.charAt(index + 1) == '(')) {
                result.append(currentChar);
            } else {
                index++;
            }
            index++;
        }

        if (containsUnbalancedPairs(result.toString()) == 0) {
            return result.toString();
        } else {
            return balanceString(result.toString());
        }
    }

    public static int containsUnbalancedPairs(String input) {
        int count = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == ')' && input.charAt(i + 1) == '(') {
                count++;
            }
        }
        return count;
    }
}