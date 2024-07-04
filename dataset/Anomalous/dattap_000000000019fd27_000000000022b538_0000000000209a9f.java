import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            if (input.length() == 1) {
                int digit = Character.getNumericValue(input.charAt(0));
                result.append("(".repeat(digit))
                      .append(digit)
                      .append(")".repeat(digit));
                System.out.println("Case #" + caseNum + ": " + result);
                continue;
            }

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int nextDigit = i < input.length() - 1 ? Character.getNumericValue(input.charAt(i + 1)) : 0;

                if (i == 0) {
                    result.append("(".repeat(currentDigit)).append(currentDigit);
                    openBrackets = currentDigit;
                } else {
                    if (nextDigit > currentDigit) {
                        result.append("(".repeat(nextDigit - currentDigit)).append(nextDigit);
                        openBrackets += nextDigit - currentDigit;
                    } else if (nextDigit < currentDigit) {
                        result.append(")".repeat(currentDigit - nextDigit)).append(nextDigit);
                        openBrackets -= currentDigit - nextDigit;
                    } else {
                        result.append(nextDigit);
                    }
                }
            }

            result.append(")".repeat(openBrackets));
            System.out.println("Case #" + caseNum + ": " + result);
        }

        scanner.close();
    }
}