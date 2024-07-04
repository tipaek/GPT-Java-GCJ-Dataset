import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter out = new PrintWriter(System.out);
    static FastScanner in = new FastScanner(System.in);

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int ni() throws IOException {
            return Integer.parseInt(next());
        }

        long nl() throws IOException {
            return Long.parseLong(next());
        }

        double nd() throws IOException {
            return Double.parseDouble(next());
        }

        char nc() throws IOException {
            return (char) (br.read());
        }

        String ns() throws IOException {
            return br.readLine();
        }

        int[] nia(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        long[] nla(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }

        double[] nda(int n) throws IOException {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = nd();
            }
            return a;
        }

        int[][] imat(int n, int m) throws IOException {
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = ni();
                }
            }
            return mat;
        }
    }

    static long mod = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        int t = in.ni();
        for (int zz = 1; zz <= t; zz++) {
            int n = in.ni();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.ni();
                }
            }

            int sum = 0, row = 0, col = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i][i];
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                HashMap<Integer, Integer> colMap = new HashMap<>();
                
                for (int j = 0; j < n; j++) {
                    rowMap.put(a[i][j], rowMap.getOrDefault(a[i][j], 0) + 1);
                    colMap.put(a[j][i], colMap.getOrDefault(a[j][i], 0) + 1);
                }

                if (rowMap.values().stream().anyMatch(count -> count > 1)) {
                    row++;
                }
                if (colMap.values().stream().anyMatch(count -> count > 1)) {
                    col++;
                }
            }

            out.println("Case #" + zz + ": " + sum + " " + row + " " + col);
        }
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            return Integer.compare(this.y, other.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long exponent(long a, long n) {
        long ans = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            n >>= 1;
        }
        return ans;
    }

    static int binarySearch(int[] a, int item, int low, int high) {
        if (high <= low) {
            return (item > a[low]) ? (low + 1) : low;
        }
        int mid = (low + high) / 2;
        if (item == a[mid]) {
            return mid + 1;
        }
        if (item > a[mid]) {
            return binarySearch(a, item, mid + 1, high);
        }
        return binarySearch(a, item, low, mid - 1);
    }

    static void merge(int[] arr, int l, int m, int r) {
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

    static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }
}