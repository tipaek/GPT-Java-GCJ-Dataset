import java.util.Scanner;

class B {
    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                final char[] S = sc.next().toCharArray();
                final StringBuilder S_ = new StringBuilder();
                int depth = 0;
                for (char c : S) {
                    while (depth < c - '0') {
                        S_.append('(');
                        depth++;
                    }
                    while (depth > c - '0') {
                        S_.append(')');
                        depth--;
                    }
                    S_.append(c);
                }
                while (depth > 0) {
                    S_.append(')');
                    depth--;
                }
                System.out.printf("Case #%s: %s\n", t, S_);
            }
        }
    }
}
public class Solution {
    public static void main(String...args) throws Exception {
        B.main();
    }
}
