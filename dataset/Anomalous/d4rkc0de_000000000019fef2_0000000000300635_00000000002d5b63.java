import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;
    private static final boolean isLocal = false;

    private static final int r = (int) (1e9 - 5);
    private static final int mn = (int) -1e9;

    public static void main(String[] args) {
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
            System.exit(1);
        }
    }

    private void flush(Object x) {
        out.println(String.valueOf(x));
        out.flush();
    }

    private void Case() throws IOException {
        for (int x = mn; x <= mn + 10; x++) {
            for (int y = -5; y <= 5; y++) {
                flush(x + " " + (y - 1));
                String ans1 = next();
                flush(x + " " + y);
                String ans2 = next();
                flush(x + " " + (y + 1));
                String ans3 = next();
                if (ans1.equals("MISS") && ans2.equals("HIT") && ans3.equals("MISS")) {
                    flush((x + r) + " " + y);
                    return;
                }
            }
        }
    }

    private void solve() throws Exception {
        int t = 20;
        for (int i = 1; i <= t; i++) {
            Case();
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
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    private class Seg implements Comparable<Seg> {
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
            return st == seg.st && end == seg.end;
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
}