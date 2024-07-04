import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int u, v, index;

    public Pair(int u, int v, int index) {
        this.u = u;
        this.v = v;
        this.index = index;
    }

    public int compareTo(Pair p) {
        return this.u - p.u;
    }
}

public class Solution {
    public static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                solve();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }, "Anshum Gupta", 99999999).start();
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

    static boolean fillMatrix(int[][] arr, int i, int j, int k) {
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
                    if (fillMatrix(arr, i, j + 1, k - x)) {
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
                    if (fillMatrix(arr, i, j + 1, k)) {
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
        Random random = new Random();
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        int tc = 1;

        if (b == 10) {
            while (tc <= t) {
                int[] ans = new int[10];
                for (int i = 1; i <= b; i++) {
                    System.out.println(i);
                    System.out.flush();
                    ans[i - 1] = scanner.nextInt();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
                System.out.flush();
                char x = scanner.next().charAt(0);
                tc++;
                if (x == 'Y') continue;
                else break;
            }
        } else {
            while (tc <= t) {
                int c = 1;
                int q = 1;
                int[] query = new int[151];
                while (q <= 20) {
                    System.out.println(c);
                    System.out.flush();
                    query[q] = scanner.nextInt();
                    if (c == 10) c -= 10;
                    c++;
                    q++;
                }
                if (b == 10) {
                    if (checkEqual(query)) continue;
                    if (checkReverse(query)) continue;
                    if (checkComplement(query)) continue;
                    if (checkComplementAndReverse(query)) continue;
                }
                tc++;
            }
        }
    }

    private static boolean checkEqual(int[] query) throws IOException {
        for (int i = 1; i <= 10; i++) {
            if (query[i] != query[i + 10]) return false;
        }
        printResult(query, 1, 10);
        return true;
    }

    private static boolean checkReverse(int[] query) throws IOException {
        for (int i = 1; i <= 10; i++) {
            if (query[i] != query[21 - i]) return false;
        }
        printResult(query, 11, 20);
        return true;
    }

    private static boolean checkComplement(int[] query) throws IOException {
        for (int i = 1; i <= 10; i++) {
            if (query[i] != 1 - query[10 + i]) return false;
        }
        printResult(query, 1, 10);
        return true;
    }

    private static boolean checkComplementAndReverse(int[] query) throws IOException {
        for (int i = 1; i <= 10; i++) {
            if (query[i] != 1 - query[21 - i]) return false;
        }
        printResult(query, 1, 10);
        return true;
    }

    private static void printResult(int[] query, int start, int end) throws IOException {
        for (int i = start; i <= end; i++) {
            System.out.print(query[i]);
        }
        System.out.println();
        System.out.flush();
        char x = new MyScanner().next().charAt(0);
        if (x == 'Y') return;
        else System.exit(1);
    }

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