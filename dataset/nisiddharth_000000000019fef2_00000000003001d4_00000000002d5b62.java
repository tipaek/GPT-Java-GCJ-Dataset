import java.io.*;
import java.util.*;

public class Solution {

    static String bfs(int x, int y) {
        Pair a = new Pair(0, 0, 1, "");
        Queue < Pair > q = new LinkedList<>();
        q.offer(a);
        while(!q.isEmpty()) {
            Pair p = q.poll();
            if(Math.abs(p.x) > Math.abs(x) || Math.abs(p.y) > Math.abs(y)) {
                continue;
            }
            if(p.x == x && p.y == y) {
                return p.path;
            }
            if(p.x != x) {
                q.offer(new Pair(p.x + p.step, p.y, p.step * 2, p.path + "E"));
                q.offer(new Pair(p.x - p.step, p.y, p.step * 2, p.path + "W"));
            }
            if(p.y != y) {
                q.offer(new Pair(p.x, p.y + p.step, p.step * 2, p.path + "N"));
                q.offer(new Pair(p.x, p.y - p.step, p.step * 2, p.path + "S"));
            }
        }
        return "IMPOSSIBLE";
    }

    static void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        out.println(bfs(a, b));
    }

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // sieve();
        int tt = nextInt();
        // int tt = 1;
        for(int test = 1; test <= tt; ++test) {
            out.print("Case #" + test + ": ");
            solve();
        }
        out.close();
    }

    static final long mod = (long) (1e9 + 7);
    static final int inf = (int) (1e9 + 1);

    static class Pair {
        int x, y, step;
        String path;

        Pair(int a, int b, int c, String ss) {
            x = a;
            y = b;
            step = c;
            path = ss;
        }
    }

    public static int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static double nextDouble() {
        return Double.parseDouble(next());
    }

    static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    static int[] nextIntArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    static int[] memset(int n, int val) {
        int ar[] = new int[n];
        Arrays.fill(ar, val);
        return ar;
    }

    static void debug(Object... a) {
        System.out.print("> ");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void debug(int a[]) {
        debugnsp(Arrays.stream(a).boxed().toArray());
    }

    static void debug(long a[]) {
        debugnsp(Arrays.stream(a).boxed().toArray());
    }

    static void debugnsp(Object a[]) {
        System.out.print("> ");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

/*
 * Jai Sita Ram Ji
 *
 * @author: Nishchal Siddharth Pandey
 */
