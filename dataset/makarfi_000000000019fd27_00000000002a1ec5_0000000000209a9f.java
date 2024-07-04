
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            char[] digits = in.next().toCharArray();

            int brackets = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                int digit = Integer.parseInt(String.valueOf(digits[i]));

                while (brackets < digit) {
                    builder.append("(");
                    brackets += 1;
                }

                while (brackets > digit) {
                    builder.append(")");
                    brackets -= 1;
                }

                builder.append(digit);
            }

            while (brackets > 0) {
                builder.append(")");
                brackets -= 1;
            }

            System.out.printf("Case #%d: %s\n", testCase, builder);
        }
    }
}
