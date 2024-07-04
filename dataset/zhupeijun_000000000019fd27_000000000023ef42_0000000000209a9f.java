import java.util.Scanner;

public class Solution {
    private Scanner sc = new Scanner(System.in);

    private void solve() {
        String s = sc.next();
        int open = 0;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int c = s.charAt(i) - '0';
            while (open < c) {
                sb.append('(');
                ++open;
            }

            while (open > c) {
                sb.append(')');
                --open;
            }
            sb.append(c);
        }

        while (open > 0) {
            sb.append(')');
            --open;
        }

        System.out.println(sb.toString());
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
