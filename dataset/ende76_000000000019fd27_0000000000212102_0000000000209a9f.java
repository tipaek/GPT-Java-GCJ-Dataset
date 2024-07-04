import java.util.Scanner;

public class Solution {

    private static String solve(String S) {
        int depth = 0;

        StringBuilder result = new StringBuilder();

        for (char c : S.toCharArray()) {
            int d = c - '0';

            while (depth < d) {
                result.append('(');
                depth += 1;
            }

            while (depth > d) {
                result.append(')');
                depth -= 1;
            }

            result.append(c);
        }

        while (depth > 0) {
            result.append(')');
            depth -= 1;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        s.nextLine();

        for (int t = 1; t <= T; t += 1) {
            String S = s.nextLine();

            String result = solve(S);


            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}
