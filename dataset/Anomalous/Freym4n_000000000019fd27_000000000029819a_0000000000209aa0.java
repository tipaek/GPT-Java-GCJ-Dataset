import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int[][] matrix;
    static int n, k;
    static int[] diag;
    static int[][] dif;

    static void makeDif() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dif[i][j] = calculateDifference(i, j);
            }
        }
    }

    static int calculateDifference(int x, int y) {
        return (matrix[x][y] + matrix[y][x]) - (matrix[x][x] + matrix[y][y]);
    }

    static boolean solve1() {
        int d = k / n;
        matrix = new int[n][n];
        dif = new int[n][n];
        diag = new int[n * 2 - 1];
        diag[n / 2] = d;
        boolean[] used = new boolean[n + 1];
        used[d] = true;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (used[count]) count++;
            diag[i] = diag[i + n] = count;
            count++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][n - j - 1] = diag[i + j];
                if (matrix[i][n - j - 1] == 0) matrix[i][n - j - 1] = d;
            }
        }
        int target = d * n;
        int min = k * k, ans;
        int x = 0, y = 0, t;
        int rep = 0;
        int[] arr;
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
            arr = matrix[x];
            matrix[x] = matrix[y];
            matrix[y] = arr;
            target += ans;
            rep++;
        }
        return rep <= 250;
    }

    static Queue<Integer> generateQueue(int a) {
        boolean[] used = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        used[a] = true;
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                queue.add(i);
            }
        }
        return queue;
    }

    static boolean solve2() {
        if (n < 4) return false;
        int m1 = n / 2;
        int m2 = n / 2 + (n % 2 == 1 ? 1 : 0);
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

    static void solve2(int a, int b) {
        int[] id = new int[n + 1];
        id[1] = a;
        id[2] = b;
        matrix = new int[n][n];
        Set<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        Queue<Integer> queue;
        for (int i = 0; i < n / 2; i++) {
            matrix[i][i] = 1;
            sets[i].add(1);
        }
        for (int i = n / 2; i < n; i++) {
            matrix[i][i] = 2;
            sets[i].add(2);
        }
        for (int i = 0; i < n; i++) {
            queue = generateQueue(i < n / 2 ? 1 : 2);
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) continue;
                int top = queue.poll();
                while (sets[j].contains(top)) {
                    queue.add(top);
                    top = queue.poll();
                }
                matrix[i][j] = top;
                sets[j].add(top);
            }
        }
        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (id[i] != 0) continue;
            while (set.contains(count)) count++;
            id[i] = count;
            set.add(count);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = id[matrix[i][j]];
            }
        }
    }

    static void output(int caseNumber, boolean result) {
        System.out.print("Case #" + caseNumber + ": ");
        if (result) {
            System.out.println("POSSIBLE");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]);
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
            boolean result = solve1();
            if (result) {
                output(c, true);
            } else {
                result = solve2();
                output(c, result);
            }
        }
    }
}