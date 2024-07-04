import java.io.BufferedInputStream;
import java.util.Scanner;

class Solution {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        int testCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCount; i++) {
            String line = scanner.nextLine();
            System.out.printf("Case #%d: %s\n", (i + 1), solve(line));
        }
    }

    private static String solve(String digits) {
        StringBuilder builder = new StringBuilder();

        int currentBalance = 0;

        for (int i = 0; i < digits.length(); i++) {
            int d = digits.charAt(i) - '0';

            int delta = d - currentBalance;

            if (delta > 0) {
                int x = delta;

                while (x > 0) {
                    builder.append('(');
                    x--;
                }
            } else if (delta < 0) {
                int x = Math.abs(delta);

                while (x > 0) {
                    builder.append(')');
                    x--;
                }
            }

            builder.append(d);
            currentBalance += delta;
        }

        if (currentBalance > 0) {
            int x = currentBalance;

            while (x > 0) {
                builder.append(')');
                x--;
            }
        }

        return builder.toString();
    }
}