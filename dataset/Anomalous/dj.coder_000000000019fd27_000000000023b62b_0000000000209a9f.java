import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static String solve(String S) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (char ch : S.toCharArray()) {
            int currentDigit = ch - '0';
            int difference = currentDigit - previousDigit;

            if (difference > 0) {
                result.append("(".repeat(difference));
            } else if (difference < 0) {
                result.append(")".repeat(-difference));
            }

            result.append(ch);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(previousDigit));
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= testCases; i++) {
            String S = reader.readLine();
            output.append("Case #").append(i).append(": ").append(solve(S)).append(System.lineSeparator());
        }

        System.out.print(output);
        reader.close();
    }
}