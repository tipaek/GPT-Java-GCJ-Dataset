////////////////////////////////////////////////////
//                                                //
//  For her who keeps the fire kindling in me...  //
//                                                //
////////////////////////////////////////////////////

import java.io.*;
import java.util.*;
import java.awt.Point;
import java.awt.geom.*;

public class Solution {

    static class Pair {
        int x;
        int y;
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
            if ((y & 1) == 1) res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static int countGreater(int[] arr, int n, int k) {
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
        return (n - leftGreater);
    }

    static int countLessEqual(int[] arr, int n, int k) {
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

    public static void main(String[] args) {
        try {
            FastReader s = new FastReader();
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
            int t = s.nextInt();
            char[] arr;
            Stack<Character> stk = new Stack<>();
            int case_count = 0;

            while (t-- > 0) {
                arr = s.nextLine().toCharArray();
                int n = arr.length, prev = 0;
                w.write("Case #" + (++case_count) + ": ");

                for (int i = 0; i < n; i++) {
                    int x = arr[i] - '0';
                    if (x > prev) {
                        for (int j = 0; j < x - prev; j++) {
                            w.write("(");
                            stk.push(')');
                        }
                    } else if (prev > x) {
                        for (int j = 0; j < prev - x; j++) {
                            w.write(stk.pop());
                        }
                    }
                    w.write(arr[i]);
                    prev = x;
                }

                while (!stk.isEmpty()) {
                    w.write(stk.pop());
                }
                w.write("\n");
            }
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

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