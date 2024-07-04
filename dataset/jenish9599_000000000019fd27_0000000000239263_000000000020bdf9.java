import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ACTIVITY solver = new ACTIVITY();
        solver.solve(1, in, out);
        out.close();
    }

    static class ACTIVITY {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int t = in.scanInt();
            int cases = 1;
            while (t-- > 0) {

                int n = in.scanInt();
                int arr[][] = new int[n][];
                for (int i = 0; i < n; i++) {
                    arr[i] = new int[]{in.scanInt(), in.scanInt(), i};
                }


                int res[] = new int[n];
                Arrays.fill(res, -1);
                boolean flag = true;

                Arrays.sort(arr, new Comparator<int[]>() {

                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] == o2[1]) return o1[0] - o2[0];
                        else return o1[1] - o2[1];
                    }
                });

                SegLazy segLazy = new SegLazy(24 * 60 + 100);
                for (int i = 0; i < n; i++) {
                    int s = arr[i][0];
                    int e = arr[i][1] - 1;
                    if (e < s) continue;
                    segLazy.update(s, e, 1);
                }
                for (int i = 0; i <= 24 * 60; i++) if (segLazy.getSum(i, i) > 2) flag = false;

                int free0 = -1;
                int free1 = -1;
                for (int i = 0; i < n; i++) {
                    int s = arr[i][0];
                    if (s >= free0) {
                        res[i] = 0;
                        free0 = arr[i][1];
                    } else if (s >= free1) {
                        res[i] = 1;
                        free1 = arr[i][1];
                    } else {
                        flag = false;
                    }
                }


                out.print("Case #" + cases++ + ": ");
                if (flag) {
                    char ans[] = new char[n];
                    for (int i = 0; i < n; i++) {
                        ans[arr[i][2]] = (res[i] == 0 ? 'C' : 'J');
                    }
                    out.println(String.valueOf(ans));
                } else {
                    out.println("IMPOSSIBLE");
                }


            }
        }

    }

    static class SegLazy {
        int n;
        long[] tree;
        long[] lazy;

        public SegLazy(int n) {
            this.n = n;
            this.tree = new long[(4 * n) + 5];
            this.lazy = new long[(4 * n) + 5];
        }

        public void update(int l, int r, long val) {
            if (l > r) return;
            update(1, 0, n - 1, l, r, val);
        }

        public long getSum(int l, int r) {
            return queryRange(1, 0, n - 1, l, r);
        }

        private void update(int node, int start, int end, int l, int r, long val) {
            LAZY(node, start, end);
            if (start > end || start > r || end < l) return;
            if (start >= l && end <= r) {
                tree[node] += (end - start + 1) * val;
                if (start != end) {
                    lazy[node * 2] += val;
                    lazy[(node * 2) + 1] += val;
                }
                return;
            }
            int mid = (start + end) / 2;
            update(node * 2, start, mid, l, r, val);
            update((node * 2) + 1, mid + 1, end, l, r, val);
            tree[node] = tree[node * 2] + tree[(node * 2) + 1];
        }

        private void LAZY(int node, int start, int end) {
            if (lazy[node] != 0) {
                tree[node] += (end - start + 1) * lazy[node];
                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[(node * 2) + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        private long queryRange(int node, int start, int end, int l, int r) {
            if (start > end || start > r || end < l) return 0;
            LAZY(node, start, end);
            if (start >= l && end <= r) return (tree[node]);
            int mid = (start + end) / 2;
            long p1 = queryRange(node * 2, start, mid, l, r);
            long p2 = queryRange((node * 2) + 1, mid + 1, end, l, r);
            return ((p1 + p2));
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

