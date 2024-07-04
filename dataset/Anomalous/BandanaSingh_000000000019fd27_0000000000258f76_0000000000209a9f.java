import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= numOfTests; testCase++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(testCase).append(": ");

            int previousVal = Character.getNumericValue(inputString.charAt(0));
            appendBraces(result, previousVal, true);

            for (int i = 1; i < inputString.length(); i++) {
                int currentVal = Character.getNumericValue(inputString.charAt(i));
                if (currentVal > previousVal) {
                    appendBraces(result, currentVal - previousVal, true);
                } else if (currentVal < previousVal) {
                    appendBraces(result, previousVal - currentVal, false);
                }
                result.append(currentVal);
                previousVal = currentVal;
            }

            appendBraces(result, previousVal, false);
            System.out.println(result.toString());
        }

        scanner.close();
    }

    private static void appendBraces(StringBuilder result, int braceCount, boolean isOpening) {
        char brace = isOpening ? '(' : ')';
        for (int i = 0; i < braceCount; i++) {
            result.append(brace);
        }
    }
}