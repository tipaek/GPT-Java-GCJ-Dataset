import java.io.*;
import java.util.Arrays;
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

    class Segment implements Comparable<Segment> {
        int st, end, i;

        public Segment(int st, int end, int i) {
            this.st = st;
            this.end = end;
            this.i = i;
        }

        @Override
        public int compareTo(Segment seg) {
            return st == seg.st ? Integer.compare(end, seg.end) : Integer.compare(st, seg.st);
        }
    }

    void Case() throws IOException {
        int n = nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++)
            segments[i] = new Segment(nextInt(), nextInt(), i);
        Arrays.sort(segments);
        char[] ans = new char[n];
        Segment lastCsegment = new Segment(-1, -1, -1);
        Segment lastJsegment = new Segment(-1, -1, -1);
        for (Segment segment : segments) {
            if (segment.st >= lastCsegment.end) {
                lastCsegment = segment;
                ans[segment.i] = 'C';
            } else if (segment.st >= lastJsegment.end) {
                lastJsegment = segment;
                ans[segment.i] = 'J';
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }
        for (char c : ans) out.print(c);
        out.println();
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

            //long lStartTime = System.currentTimeMillis();
            new Solution().solve();
            //long lEndTime = System.currentTimeMillis();
            //out.println("Elapsed time in seconds: " + (double)(lEndTime - lStartTime) / 1000.0);
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}