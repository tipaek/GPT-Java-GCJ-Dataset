import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    private void solve() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int tests = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int idx = 1;
        for (int t = 0; t < tests; t++) {
            StringBuilder ans = new StringBuilder();
            for (int i = 1; i <= b; idx++) {
                System.out.println(i);
                final String x = read(reader);
                if (idx % 10 != 1) {
                    ans.append(x);
                    i++;
                }
            }
            System.out.println(ans.toString());
        }
    }

    private String read(BufferedReader reader) throws IOException {
        final String s = reader.readLine();
        if ("N".equals(s)) System.exit(0);
        return s;
    }
}
