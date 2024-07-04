import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                resultBuilder.append("(".repeat(digit))
                             .append(digit)
                             .append(")".repeat(digit));
            }

            int leftIndex = 0;
            while (leftIndex < resultBuilder.length() - 1) {
                if (resultBuilder.charAt(leftIndex) == ')' && resultBuilder.charAt(leftIndex + 1) == '(') {
                    resultBuilder.setCharAt(leftIndex, '*');
                    resultBuilder.setCharAt(leftIndex + 1, '*');
                    leftIndex = Math.max(0, leftIndex - 1);
                } else {
                    leftIndex++;
                }
            }

            StringBuilder finalResult = new StringBuilder();
            for (int i = 0; i < resultBuilder.length(); i++) {
                if (resultBuilder.charAt(i) != '*') {
                    finalResult.append(resultBuilder.charAt(i));
                }
            }

            System.out.println("Case #" + caseNum + ": " + finalResult);
        }
    }
}