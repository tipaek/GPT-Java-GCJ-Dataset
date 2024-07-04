import java.io.*;
import java.util.*;
import java.awt.Point;
import java.awt.geom.*;

public class Solution {

    static class Pair {
        int x, y;
    }

    static class DisjointUnionSets {
        int[] rank, parent, ele_count;
        int n;

        public DisjointUnionSets(int n) {
            rank = new int[n];
            parent = new int[n];
            ele_count = new int[n];
            this.n = n;
            makeSet();
        }

        void makeSet() {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                ele_count[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        int setSize(int x) {
            return ele_count[find(x)];
        }

        void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot) return;

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
                ele_count[yRoot] += ele_count[xRoot];
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
                ele_count[xRoot] += ele_count[yRoot];
            } else {
                parent[yRoot] = xRoot;
                ele_count[xRoot] += ele_count[yRoot];
                rank[xRoot]++;
            }
        }
    }

    static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    static int countGreater(int arr[], int n, int k) {
        int l = 0, r = n - 1, leftGreater = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > k) {
                leftGreater = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return n - leftGreater;
    }

    static int countLessEqual(int arr[], int n, int k) {
        int l = 0, r = n - 1, leftGreater = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > k) {
                leftGreater = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return leftGreater;
    }

    public static void main(String args[]) {
        try {
            FastReader s = new FastReader();
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = s.nextInt(), case_count = 0;

            for (; t > 0; t--) {
                int n = s.nextInt();
                int[][] arr = new int[n][n];
                int x = 0, rowc = 0, colc = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = s.nextInt();
                        if (i == j) x += arr[i][j];
                    }
                }

                for (int i = 0; i < n; i++) {
                    Set<Integer> ts = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!ts.add(arr[i][j])) {
                            rowc++;
                            break;
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    Set<Integer> ts = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!ts.add(arr[j][i])) {
                            colc++;
                            break;
                        }
                    }
                }

                w.write("Case #" + (++case_count) + ": " + x + " " + rowc + " " + colc + "\n");
            }
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// FastReader class for fast input
class FastReader {
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