import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    private void solve() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int tests = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= tests; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            solution(t, n, a);
        }
    }

    private void solution(int test, int n, int[][] a) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i][i];
        }
        int rowDups = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> used = new HashSet<>();
            for (int j = 0; j < n; j++) {
                used.add(a[i][j]);
            }
            if (used.size() != n) rowDups++;
        }
        int colDups = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> used = new HashSet<>();
            for (int i = 0; i < n; i++) {
                used.add(a[i][j]);
            }
            if (used.size() != n) colDups++;
        }
        System.out.printf("Case #%d: %d %d %d\n", test, sum, rowDups, colDups);
    }

}
