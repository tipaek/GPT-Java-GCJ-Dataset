////////////////////////////////////////////////////
//                                                //
//  For her who keeps the fire kindling in me...  //
//                                                //
////////////////////////////////////////////////////

import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int x, y;
    }

    static class DisjointUnionSets {
        int[] rank, parent, eleCount;
        int n;

        public DisjointUnionSets(int n) {
            this.n = n;
            rank = new int[n];
            parent = new int[n];
            eleCount = new int[n];
            makeSet();
        }

        void makeSet() {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                eleCount[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        int setSize(int x) {
            return eleCount[find(x)];
        }

        void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);

            if (xRoot == yRoot) return;

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
                eleCount[yRoot] += eleCount[xRoot];
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
                eleCount[xRoot] += eleCount[yRoot];
            } else {
                parent[yRoot] = xRoot;
                eleCount[xRoot] += eleCount[yRoot];
                rank[xRoot]++;
            }
        }
    }

    static long power(long x, long y, long p) {
        long res = 1;
        x %= p;

        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            y >>= 1;
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
            int caseCount = 0;

            while (t-- > 0) {
                char[] arr = s.nextLine().toCharArray();
                int n = arr.length, prev = 0;

                w.write("Case #" + (++caseCount) + ": ");
                Stack<Character> stk = new Stack<>();

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