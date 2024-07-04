import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            output.append("Case #").append(caseNumber).append(": ");
            String inputString = reader.readLine().trim();
            output.append(generateBalancedString(inputString)).append("\n");
        }

        System.out.print(output);
    }

    private static String generateBalancedString(String input) {
        int length = input.length();
        int[] bracketCounts = new int[length + 2];

        for (int i = 1; i <= length; i++) {
            bracketCounts[i] = Character.getNumericValue(input.charAt(i - 1));
        }

        StringBuilder balancedString = new StringBuilder();

        for (int i = 0; i <= length; i++) {
            int difference = bracketCounts[i + 1] - bracketCounts[i];

            if (difference > 0) {
                balancedString.append("(".repeat(difference));
            } else if (difference < 0) {
                balancedString.append(")".repeat(-difference));
            }

            if (i < length) {
                balancedString.append(bracketCounts[i + 1]);
            }
        }

        return balancedString.toString();
    }
}