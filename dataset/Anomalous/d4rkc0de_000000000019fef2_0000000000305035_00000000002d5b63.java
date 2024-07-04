import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;
    private static boolean isLocal = false;

    private static final int r = (int) (1e9 - 5);
    private static final int mn = (int) -1e9;

    private String flush(Object x) throws IOException {
        out.println(x);
        out.flush();
        return next();
    }

    private void check(String s) {
        if ("WRONG".equals(s)) throw new RuntimeException();
    }

    private void processCase() throws IOException {
        for (int x = mn; x <= mn + 10; x++) {
            for (int y = -4; y <= 4; y++) {
                String ans1 = flush(x + " " + (y - 1));
                String ans2 = flush(x + " " + y);
                String ans3 = flush(x + " " + (y + 1));
                check(ans1);
                check(ans2);
                check(ans3);
                if ("MISS".equals(ans1) && "HIT".equals(ans2) && "MISS".equals(ans3)) {
                    String res = flush((x + r) + " " + y);
                    check(res);
                    return;
                }
            }
        }
    }

    private void solve() throws Exception {
        int t = nextInt(), a = nextInt(), b = nextInt();
        for (int i = 1; i <= t; i++) {
            processCase();
        }
    }

    private int[] sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0, k = l;
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

    private class Segment implements Comparable<Segment> {
        int start, end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Segment segment = (Segment) o;
            return start == segment.start && end == segment.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(Segment segment) {
            return start == segment.start ? Integer.compare(end, segment.end) : Integer.compare(start, segment.start);
        }
    }

    private int[] readIntArray(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    private long[] readLongArray(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nextLong();
        return a;
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private String next() throws IOException {
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
            new Solution().solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}