import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
    private void solve() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= tests; t++) {
            String s = reader.readLine();
            solve(t, s);
        }
    }

    private void solve(int t, String s) {
        StringBuilder ans = new StringBuilder();

        int opened = 0;
        for (char c : s.toCharArray()) {
            int v = c - '0';
            if (v == opened) {
                ans.append(c);
            } else if (v < opened) {
                for (int i = 0; i < opened - v; i++) {
                    ans.append(')');
                }
                opened = v;
                ans.append(c);
            } else {
                for (int i = 0; i < v - opened; i++) {
                    ans.append('(');
                }
                opened = v;
                ans.append(c);
            }
        }
        for (int i = 0; i < opened; i++) {
            ans.append(')');
        }
        System.out.printf("Case #%d: %s\n", t, ans.toString());
    }
}