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

    static void sieves() {
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
        HashSet<Integer> uniqueFactors = new HashSet<>();
        while (x != 1 && spf[x] != 1) {
            if (!uniqueFactors.contains(spf[x]) && spf[x] != 1) {
                uniqueFactors.add(spf[x]);
                ans[spf[x]]++;
            }
            x = x / spf[x];
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            boolean foundCenter = false;
            for (int j = -5; j <= 5; j++) {
                for (int k = -5; k <= 5; k++) {
                    System.out.println(j + " " + k);
                    System.out.flush();
                    String response = sc.next();
                    if (response.equals("CENTER")) {
                        foundCenter = true;
                        break;
                    }
                }
                if (foundCenter) break;
            }
            if (foundCenter && i == T) System.exit(0);
            if (foundCenter) continue;
        }
    }

    public static void sieven(int n) {
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