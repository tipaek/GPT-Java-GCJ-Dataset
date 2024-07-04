import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        // test cases
        final int T = input.nextInt();
        for (int x = 0; x < T; ++x) {
            // string
            final String S = input.next();
            StringBuilder y = new StringBuilder();
            int braces = 0;
            for (int n = 0; n < S.length(); ++n) {
                int d = S.charAt(n) - '0';
                if (d < braces) {
                    for (int a = braces - d; a > 0; --a) {
                        y.append(")");
                    }
                } else if (d > braces) {
                    for (int a = d - braces; a > 0; --a) {
                        y.append("(");
                    }
                }
                y.append(d);
                braces = d;
            }
            for (int a = braces; a > 0; --a) {
                y.append(")");
            }
            // Case #x: k r c
            System.out.format("Case #%d: %s%n", x + 1, y.toString());
        }
    }
}
