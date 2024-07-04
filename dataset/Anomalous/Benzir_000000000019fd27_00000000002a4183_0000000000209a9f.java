import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            String input = reader.readLine();
            int length = input.length();
            int bracketBalance = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int currentDigit = input.charAt(i) - '0';

                if (currentDigit == bracketBalance) {
                    result.append(input.charAt(i));
                } else if (currentDigit > bracketBalance) {
                    int openBraces = currentDigit - bracketBalance;
                    result.append(repeatChar('(', openBraces)).append(input.charAt(i));
                    bracketBalance += openBraces;
                } else {
                    int closeBraces = bracketBalance - currentDigit;
                    result.append(repeatChar(')', closeBraces)).append(input.charAt(i));
                    bracketBalance -= closeBraces;
                }
            }

            if (bracketBalance > 0) {
                result.append(repeatChar(')', bracketBalance));
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }

        System.exit(0);
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}