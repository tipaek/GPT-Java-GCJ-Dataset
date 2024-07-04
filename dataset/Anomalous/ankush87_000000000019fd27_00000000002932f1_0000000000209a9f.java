import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
        StringBuilder[] answers = new StringBuilder[numberOfTestCases];

        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            answers[testCase] = new StringBuilder();
            String digitString = bufferedReader.readLine();
            int previousDigit = digitString.charAt(0) - '0';

            appendBrackets(answers[testCase], previousDigit, '(');
            answers[testCase].append(previousDigit);

            for (int i = 1; i < digitString.length(); i++) {
                int currentDigit = digitString.charAt(i) - '0';
                if (currentDigit > previousDigit) {
                    appendBrackets(answers[testCase], currentDigit - previousDigit, '(');
                } else if (currentDigit < previousDigit) {
                    appendBrackets(answers[testCase], previousDigit - currentDigit, ')');
                }
                answers[testCase].append(currentDigit);
                previousDigit = currentDigit;
            }

            appendBrackets(answers[testCase], previousDigit, ')');
        }

        for (int i = 0; i < numberOfTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }

    private static void appendBrackets(StringBuilder sb, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
    }
}