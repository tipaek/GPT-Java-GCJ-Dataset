import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int u, v, index;

    public Pair(int x, int y, int z) {
        u = x;
        v = y;
        index = z;
    }

    public Pair() {}

    @Override
    public int compareTo(Pair p) {
        return Integer.compare(u, p.u);
    }
}

public class Solution {
    public static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, null, "Anshum Gupta", 1 << 26) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static boolean isPositionValid(int[][] arr, int i, int j, int value) {
        int n = arr.length;
        for (int x = 0; x < i; x++) {
            if (arr[x][j] == value) return false;
        }
        for (int x = 0; x < j; x++) {
            if (arr[i][x] == value) return false;
        }
        return true;
    }

    static boolean fill(int[][] arr, int i, int j, int k) {
        int n = arr.length;
        if (j == n) {
            j = 0;
            i++;
        }
        if (i == n) {
            return true;
        }

        if (i == j) {
            for (int x = Math.max(1, k - (n - i - 1) * n); x <= Math.min(k - (n - i - 1), n); x++) {
                if (isPositionValid(arr, i, j, x)) {
                    arr[i][j] = x;
                    if (fill(arr, i, j + 1, k - x)) {
                        return true;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
            return false;
        } else {
            for (int x = 1; x <= n; x++) {
                if (isPositionValid(arr, i, j, x)) {
                    arr[i][j] = x;
                    if (fill(arr, i, j + 1, k)) {
                        return true;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
            return false;
        }
    }

    public static void solve() throws Exception {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int tc = 1; tc <= t; tc++) {
            if (b == 10) {
                int[] ans = new int[11];
                for (int i = 1; i <= b; i++) {
                    System.out.println(i);
                    System.out.flush();
                    ans[i] = scanner.nextInt();
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
                System.out.flush();
                char response = scanner.next().charAt(0);
                if (response == 'Y') continue;
                else break;
            } else {
                int[] query = new int[151];
                int c = 1;
                for (int q = 1; q <= 20; q++) {
                    System.out.println(c);
                    System.out.flush();
                    query[q] = scanner.nextInt();
                    c++;
                    if (c > 10) c -= 10;
                }
                if (b == 10) {
                    if (isEqual(query, 10) || isReverse(query, 10) || isComplement(query, 10) || isComplementAndReverse(query, 10)) {
                        for (int i = 1; i <= 10; i++) {
                            System.out.print(query[i]);
                        }
                        System.out.println();
                        System.out.flush();
                        char response = scanner.next().charAt(0);
                        if (response == 'Y') continue;
                        else break;
                    }
                }
            }
        }
    }

    private static boolean isEqual(int[] query, int n) {
        for (int i = 1; i <= n; i++) {
            if (query[i] != query[i + n]) return false;
        }
        return true;
    }

    private static boolean isReverse(int[] query, int n) {
        for (int i = 1; i <= n; i++) {
            if (query[i] != query[2 * n - i + 1]) return false;
        }
        return true;
    }

    private static boolean isComplement(int[] query, int n) {
        for (int i = 1; i <= n; i++) {
            if (query[i] != 1 - query[n + i]) return false;
        }
        return true;
    }

    private static boolean isComplementAndReverse(int[] query, int n) {
        for (int i = 1; i <= n; i++) {
            if (query[i] != 1 - query[2 * n - i + 1]) return false;
        }
        return true;
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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
}