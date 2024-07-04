import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Method to wrap a number in a specified number of parenthesis
    static StringBuilder wrapInParenthesis(int n, int howMany) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < howMany; i++) {
            sb.append('(');
        }
        sb.append(n);
        for (int i = 0; i < howMany; i++) {
            sb.append(')');
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String input = reader.readLine();
            char[] digits = input.toCharArray();
            StringBuilder result = new StringBuilder();

            int currentDigit = digits[0] - '0';
            result.append(wrapInParenthesis(currentDigit, currentDigit));
            int resultIndex = currentDigit;

            for (int i = 1; i < digits.length; i++) {
                currentDigit = digits[i] - '0';
                int lastDigit = result.charAt(resultIndex) - '0';

                if (currentDigit == lastDigit) {
                    resultIndex++;
                    result.insert(resultIndex, currentDigit);
                } else if (currentDigit > lastDigit) {
                    resultIndex++;
                    result.insert(resultIndex, wrapInParenthesis(currentDigit, currentDigit - lastDigit));
                    resultIndex += currentDigit - lastDigit;
                } else {
                    resultIndex = result.length() - currentDigit;
                    result.insert(resultIndex, currentDigit);
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}