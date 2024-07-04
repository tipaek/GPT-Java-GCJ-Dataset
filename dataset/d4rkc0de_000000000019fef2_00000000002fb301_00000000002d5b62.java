import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;


public class Solution {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static boolean isLocal = false;

    String ans;
    int xx, yy;

    void go(int x, int y, int i, String s) {
        if (i > 9) return;
        if (x == xx && y == yy) {
            if (s.length() < ans.length())
                ans = s;
        }
        go(x - (1 << i), y, i + 1, s + "W");
        go(x + (1 << i), y, i + 1, s + "E");
        go(x, y - (1 << i), i + 1, s + "S");
        go(x, y + (1 << i), i + 1, s + "N");
    }

    void Case() throws IOException {
        xx = nextInt();
        yy = nextInt();
        ans = "###############";
        go(0, 0, 0, "");
        out.println(ans.equals("###############") ? "IMPOSSIBLE" : ans.toString());
    }

    void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            Case();
        }
    }


    int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    class Seg implements Comparable<Seg> {
        int st, end;

        public Seg(int st, int end) {
            this.st = st;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Seg seg = (Seg) o;
            return st == seg.st &&
                    end == seg.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(st, end);
        }

        @Override
        public int compareTo(Seg seg) {
            return st == seg.st ? Integer.compare(end, seg.end) : Integer.compare(st, seg.st);
        }
    }

    private int[] na(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    private long[] nal(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nextLong();
        return a;
    }

    int nextInt() throws IOException {
        return parseInt(next());
    }

    long nextLong() throws IOException {
        return parseLong(next());
    }

    double nextDouble() throws IOException {
        return parseDouble(next());
    }

    String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) throws Exception {
        try {
            if (isLocal) {
                in = new BufferedReader(new FileReader("src/tests/sol.in"));
                out = new PrintWriter(new BufferedWriter(new FileWriter("src/tests/sol.out")));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }
//            long lStartTime = System.currentTimeMillis();
            new Solution().solve();
//            long lEndTime = System.currentTimeMillis();
//            out.println("Elapsed time in seconds: " + (double) (lEndTime - lStartTime) / 1000.0);
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}
