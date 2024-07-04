import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static void addParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (char c : s.toCharArray()) {
            int currentDigit = c - '0';

            if (currentDigit > previousDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
            } else if (currentDigit < previousDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
            }

            result.append(c);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(previousDigit));
        System.out.print(result.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        String[] inputs = new String[t];

        for (int i = 0; i < t; i++) {
            inputs[i] = reader.readLine().trim();
        }

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            addParentheses(inputs[i]);
            System.out.println();
        }
    }
}