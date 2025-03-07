import java.io.*;
import java.util.*;

public class Solution {
    static final int MAXN = 201;
    static int[] spf = new int[MAXN];
    static int[] ans = new int[MAXN];
    static int[] id = new int[MAXN];
    static int[] sz = new int[MAXN];
    static HashSet<Integer> s = new HashSet<>();

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
        HashSet<Integer> w = new HashSet<>();
        while (x != 1 && spf[x] != 1) {
            if (!w.contains(spf[x]) && spf[x] != 1) {
                w.add(spf[x]);
                ans[spf[x]]++;
            }
            x = x / spf[x];
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            long[] a = new long[N];
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextLong();
                map.putIfAbsent(a[i], 0);
                map.put(a[i], map.get(a[i]) + 1);
            }
            int tr = 0;
            for (long i : map.keySet()) {
                if (map.get(i) >= D) {
                    tr = -1;
                    break;
                }
            }
            if (tr == -1) {
                System.out.println("Case #" + t + ": 0");
            } else {
                tr = 1;
                for (long i : map.keySet()) {
                    if (map.get(i) >= D - 1) {
                        tr = -1;
                        break;
                    }
                }
                if (tr == -1) {
                    System.out.println("Case #" + t + ": 1");
                } else {
                    tr = 1;
                    Arrays.sort(a);
                    long num = 0, max = 0, max2 = 0, num2 = 0;
                    for (int i = 0; i < N; i++) {
                        num = map.get(a[i]);
                        num2 = map.get(a[i]);
                        for (int j = i + 1; j < N; j++) {
                            if (a[j] != a[i]) {
                                if (a[j] % a[i] == 0) {
                                    num += (a[j] / a[i]);
                                } else {
                                    num2 += (a[j] / a[i]);
                                }
                            }
                        }
                        max = Math.max(max, num);
                        max2 = Math.max(max2, num2);
                    }
                    if (max >= D) {
                        System.out.println("Case #" + t + ": 1");
                    } else {
                        System.out.println("Case #" + t + ": 2");
                    }
                }
            }
        }
    }

    public static int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public static void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void sieven(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) prime[i] = false;
            }
        }
        for (int p = 2; p <= n; p++) {
            if (prime[p]) s.add(p);
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long power(long x, long y, int p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % p;
            y = y >> 1;
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
            Arrays.sort(arr, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return Integer.compare(p1.x, p2.x);
                }
            });
        }
    }
}