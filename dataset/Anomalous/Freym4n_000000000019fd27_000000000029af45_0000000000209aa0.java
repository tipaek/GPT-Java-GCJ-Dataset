import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        BufferedReader bf;
        StringTokenizer st;

        public FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(bf.readLine());
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

        String nextLine() throws IOException {
            return bf.readLine();
        }

        boolean ready() throws IOException {
            return bf.ready() || (st != null && st.hasMoreElements());
        }
    }

    static int[][] m;
    static int n, k;
    static int[] diag;
    static int[][] dif;

    static void makeDif() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dif[i][j] = genDif(i, j);
            }
        }
    }

    static int[] randomChange() {
        int a = (int) Math.ceil(Math.random() * n) - 1;
        int b = a;
        while (b == a) {
            b = (int) Math.ceil(Math.random() * n) - 1;
        }
        return new int[]{a, b};
    }

    static int genDif(int x, int y) {
        return (m[x][y] + m[y][x]) - (m[x][x] + m[y][y]);
    }

    static boolean solve1() {
        int d = k / n;
        m = new int[n][n];
        dif = new int[n][n];
        diag = new int[n * 2 - 1];
        diag[n / 2] = d;
        boolean[] v = new boolean[n + 1];
        v[d] = true;
        int cont = 1;
        for (int i = 0; i < n - 1; i++) {
            if (v[cont]) cont++;
            diag[i] = diag[i + n] = cont;
            cont++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][n - j - 1] = diag[i + j];
                if (m[i][n - j - 1] == 0) m[i][n - j - 1] = d;
            }
        }
        int target = d * n;
        int min = k * k, ans;
        int x = 0, y = 0, t;
        int rep = 0;
        while (target != k && rep <= 250) {
            makeDif();
            min = k * k;
            t = 0;
            ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    t = Math.abs(k - target - dif[i][j]);
                    if (min > t) {
                        min = t;
                        x = i;
                        y = j;
                        ans = dif[i][j];
                    }
                }
            }
            int[] arr = m[x];
            m[x] = m[y];
            m[y] = arr;
            target += ans;
            rep++;
        }
        return rep <= 250;
    }

    static Queue<Integer> genQueue(int a) {
        boolean[] v = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        v[a] = true;
        for (int i = 1; i <= n; i++) {
            if (!v[i]) q.add(i);
        }
        return q;
    }

    static boolean solve2() {
        if (n < 4) return false;
        int m1 = n / 2;
        int m2 = n / 2 + ((n & 1) == 1 ? 1 : 0);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i * m1 + j * m2 == k) {
                    solve2(i, j);
                    return true;
                }
            }
        }
        return false;
    }

    static void specialCase() {
        m = new int[][]{{2, 1, 3, 4}, {1, 3, 4, 2}, {4, 2, 1, 3}, {3, 4, 2, 1}};
    }

    static void solve2(int a, int b) {
        int[] id = new int[n + 1];
        id[1] = a;
        id[2] = b;
        m = new int[n][n];
        Set<Integer>[] s = new HashSet[n];
        for (int i = 0; i < n; i++) {
            s[i] = new HashSet<>();
        }
        for (int i = 0; i < n / 2; i++) {
            m[i][i] = 1;
            s[i].add(1);
        }
        for (int i = n / 2; i < n; i++) {
            m[i][i] = 2;
            s[i].add(2);
        }
        for (int i = 0; i < n; i++) {
            Queue<Integer> q = genQueue(i < n / 2 ? 1 : 2);
            for (int j = n - 1; j >= 0; j--) {
                if (m[i][j] != 0) continue;
                int top = q.poll();
                while (s[j].contains(top)) {
                    q.add(top);
                    top = q.poll();
                }
                m[i][j] = top;
                s[j].add(top);
            }
        }
        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        int cont = 1;
        for (int i = 1; i <= n; i++) {
            if (id[i] != 0) continue;
            while (set.contains(cont)) cont++;
            id[i] = cont;
            set.add(cont);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = id[m[i][j]];
            }
        }
    }

    static void output(int c, boolean r) {
        System.out.print("Case #" + c + ": ");
        if (r) {
            System.out.println("POSSIBLE");
            for (int[] row : m) {
                for (int j = 0; j < n; j++) {
                    System.out.print(row[j]);
                    if (j < n - 1) System.out.print(" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int c = 1; c <= t; c++) {
            n = fr.nextInt();
            k = fr.nextInt();
            boolean p = solve1();
            if (n == 4 && k == 7) {
                specialCase();
                output(c, true);
            } else if (p) {
                output(c, true);
            } else {
                p = solve2();
                output(c, p);
            }
        }
    }
}