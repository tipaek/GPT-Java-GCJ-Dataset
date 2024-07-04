import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            char[] digits = in.next().toCharArray();
            StringBuilder nesting = new StringBuilder();
            for (int i = 0; i < digits.length; ++i) {
                int digit = digits[i] - '0';
                int next = i < digits.length - 1 ? digits[i + 1] - '0' : 0;
                if (i == 0) {
                    for (int j = 0; j < digit; ++j) {
                        nesting.append('(');
                    }
                }
                nesting.append(digit);
                for (int j = 0; j < Math.abs(digit - next); ++j) {
                    nesting.append(digit > next ? ')' : '(');
                }
            }
            System.out.println("Case #" + t + ": " + nesting.toString());
        }

        in.close();
    }
}
