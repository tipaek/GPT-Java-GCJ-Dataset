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
            for (int i = 0; i < 40; i++) {
                System.out.println(1);
                read(reader);
            }
            boolean[] bytes = new boolean[b];
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                final String x = read(reader);
                bytes[i] = "1".equals(x);
            }
            for (int i = 0; i < b; i++) {
                System.out.print(bytes[i] ? '1' : '0');
            }
            System.out.println();
            read(reader);
        }
    }

    private String read(BufferedReader reader) throws IOException {
        final String s = reader.readLine();
        if ("N".equals(s)) System.exit(0);
        return s;
    }
}
