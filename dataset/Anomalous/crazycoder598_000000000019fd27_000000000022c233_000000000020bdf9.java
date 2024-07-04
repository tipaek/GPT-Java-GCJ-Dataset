import java.util.*;
import java.io.*;
import java.math.BigDecimal;

class Solution {

    private static final long MOD = 1000000007L;
    private InputStream is;
    private PrintWriter out;
    private String INPUT = "";
    private BinaryTree[] ba;
    private BinaryTree[] ba1;
    private BinaryTree[] ba2;
    private int[] array;

    void solve() throws Exception {
        int t = ni();
        for (int ca = 1; ca <= t; ca++) {
            int n = ni();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c1 = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
                b[i] = ni();
                c1[i] = i;
            }
            MergeSort ob = new MergeSort();
            ob.sort(a, b, c1, 0, n - 1);
            int c = -1;
            int j = -1;
            int set = 0;
            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                if (c <= a[i]) {
                    d[i] = 1;
                    c = b[i];
                } else if (j <= a[i]) {
                    d[i] = 2;
                    j = b[i];
                } else {
                    set = -1;
                    break;
                }
            }
            if (set == -1) {
                out.println("Case #" + ca + ": IMPOSSIBLE");
            } else {
                out.print("Case #" + ca + ": ");
                ob.sort(c1, d, a, 0, n - 1);
                for (int i = 0; i < n; i++) {
                    out.print(d[i] == 1 ? 'C' : 'J');
                }
                out.println();
            }
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    class MergeSort {
        void merge(int arr[], int[] b, int[] c, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;
            int[] L = new int[n1];
            int[] R = new int[n2];
            int[] l1 = new int[n1];
            int[] r1 = new int[n2];
            int[] l2 = new int[n1];
            int[] r2 = new int[n2];

            for (int i = 0; i < n1; ++i) {
                L[i] = arr[l + i];
                l1[i] = b[l + i];
                l2[i] = c[l + i];
            }
            for (int j = 0; j < n2; ++j) {
                R[j] = arr[m + 1 + j];
                r1[j] = b[m + 1 + j];
                r2[j] = c[m + 1 + j];
            }

            int i = 0, j = 0, k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    b[k] = l1[i];
                    c[k] = l2[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    b[k] = r1[j];
                    c[k] = r2[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = L[i];
                b[k] = l1[i];
                c[k] = l2[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = R[j];
                b[k] = r1[j];
                c[k] = r2[j];
                j++;
                k++;
            }
        }

        void sort(int arr[], int[] b, int[] c, int l, int r) {
            if (l < r) {
                int m = (l + r) / 2;
                sort(arr, b, c, l, m);
                sort(arr, b, c, m + 1, r);
                merge(arr, b, c, l, m, r);
            }
        }
    }

    class BinaryTree {
        int key;
        BinaryTree right;
        BinaryTree left;
    }
}