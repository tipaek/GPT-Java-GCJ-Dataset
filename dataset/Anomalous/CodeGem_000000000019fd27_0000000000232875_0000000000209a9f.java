import java.util.Scanner;

public class Solution {

    public static void appendBraces(StringBuilder sb, int numBraces, int digit) {
        if (numBraces == 0) {
            sb.append(digit);
        } else if (numBraces < 0) {
            for (int i = 0; i < -numBraces; i++) {
                sb.append("(");
            }
            sb.append(digit);
        } else {
            for (int i = 0; i < numBraces; i++) {
                sb.append(")");
            }
            sb.append(digit);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (caseNumber <= t) {
            StringBuilder result = new StringBuilder();
            String input = sc.next();
            int previousDigit = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                int numBraces = previousDigit - currentDigit;
                appendBraces(result, numBraces, currentDigit);
                previousDigit = currentDigit;
            }

            // Close any remaining open braces
            appendBraces(result, previousDigit, 0);
            result.deleteCharAt(result.length() - 1); // Remove the last appended 0

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
    }
}