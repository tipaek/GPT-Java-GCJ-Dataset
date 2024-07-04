import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTestCases = input.nextInt();
        input.nextLine();

        for (int testCase = 0; testCase < numOfTestCases; testCase++) {
            String inputString = input.nextLine();
            StringBuilder result = new StringBuilder("Case #" + testCase + ": ");
            
            int previousVal = Character.getNumericValue(inputString.charAt(0));
            appendBraces(result, previousVal, previousVal, true);

            for (int i = 1; i < inputString.length(); i++) {
                int currentVal = Character.getNumericValue(inputString.charAt(i));
                if (currentVal > previousVal) {
                    appendBraces(result, currentVal, currentVal - previousVal, true);
                } else if (currentVal < previousVal) {
                    appendBraces(result, currentVal, previousVal - currentVal, false);
                } else {
                    result.append(currentVal);
                }
                previousVal = currentVal;
            }

            for (int i = 0; i < previousVal; i++) {
                result.append(")");
            }

            System.out.println(result);
        }

        input.close();
    }

    private static void appendBraces(StringBuilder result, int charValue, int braceCount, boolean isOpeningBrace) {
        if (isOpeningBrace) {
            for (int i = 0; i < braceCount; i++) {
                result.append("(");
            }
            result.append(charValue);
        } else {
            result.append(charValue);
            for (int i = 0; i < braceCount; i++) {
                result.append(")");
            }
        }
    }
}