import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    void run() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDigit = input.charAt(0) - '0';

            appendBrackets(result, currentDigit, '(');
            result.append(input.charAt(0));

            for (int pos = 1; pos < input.length(); pos++) {
                int nextDigit = input.charAt(pos) - '0';

                if (currentDigit > nextDigit) {
                    appendBrackets(result, currentDigit - nextDigit, ')');
                } else if (currentDigit < nextDigit) {
                    appendBrackets(result, nextDigit - currentDigit, '(');
                }

                result.append(input.charAt(pos));
                currentDigit = nextDigit;
            }

            appendBrackets(result, currentDigit, ')');
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private void appendBrackets(StringBuilder sb, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
    }
}