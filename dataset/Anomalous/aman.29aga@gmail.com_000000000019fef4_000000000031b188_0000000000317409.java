import java.io.*;
import java.util.*;

public class Solution {
    static final int MAXN = 201;
    static int[] spf = new int[MAXN];
    static int[] ans = new int[MAXN];
    static int[] id = new int[MAXN];
    static int[] sz = new int[MAXN];
    static Set<Integer> s = new HashSet<>();

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

    static void sieve() {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++) {
            spf[i] = i;
        }
        for (int i = 4; i < MAXN; i += 2) {
            spf[i] = 2;
        }
        for (long i = 3; i * i < MAXN; i++) {
            if (spf[(int) i] == i) {
                for (long j = i * i; j < MAXN; j += i) {
                    if (spf[(int) j] == j) {
                        spf[(int) j] = (int) i;
                    }
                }
            }
        }
    }

    static void getFactorizations(int x) {
        Set<Integer> uniqueFactors = new HashSet<>();
        while (x != 1 && spf[x] != 1) {
            if (!uniqueFactors.contains(spf[x])) {
                uniqueFactors.add(spf[x]);
                ans[spf[x]]++;
            }
            x = x / spf[x];
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(x, y));
            for (char direction : s.toCharArray()) {
                if (direction == 'N') {
                    y++;
                } else if (direction == 'S') {
                    y--;
                } else if (direction == 'E') {
                    x++;
                } else {
                    x--;
                }
                list.add(new Pair(x, y));
            }
            int time = Integer.MAX_VALUE;
            boolean reachable = false;
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i).x;
                int b = list.get(i).y;
                if (Math.abs(a) + Math.abs(b) <= i) {
                    reachable = true;
                    time = Math.min(time, i);
                }
            }
            if (reachable) {
                System.out.println("Case #" + t + ": " + time);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    public static int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public static void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
    }

    public static void sieveN(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        for (int p = 2; p <= n; p++) {
            if (prime[p]) {
                s.add(p);
            }
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long power(long x, long y, int p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Compare {
        static void compare(Pair[] arr, int n) {
            Arrays.sort(arr, Comparator.comparingInt(p -> p.x));
        }
    }
}