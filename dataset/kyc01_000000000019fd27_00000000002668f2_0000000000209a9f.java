import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(f.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            final String s = "0" + f.readLine() + "0";
            String res = "";
            for (int i = 1; i < s.length(); i++) {
                final int diff = Math.abs(s.charAt(i) - s.charAt(i - 1));
                final char ch;
                if (s.charAt(i) > s.charAt(i - 1)) {
                    ch = '(';
                } else {
                    ch = ')';
                }
                for (int j = 0; j < diff; j++) {
                    res += ch;
                }
                res += s.charAt(i);
            }
            System.out.printf("Case #%d: %s\n", testCase + 1, res.substring(0, res.length() - 1));
        }

    }
}
