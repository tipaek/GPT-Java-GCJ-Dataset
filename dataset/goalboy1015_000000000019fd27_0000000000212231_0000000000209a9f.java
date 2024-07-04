import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            String S = sc.next();

            System.out.println(String.format("Case #%d: %s", tc, solve(S)));
        }

        sc.close();
    }

    static String solve(String S) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for (char ch : S.toCharArray()) {
            int digit = ch - '0';

            while (digit < depth) {
                result.append(')');
                --depth;
            }
            while (digit > depth) {
                result.append('(');
                ++depth;
            }

            result.append(digit);
        }

        for (int i = 0; i < depth; ++i) {
            result.append(')');
        }

        return result.toString();
    }
}