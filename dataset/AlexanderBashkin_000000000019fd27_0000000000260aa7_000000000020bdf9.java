import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    private void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= tests; t++) {
            int n = Integer.parseInt(reader.readLine());
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(reader.readLine(), i);
            }
            solve(t, n, pairs);
        }
    }

    private void solve(int test, int n, Pair[] pairs) {
        Arrays.sort(pairs);
        int jEnd = -1, cEnd = -1;
        boolean impossible = false;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            if (jEnd <= pairs[i].start) {
                ans[pairs[i].idx] = 'J';
                jEnd = pairs[i].end;
            } else if (cEnd <= pairs[i].start) {
                ans[pairs[i].idx] = 'C';
                cEnd = pairs[i].end;
            } else {
                impossible = true;
                break;
            }
        }
        System.out.printf("Case #%d: %s\n", test, impossible ? "IMPOSSIBLE" : new String(ans));
    }

    private static class Pair implements Comparable<Pair> {
        final int start, end, idx;
        Pair(String line, int idx) {
            final StringTokenizer tokenizer = new StringTokenizer(line);
            this.start = Integer.parseInt(tokenizer.nextToken());
            this.end = Integer.parseInt(tokenizer.nextToken());
            this.idx = idx;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            final int i = Integer.compare(start, o.start);
            return i != 0 ? i : Integer.compare(end, o.end);
        }
    }
}
