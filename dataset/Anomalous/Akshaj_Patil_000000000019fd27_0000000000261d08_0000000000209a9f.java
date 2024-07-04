import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        int caseNo = 1;

        while (testCases-- > 0) {
            String input = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char c : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(c);

                // Add opening brackets if current digit is greater than previous
                for (int i = 0; i < currentDigit - previousDigit; i++) {
                    result.append('(');
                }

                // Add closing brackets if current digit is less than previous
                for (int i = 0; i < previousDigit - currentDigit; i++) {
                    result.append(')');
                }

                // Append the current digit
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            // Close any remaining open brackets
            for (int i = 0; i < previousDigit; i++) {
                result.append(')');
            }

            System.out.println("Case #" + caseNo + ": " + result.toString());
            caseNo++;
        }
    }
}