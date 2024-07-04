import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
    static int[] mn, ar;
    static ArrayList<Node> al = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                solve();
            }
        }, "1", 1 << 26).start();
    }

    static void solve() {
        FastReader fr = new FastReader();
        PrintWriter op = new PrintWriter(System.out);

        int t = fr.nextInt();
        for (int cs = 1; cs <= t; ++cs) {
            char[] s = fr.next().toCharArray();
            int n = s.length;
            ar = new int[n];
            mn = new int[4 * n];
            int[][] bck = new int[n][2];

            for (int i = 0; i < n; ++i) {
                ar[i] = s[i] - '0';
            }
            buildSegmentTree(0, 0, n - 1);
            processNodes(n, 0, n - 1, 0);

            for (Node node : al) {
                bck[node.h][0] += node.ct;
                bck[node.l][1] += node.ct;
            }

            op.print("Case #" + cs + ": ");
            for (int i = 0; i < n; ++i) {
                while (bck[i][1]-- > 0) {
                    op.print('(');
                }
                op.print(s[i]);
                while (bck[i][0]-- > 0) {
                    op.print(')');
                }
            }
            op.println();
            al.clear();
        }
        op.flush();
        op.close();
    }

    static void processNodes(int n, int l, int h, int v) {
        int i = findMin(0, 0, n - 1, l, h);
        if (ar[i] > v) {
            al.add(new Node(l, h, ar[i] - v));
        }
        v = ar[i];
        if (l < i) {
            processNodes(n, l, i - 1, v);
        }
        if (i < h) {
            processNodes(n, i + 1, h, v);
        }
    }

    static void buildSegmentTree(int p, int l, int h) {
        if (l == h) {
            mn[p] = l;
            return;
        }
        int mid = (l + h) / 2;
        buildSegmentTree(2 * p + 1, l, mid);
        buildSegmentTree(2 * p + 2, mid + 1, h);
        mn[p] = (ar[mn[2 * p + 1]] < ar[mn[2 * p + 2]]) ? mn[2 * p + 1] : mn[2 * p + 2];
    }

    static int findMin(int p, int l, int h, int x, int y) {
        if (l >= x && h <= y) {
            return mn[p];
        }
        if (h < x || l > y) {
            return -1;
        }
        int mid = (l + h) / 2;
        int left = findMin(2 * p + 1, l, mid, x, y);
        int right = findMin(2 * p + 2, mid + 1, h, x, y);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return (ar[left] < ar[right]) ? left : right;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}

class Node {
    int l, h, ct;

    Node(int l, int h, int ct) {
        this.l = l;
        this.h = h;
        this.ct = ct;
    }
}