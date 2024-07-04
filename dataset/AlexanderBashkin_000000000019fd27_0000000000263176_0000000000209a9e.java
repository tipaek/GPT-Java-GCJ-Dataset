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
        for (int t = 0; t < tests; t++) {
            StringBuilder ans = new StringBuilder();
            int idx = 1;
            for (int i = 1; i <= b; idx++) {
                System.out.println(i);
                final String x = reader.readLine();
                if ("N".equals(x)) System.exit(0);
                if (idx % 10 != 1) {
                    ans.append(x);
                    i++;
                }
            }
            // while (idx <= 150) {
            //     System.out.println(1);
            //     final String x = reader.readLine();
            //     if ("N".equals(x)) System.exit(0);
            //     idx++;
            // }
            System.out.println(ans.toString());
        }
    }
}
