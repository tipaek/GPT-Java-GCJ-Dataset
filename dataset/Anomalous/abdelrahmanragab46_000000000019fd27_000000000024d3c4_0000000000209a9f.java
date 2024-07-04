import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt(); // Number of test cases

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            String S = input.next();
            char[] s = S.toCharArray();

            // Append opening parentheses for the first digit
            for (int j = 0; j < s[0] - '0'; j++) {
                sb.append('(');
            }
            sb.append(s[0]); // Append the first digit

            // Process the rest of the digits
            for (int j = 0; j < S.length() - 1; j++) {
                int currentDigit = s[j] - '0';
                int nextDigit = s[j + 1] - '0';

                if (nextDigit == currentDigit) {
                    sb.append(s[j + 1]);
                } else if (nextDigit > currentDigit) {
                    for (int k = 0; k < nextDigit - currentDigit; k++) {
                        sb.append('(');
                    }
                    sb.append(s[j + 1]);
                } else {
                    for (int k = 0; k < currentDigit - nextDigit; k++) {
                        sb.append(')');
                    }
                    sb.append(s[j + 1]);
                }
            }

            // Append closing parentheses for the last digit
            for (int j = 0; j < s[s.length - 1] - '0'; j++) {
                sb.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }

        input.close();
    }
}