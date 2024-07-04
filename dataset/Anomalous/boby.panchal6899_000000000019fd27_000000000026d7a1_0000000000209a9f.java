import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String inputString = scanner.next();
            StringBuilder resultString = new StringBuilder();

            int currentDepth = 0;
            for (char digitChar : inputString.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);

                while (currentDepth < digit) {
                    resultString.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    resultString.append(')');
                    currentDepth--;
                }

                resultString.append(digit);
            }

            while (currentDepth > 0) {
                resultString.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseIndex + ": " + resultString);
        }
    }
}