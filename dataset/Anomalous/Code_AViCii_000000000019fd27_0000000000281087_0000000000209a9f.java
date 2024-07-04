import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int t = p;

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            StringBuilder sb = new StringBuilder();
            int firstDigit = Character.getNumericValue(s.charAt(0));

            // Append opening brackets for the first digit
            for (int j = 0; j < firstDigit; j++) {
                sb.append('(');
            }
            sb.append(s.charAt(0));

            // Process the rest of the digits
            for (int i = 1; i < n; i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));
                int previousDigit = Character.getNumericValue(s.charAt(i - 1));

                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        sb.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        sb.append(')');
                    }
                }
                sb.append(s.charAt(i));
            }

            // Append closing brackets for the last digit
            for (int j = 0; j < Character.getNumericValue(s.charAt(n - 1)); j++) {
                sb.append(')');
            }

            System.out.println("Case #" + (p - t) + ": " + sb);
        }
    }
}