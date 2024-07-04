import java.util.Scanner;

public class Solution {

    static class Test {
        public static void main(String[] args) {
            solve(new Scanner(Solution.class.getResourceAsStream("input.txt")));
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    private static void solve(Scanner scanner) {
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            String S = scanner.next() + "0";

            StringBuilder output = new StringBuilder();

            int depth = 0;
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                int digit = c - '0';
                while (depth < digit) {
                    output.append('(');
                    depth++;
                }
                while (depth > digit) {
                    output.append(')');
                    depth--;
                }
                output.append(c);
            }
            output.setLength(output.length() - 1);

            System.out.printf("Case #%d: %s\n", t + 1, output);
        }
    }

}