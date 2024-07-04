import java.io.*;
import java.util.*;

public class Solution extends PrintWriter {

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }

    void run() {
        int t = nextInt();

        for (int x = 1; x <= t; x++) {
            int n = nextInt();
            int[] s = new int[n];
            int[] e = new int[n];

            for (int i = 0; i < n; i++) {
                s[i] = nextInt();
                e[i] = nextInt() - 1;
            }

            String ans = solve(n, s, e);
            printf("Case #%d: %s%n", x, ans);
        }
    }

    String solve(int n, int[] s, int[] e) {
        int[] cnt = new int[24 * 60];

        for (int i = 0; i < n; i++) {
            for (int x = s[i]; x <= e[i]; x++) {
                if (++cnt[x] > 2) {
                    return "IMPOSSIBLE";
                }
            }
        }

        List<Integer>[] g = createAdjacencyList(n);

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < u; v++) {
                if (overlap(s[u], e[u], s[v], e[v])) {
                    g[u].add(v);
                    g[v].add(u);
                }
            }
        }

        boolean[] use = new boolean[n];
        boolean[] color = new boolean[n];
        for (int u = 0; u < n; u++) {
            dfs(u, true, color, use, g);
        }

        char[] ans = new char[n];
        for (int u = 0; u < n; u++) {
            ans[u] = color[u] ? 'C' : 'J';
        }

        return new String(ans);
    }

    void dfs(int u, boolean c, boolean[] color, boolean[] use, List<Integer>[] g) {
        if (use[u]) return;
        use[u] = true;
        color[u] = c;
        for (int v : g[u]) {
            dfs(v, !c, color, use, g);
        }
    }

    List<Integer>[] createAdjacencyList(int n) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        return g;
    }

    boolean overlap(int s1, int e1, int s2, int e2) {
        return (s1 <= s2 && s2 <= e1) || (s1 <= e2 && e2 <= e1) || (s2 <= s1 && s1 <= e2) || (s2 <= e1 && e1 <= e2);
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    String next() {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }
}