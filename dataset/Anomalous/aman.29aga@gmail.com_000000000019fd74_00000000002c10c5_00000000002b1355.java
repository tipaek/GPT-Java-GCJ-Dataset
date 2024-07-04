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
                for (long j = i * i; j < MAXN; j += i) {
                    if (spf[(int) j] == j) 
                        spf[(int) j] = (int) i;
                }
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
                boolean found = false;
                ArrayList<Pair> toUpdate = new ArrayList<>();

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (vs[i][j] == 0) {
                            double total = 0, count = 0;
                            int[] neighbors = {-1, -1, -1, -1};

                            for (int k = i + 1; k < R; k++) {
                                if (vs[k][j] == 0) {
                                    total += a[k][j];
                                    count++;
                                    neighbors[0] = k;
                                    break;
                                }
                            }
                            for (int k = i - 1; k >= 0; k--) {
                                if (vs[k][j] == 0) {
                                    total += a[k][j];
                                    count++;
                                    neighbors[1] = k;
                                    break;
                                }
                            }
                            for (int k = j + 1; k < C; k++) {
                                if (vs[i][k] == 0) {
                                    total += a[i][k];
                                    count++;
                                    neighbors[2] = k;
                                    break;
                                }
                            }
                            for (int k = j - 1; k >= 0; k--) {
                                if (vs[i][k] == 0) {
                                    total += a[i][k];
                                    count++;
                                    neighbors[3] = k;
                                    break;
                                }
                            }

                            if (total / count > a[i][j]) {
                                found = true;
                                toUpdate.add(new Pair(i, j));

                                for (int k = 0; k < 4; k++) {
                                    if (neighbors[k] != -1) {
                                        if (k < 2) toUpdate.add(new Pair(neighbors[k], j));
                                        else toUpdate.add(new Pair(i, neighbors[k]));
                                    }
                                }
                            }
                        }
                    }
                }

                if (!found) break;

                for (Pair p : toUpdate) {
                    vs[p.x][p.y] = 1;
                    a[p.x][p.y] = 0;
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

    public static void sieven(int n) {
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
        return b == 0 ? a : gcd(b, a % b);
    }

    static long power(long x, long y, int p) {
        long res = 1;
        x = x % p;

        while (y > 0) {
            if ((y & 1) == 1) 
                res = (res * x) % p;
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
        static void compare(Pair[] arr, int n) {
            Arrays.sort(arr, Comparator.comparingInt(p -> p.x));
        }
    }
}