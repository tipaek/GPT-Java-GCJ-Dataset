import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            solve();
        }
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private class Distance implements Comparable<Distance> {
        int d1, d2;
        Distance prev;
        String print;

        Distance(int d1, int d2, Distance prev, String print) {
            this.d1 = d1;
            this.d2 = d2;
            this.prev = prev;
            this.print = print;
        }

        @Override
        public int compareTo(Distance other) {
            int sumComparison = Integer.compare(d1 + d2, other.d1 + other.d2);
            if (sumComparison == 0) {
                return Integer.compare(Math.abs(d1 - d2), Math.abs(other.d1 - other.d2));
            }
            return sumComparison;
        }

        @Override
        public String toString() {
            return d1 + " " + d2;
        }

        @Override
        public int hashCode() {
            return d1 * 997 + d2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Distance distance = (Distance) obj;
            return d1 == distance.d1 && d2 == distance.d2;
        }
    }

    private HashSet<Distance>[][] distances;
    private int[][] best;

    private void solve() {
        char[] s = nextToken().toCharArray();
        char[] t = nextToken().toCharArray();
        int lenS = s.length, lenT = t.length;

        distances = new HashSet[lenS + 1][lenT + 1];
        best = new int[lenS + 1][lenT + 1];

        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenT; j++) {
                distances[i][j] = new HashSet<>();
                best[i][j] = lenS + lenT + 1;
            }
        }

        distances[0][0].add(new Distance(0, 0, null, null));
        best[0][0] = 0;

        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenT; j++) {
                for (Distance d : distances[i][j]) {
                    if (i < lenS && j < lenT && s[i] == t[j]) {
                        relax(i + 1, j + 1, d.d1, d.d2, d, String.valueOf(s[i]));
                    }
                    if (i < lenS && j < lenT) {
                        relax(i + 1, j + 1, d.d1 + 1, d.d2 + 1, d, "");
                        relax(i + 1, j + 1, d.d1, d.d2 + 1, d, String.valueOf(s[i]));
                        relax(i + 1, j + 1, d.d1 + 1, d.d2, d, String.valueOf(t[j]));
                    }
                    if (i < lenS) {
                        relax(i + 1, j, d.d1 + 1, d.d2, d, "");
                        relax(i + 1, j, d.d1, d.d2 + 1, d, String.valueOf(s[i]));
                    }
                    if (j < lenT) {
                        relax(i, j + 1, d.d1 + 1, d.d2, d, String.valueOf(t[j]));
                        relax(i, j + 1, d.d1, d.d2 + 1, d, "");
                    }
                }
            }
        }

        int minDiff = lenS + lenT + 1;
        Distance optimalDist = null;

        for (Distance d : distances[lenS][lenT]) {
            int currentDiff = Math.abs(d.d1 - d.d2);
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                optimalDist = d;
            }
        }

        StringBuilder result = new StringBuilder();
        while (optimalDist != null && optimalDist.print != null) {
            result.append(optimalDist.print);
            optimalDist = optimalDist.prev;
        }

        out.println(result.reverse().toString());
    }

    private void relax(int i, int j, int d1, int d2, Distance prev, String print) {
        if (best[i][j] > d1 + d2) {
            best[i][j] = d1 + d2;
            distances[i][j].clear();
        }
        if (best[i][j] == d1 + d2) {
            distances[i][j].add(new Distance(d1, d2, prev, print));
        }
    }
}