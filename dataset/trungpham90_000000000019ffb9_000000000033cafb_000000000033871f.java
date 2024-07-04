import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * #
 *
 * @author pttrung
 */
public class Solution {
    public static long MOD = 1000000007;


    public static void main(String[] args) throws FileNotFoundException {
        // PrintWriter out = new PrintWriter(new FileOutputStream(new File(
        // "output.txt")));
        PrintWriter out = new PrintWriter(System.out);
        Scanner in = new Scanner();
        int T = in.nextInt();
        for (int z = 0; z < T; z++) {
            int c = in.nextInt();
            int d = in.nextInt();
            int[] data = new int[c - 1];
            P[] store = new P[c - 1];
            for (int i = 0; i < c - 1; i++) {
                data[i] = in.nextInt();
                if (data[i] < 0) {
                    store[i] = new P(i + 1, -data[i], -1);
                } else {
                    store[i] = new P(i + 1, -1, data[i]);
                }
            }
            ArrayList<Integer>[] map = new ArrayList[c];
            for (int i = 0; i < c; i++) {
                map[i] = new ArrayList<>();
            }
            int[][] edge = new int[d][2];
            for (int i = 0; i < d; i++) {
                edge[i][0] = in.nextInt() - 1;
                edge[i][1] = in.nextInt() - 1;
                map[edge[i][0]].add(i);
                map[edge[i][1]].add(i);
            }
            arrage(store);
            Arrays.sort(store, (a, b) -> {
                if (a.node != b.node) {
                    return Integer.compare(a.node, b.node);
                }
                return Integer.compare(b.time, a.time);
            });
            int[] dist = new int[c];
            int[] pa = new int[c];
            Arrays.fill(pa, -1);
            pa[0] = -2;
            int cur = 0;
            int[] result = new int[d];
            Arrays.fill(result, 1000000);
            for (int i : map[0]) {
                int other = edge[i][0] == 0 ? edge[i][1] : edge[i][0];
                pa[other] = i;
            }
            int last = -1;
            for (P p : store) {
                if (p.node != last) {
                    if (p.time == -1) {
                        cur += 1;
                    } else {
                        cur = p.time;
                    }
                    last = p.node;
                }
                int paNode = edge[pa[p.index]][0] == p.index ? edge[pa[p.index]][1] : edge[pa[p.index]][0];
                int distPa = dist[paNode];
                result[pa[p.index]] = cur - distPa;
                dist[p.index] = cur;
                for (int i : map[p.index]) {
                    int other = edge[i][0] == p.index ? edge[i][1] : edge[i][0];
                    if (pa[other] == -1) {
                        pa[other] = i;
                    }
                }
            }


            out.print("Case #" + (z + 1) + ":");
            for (int i : result) {
                out.print(" " + i);
            }
            out.println();
        }
        out.close();
    }

    static void arrage(P[] data) {
        ArrayList<P> a = new ArrayList<>();
        PriorityQueue<P> b = new PriorityQueue<>((x, y) -> Integer.compare(x.time, y.time));
        for (P p : data) {
            if (p.node != -1) {
                a.add(p);
            } else {
                b.add(p);
            }
        }
        Collections.sort(a, (x, y) -> Integer.compare(x.node, y.node));
        ArrayList<P> result = new ArrayList<>();
        int last = -1;
        for (P p : a) {
            int cur = result.size() + 1;
            int count = 0;
            while (result.size() + 1 < p.node) {
                P tmp = b.poll();
                if (tmp.time > last) {
                    last = tmp.time;
                    cur += count;
                    count = 1;
                } else {
                    count++;
                }
                tmp.node = cur;
                result.add(tmp);
            }
            result.add(p);
        }
        int cur = result.size() + 1;
        int count = 0;
        while (!b.isEmpty()) {
            P tmp = b.poll();
            if (tmp.time > last) {
                last = tmp.time;
                cur += count;
            } else {
                count++;
            }
            tmp.node = cur;
            result.add(tmp);
        }
    }

    static class P {
        int index, node, time;

        P(int index, int node, int time) {
            this.index = index;
            this.node = node;
            this.time = time;
        }

    }


    public static int[] KMP(String val) {
        int i = 0;
        int j = -1;
        int[] result = new int[val.length() + 1];
        result[0] = -1;
        while (i < val.length()) {
            while (j >= 0 && val.charAt(j) != val.charAt(i)) {
                j = result[j];
            }
            j++;
            i++;
            result[i] = j;
        }
        return result;

    }

    public static boolean nextPer(int[] data) {
        int i = data.length - 1;
        while (i > 0 && data[i] < data[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = data.length - 1;
        while (data[j] < data[i - 1]) {
            j--;
        }
        int temp = data[i - 1];
        data[i - 1] = data[j];
        data[j] = temp;
        Arrays.sort(data, i, data.length);
        return true;
    }

    public static int digit(long n) {
        int result = 0;
        while (n > 0) {
            n /= 10;
            result++;
        }
        return result;
    }

    public static double dist(long a, long b, long x, long y) {
        double val = (b - a) * (b - a) + (x - y) * (x - y);
        val = Math.sqrt(val);
        double other = x * x + a * a;
        other = Math.sqrt(other);
        return val + other;

    }

    public static class Point implements Comparable<Point> {

        int x, y;

        public Point(int start, int end) {
            this.x = start;
            this.y = end;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 47 * hash + this.x;
            hash = 47 * hash + this.y;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(x, o.x);
        }
    }

    public static class FT {

        long[] data;

        FT(int n) {
            data = new long[n];
        }

        public void update(int index, long value) {
            while (index < data.length) {
                data[index] += value;
                index += (index & (-index));
            }
        }

        public long get(int index) {
            long result = 0;
            while (index > 0) {
                result += data[index];
                index -= (index & (-index));
            }
            return result;

        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }

        long val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val;
        } else {
            return val * (val * a);

        }
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() throws FileNotFoundException {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //  br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}