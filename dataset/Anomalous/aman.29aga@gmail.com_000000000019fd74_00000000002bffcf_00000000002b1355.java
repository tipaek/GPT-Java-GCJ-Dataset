import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAXN = 201;
    static int[] spf = new int[MAXN];
    static int[] ans = new int[MAXN];
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
        for (int i = 2; i < MAXN; i++)
            spf[i] = i;
        for (int i = 4; i < MAXN; i += 2)
            spf[i] = 2;
        for (long i = 3; i * i < MAXN; i++) {
            if (spf[(int) i] == i) {
                for (long j = i * i; j < MAXN; j += i)
                    if (spf[(int) j] == j)
                        spf[(int) j] = (int) i;
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
            x = x / spf[x];
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        int caseNumber = 1;

        while (T-- > 0) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] a = new int[R][C];
            long sum = 0;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    a[i][j] = sc.nextInt();
                    sum += a[i][j];
                }
            }

            int[][] vs = new int[R][C];

            while (true) {
                int tr = -1;
                List<Pair> x = new ArrayList<>();
                List<Pair> y = new ArrayList<>();
                List<Pair> z = new ArrayList<>();

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (vs[i][j] == 0) {
                            double st = 0, ct = 0;
                            int p = -1, q = -1, r = -1, s = -1;

                            for (int k = i + 1; k < R; k++) {
                                if (vs[k][j] == 0) {
                                    ct++;
                                    p = k;
                                    st += a[k][j];
                                    break;
                                }
                            }
                            for (int k = i - 1; k >= 0; k--) {
                                if (vs[k][j] == 0) {
                                    ct++;
                                    q = k;
                                    st += a[k][j];
                                    break;
                                }
                            }
                            for (int k = j + 1; k < C; k++) {
                                if (vs[i][k] == 0) {
                                    ct++;
                                    r = k;
                                    st += a[i][k];
                                    break;
                                }
                            }
                            for (int k = j - 1; k >= 0; k--) {
                                if (vs[i][k] == 0) {
                                    ct++;
                                    s = k;
                                    st += a[i][k];
                                    break;
                                }
                            }

                            if (st / ct > a[i][j]) {
                                if (p != -1 && p < C)
                                    x.add(new Pair(i, p));
                                if (q != -1 && q < C)
                                    x.add(new Pair(i, q));
                                if (r != -1 && r < R)
                                    y.add(new Pair(r, j));
                                if (s != -1 && s < R)
                                    y.add(new Pair(s, j));
                                tr = 1;
                                z.add(new Pair(i, j));
                            }
                        }
                    }
                }

                if (tr == -1) break;

                for (Pair pair : x) {
                    a[pair.x][pair.y] = 0;
                }
                for (Pair pair : y) {
                    a[pair.x][pair.y] = 0;
                }
                for (Pair pair : z) {
                    vs[pair.x][pair.y] = 1;
                }

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (vs[i][j] == 0) {
                            sum += a[i][j];
                        }
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + sum);
            caseNumber++;
        }
    }

    public static void sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int p = 2; p <= n; p++) {
            if (prime[p])
                s.add(p);
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long power(long x, long y, int p) {
        long res = 1;
        x = x % p;

        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1;
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
        static void compare(Pair[] arr, int n) {
            Arrays.sort(arr, (p1, p2) -> {
                if (p1.x > p2.x) {
                    return 1;
                } else if (p2.x > p1.x) {
                    return -1;
                } else {
                    return 0;
                }
            });
        }
    }
}