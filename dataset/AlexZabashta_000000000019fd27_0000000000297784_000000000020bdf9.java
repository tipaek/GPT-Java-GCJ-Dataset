import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ToDoubleBiFunction;

import static java.lang.Math.*;

public class Solution extends PrintWriter {

    void dfs(int u, boolean c, boolean[] color, boolean[] use, List<Integer>[] g) {
        if (use[u]) {
            return;
        }
        use[u] = true;
        color[u] = c;
        for (int v : g[u]) {
            dfs(v, !c, color, use, g);
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

        List<Integer>[] g = new List[n];

        for (int u = 0; u < n; u++) {
            g[u] = new ArrayList<>();
        }

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < u; v++) {
                if ((s[u] <= s[v] && s[v] <= e[u]) || (s[u] <= e[v] && e[v] <= e[u]) || (s[v] <= s[u] && s[u] <= e[v]) || (s[v] <= e[u] && e[u] <= e[v])) {
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

    public static boolean nextPermutation(int[] permutation) {
        int n = permutation.length, a = n - 2;
        while (0 <= a && permutation[a] >= permutation[a + 1]) {
            a--;
        }
        if (a == -1) {
            return false;
        }

        int b = n - 1;
        while (permutation[b] <= permutation[a]) {
            b--;
        }

        swap(permutation, a, b);
        for (int i = a + 1, j = n - 1; i < j; i++, j--) {
            swap(permutation, i, j);
        }
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}
