import java.util.Scanner;

public class Solution {

    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int testNr = 1; testNr <= t; testNr++) {
            String s = scanner.nextLine().trim();
            char[] sArr = s.toCharArray();
            StringBuilder sb = new StringBuilder();

            int lastDigit = 0;
            int digit;
            int diff;

            for (char c : sArr) {
                digit = c - '0';
                diff = digit - lastDigit;

                if (diff > 0) {
                    for (int i = 0; i < diff; i++) {
                        sb.append(LEFT_PARENTHESIS);
                    }
                } else {
                    for (int i = 0; i > diff; i--) {
                        sb.append(RIGHT_PARENTHESIS);
                    }
                }

                sb.append(digit);
                lastDigit = digit;
            }

            // Close all unclosed parenthesis
            for (int i = 0; i < lastDigit; i++) {
                sb.append(RIGHT_PARENTHESIS);
            }

            System.out.println("Case #" + testNr + ": " + sb.toString());
        }
    }
}
