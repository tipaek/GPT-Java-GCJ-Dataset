import java.util.*;

class Solution {

    private static void solve(String input, Scanner sc, int x) {
        StringBuilder sb = new StringBuilder();
        int n = input.length();

        int depth = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            char ch = input.charAt(i);
            int v = ch - '0';

            if (prev != v) {
                int gap = depth - v;
                while (gap > 0) {
                    sb.append(")");
                    gap--;
                    depth--;
                }
            }

            for (int j = depth; j < v; j++) {
                sb.append("(");
            }
            sb.append(ch);

            depth = v;
            prev = v;
        }
        int gap = depth;
        while (gap > 0) {
            sb.append(")");
            gap--;
        }

        System.out.println(String.format("Case #%d: %s", x, sb.toString()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            String input = sc.next();
            solve(input, sc, i + 1);
        }
    }
}
