import java.io.*;
import java.util.*;

public class Solution {
    static final int MAXN = 201;
    static int[] spf = new int[MAXN];
    static int[] ans = new int[MAXN];
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

    static void sieve() {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++)
            spf[i] = i;
        for (int i = 4; i < MAXN; i += 2)
            spf[i] = 2;
        for (int i = 3; i * i < MAXN; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < MAXN; j += i)
                    if (spf[j] == j)
                        spf[j] = i;
            }
        }
    }

    static void getFactorizations(int x) {
        HashSet<Integer> factors = new HashSet<>();
        while (x != 1 && spf[x] != 1) {
            if (!factors.contains(spf[x]) && spf[x] != 1) {
                factors.add(spf[x]);
                ans[spf[x]]++;
            }
            x = x / spf[x];
        }
    }

    static int min = Integer.MAX_VALUE;
    static String res = "";

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = "";
            res = "";
            int jump = 1, count = 0;
            min = Integer.MAX_VALUE;
            find(0, 0, x, y, s, jump, count);
            if (min == Integer.MAX_VALUE)
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + i + ": " + res);
        }
    }

    public static void find(int a, int b, int x, int y, String str, int jump, int count) {
        if (a == x && b == y) {
            if (count < min) {
                res = str;
                min = count;
            }
            return;
        } else if (a > 100 || b > 100 || a < -100 || b < -100) {
            return;
        }
        find(a - jump, b, x, y, str + 'W', jump * 2, count + 1);
        find(a + jump, b, x, y, str + 'E', jump * 2, count + 1);
        find(a, b + jump, x, y, str + 'N', jump * 2, count + 1);
        find(a, b - jump, x, y, str + 'S', jump * 2, count + 1);
    }

    public static void sievePrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for (int p = 2; p <= n; p++)
            if (prime[p])
                s.add(p);
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
            Arrays.sort(arr, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return Integer.compare(p1.x, p2.x);
                }
            });
        }
    }
}