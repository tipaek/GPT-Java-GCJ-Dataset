import java.io.*;
import java.util.*;

public class Solution {
    static final int MAXN = 201;
    static final int MAX_DIM = 501;
    static int[] spf = new int[MAXN];
    static int[] ans = new int[MAXN];
    static Set<Integer> primeSet = new HashSet<>();
    static int[][] dp = new int[MAX_DIM][MAX_DIM];
    static int[] row = {-1, -1, 0, 0, 1, 1};
    static int[] col = {-1, 0, -1, 1, 0, 1};
    static boolean[][] visited;
    static List<Pair> result;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static void sieves() {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++) spf[i] = i;
        for (int i = 4; i < MAXN; i += 2) spf[i] = 2;
        for (long i = 3; i * i < MAXN; i++) {
            if (spf[(int) i] == i) {
                for (long j = i * i; j < MAXN; j += i) {
                    if (spf[(int) j] == j) spf[(int) j] = (int) i;
                }
            }
        }
    }

    static void getFactorizations(int x) {
        Set<Integer> factors = new HashSet<>();
        while (x != 1 && spf[x] != 1) {
            if (!factors.contains(spf[x]) && spf[x] != 1) {
                factors.add(spf[x]);
                ans[spf[x]]++;
            }
            x /= spf[x];
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        int caseNumber = 1;

        initializeDP();

        while (T-- > 0) {
            int N = sc.nextInt();
            visited = new boolean[MAX_DIM][MAX_DIM];
            result = new ArrayList<>();
            List<Pair> path = new ArrayList<>();
            path.add(new Pair(1, 1));

            System.out.println("Case #" + caseNumber + ": ");
            DFS(N - 1, path, 1, 1);
            for (Pair p : result) {
                System.out.println(p.x + " " + p.y);
            }
            caseNumber++;
        }
    }

    static void initializeDP() {
        dp[1][1] = 1;
        for (int i = 2; i < MAX_DIM; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
    }

    public static void DFS(int src, List<Pair> path, int x, int y) {
        visited[x][y] = true;
        if (src == 0 && result.isEmpty()) {
            result.addAll(path);
            return;
        }
        for (int i = 0; i < 6; i++) {
            int newRow = x + row[i];
            int newCol = y + col[i];
            if (isValidMove(newRow, newCol, src)) {
                path.add(new Pair(newRow, newCol));
                DFS(src - dp[newRow][newCol], path, newRow, newCol);
                path.remove(path.size() - 1);
            }
        }
    }

    public static boolean isValidMove(int x, int y, int src) {
        return x >= 1 && x < MAX_DIM && y >= 1 && y < MAX_DIM && !visited[x][y] && src - dp[x][y] >= 0 && dp[x][y] != 0 && result.isEmpty();
    }

    public static void sievePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * 2; i <= n; i += p) isPrime[i] = false;
            }
        }
        for (int p = 2; p <= n; p++) {
            if (isPrime[p]) primeSet.add(p);
        }
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long power(long x, long y, int p) {
        long res = 1;
        x %= p;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Compare {
        static void compare(Pair[] arr) {
            Arrays.sort(arr, Comparator.comparingInt(p -> p.x));
        }
    }
}