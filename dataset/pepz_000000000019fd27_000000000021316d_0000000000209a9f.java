import java.util.Scanner;

public class Solution {
    public static void solve(int t, int[] digits) {
        StringBuilder sb = new StringBuilder();

        int depth = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < depth) {
                sb.append(repeat(")", depth - digits[i]));
            } else if (digits[i] > depth) {
                sb.append(repeat("(", digits[i] - depth));
            }
            sb.append(digits[i]);
            depth = digits[i];
        }
        sb.append(repeat(")", depth));

        System.out.println(String.format("Case #%d: %s", t + 1, sb.toString()));
    }

    public static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int T = Integer.valueOf(sc.nextLine());
            for (int t = 0; t < T; t++) {
                String s = sc.nextLine();
                int[] digits = new int[s.length()];
                for (int i = 0; i < digits.length; i++) {
                    digits[i] = s.charAt(i) - '0';
                }

                solve(t, digits);
            }
        }
    }
}
