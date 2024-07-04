import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static StringBuilder wrapInParentheses(int number, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append('(');
        }
        result.append(number);
        for (int i = 0; i < count; i++) {
            result.append(')');
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = reader.readLine();
            char[] characters = input.toCharArray();
            StringBuilder output = new StringBuilder();

            int currentDigit = characters[0] - '0';
            output.append(wrapInParentheses(currentDigit, currentDigit));
            int currentIndex = currentDigit;

            for (int i = 1; i < characters.length; i++) {
                currentDigit = characters[i] - '0';
                int lastDigit = output.charAt(currentIndex) - '0';

                if (currentDigit == lastDigit) {
                    currentIndex++;
                    output.insert(currentIndex, currentDigit);
                } else if (currentDigit > lastDigit) {
                    currentIndex++;
                    output.insert(currentIndex, wrapInParentheses(currentDigit, currentDigit - lastDigit));
                    currentIndex += currentDigit - lastDigit;
                } else {
                    currentIndex = output.length() - currentDigit;
                    output.insert(currentIndex, currentDigit);
                }
            }
            System.out.println("Case #" + caseNumber + ": " + output);
        }
    }
}