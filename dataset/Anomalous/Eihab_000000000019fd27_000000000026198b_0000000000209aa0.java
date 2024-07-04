import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer sc;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        sc = new StringTokenizer("");

        new TaskD().solve();

        br.close();
        out.close();
    }

    static class TaskD {
        public void solve() throws IOException {
            int t = nextInt();

            for (int ii = 0; ii < t; ii++) {
                int n = nextInt();
                int k = nextInt();

                if (k % n != 0) {
                    out.println("Case #" + (ii + 1) + ": IMPOSSIBLE");
                    continue;
                }

                int[][] arr = new int[n][n];
                int start = k / n;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = start - i + j;
                        if (arr[i][j] <= 0) arr[i][j] += n;
                        else if (arr[i][j] > n) arr[i][j] -= n;
                    }
                }

                out.println("Case #" + (ii + 1) + ": POSSIBLE");
                for (int[] row : arr) {
                    for (int num : row) {
                        out.print(num + " ");
                    }
                    out.println();
                }
            }
        }

        class Trie {
            private final Node root;

            Trie() {
                root = new Node();
            }

            void add(long x) {
                Node cur = root;
                while (x > 0) {
                    int ls = (int) (x % 10);
                    x /= 10;
                    cur.cnt[ls]++;
                    if (cur.nodes[ls] == null) cur.nodes[ls] = new Node();
                    cur = cur.nodes[ls];
                }
            }

            void sub(long x) {
                Node cur = root;
                while (x > 0) {
                    int ls = (int) (x % 10);
                    x /= 10;
                    cur.cnt[ls]--;
                    cur = cur.nodes[ls];
                }
            }

            long[] getcnt(long x) {
                int res = 0, prev = 0, depth = 0;
                Node cur = root;

                while (x > 0 && depth < 10) {
                    int ls = (int) (x % 10);
                    x /= 10;
                    res = cur.cnt[9 - ls];
                    if (res != 0) {
                        depth++;
                        prev = res;
                        cur = cur.nodes[9 - ls];
                    } else break;
                }

                return new long[]{depth, prev};
            }
        }

        class Node {
            private final Node[] nodes;
            private final int[] cnt;

            Node() {
                nodes = new Node[10];
                cnt = new int[10];
            }
        }
    }

    private static String nextToken() throws IOException {
        while (!sc.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null) return null;
            sc = new StringTokenizer(s.trim());
        }
        return sc.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private static int[] nextIntArray(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    private static long[] nextLongArray(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        return a;
    }

    private static char[] nextCharArray() throws IOException {
        return nextToken().toCharArray();
    }

    private static int getMin(int[] arr, int count) {
        int min = arr[0];
        for (int i = 1; i < count; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    private static int getMax(int[] arr, int count) {
        int max = arr[0];
        for (int i = 1; i < count; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    private static void sortAsc(int[] arr, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void sortDesc(int[] arr, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}