import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = br.readLine();
            int length = input.length();
            int currentBraces = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int digit = input.charAt(i) - '0';
                if (digit == currentBraces) {
                    result.append(input.charAt(i));
                } else if (digit > currentBraces) {
                    int openBraces = digit - currentBraces;
                    result.append(generateBraces(openBraces, '(')).append(input.charAt(i));
                    currentBraces += openBraces;
                } else {
                    int closeBraces = currentBraces - digit;
                    result.append(generateBraces(closeBraces, ')')).append(input.charAt(i));
                    currentBraces -= closeBraces;
                }
            }

            if (currentBraces > 0) {
                result.append(generateBraces(currentBraces, ')'));
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }

    private static String generateBraces(int count, char brace) {
        return String.join("", Collections.nCopies(count, String.valueOf(brace)));
    }
}