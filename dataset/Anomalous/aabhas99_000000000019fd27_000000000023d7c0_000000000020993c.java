import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    static final long MOD = 1000000007L;
    static final int MAX = Integer.MAX_VALUE;
    static final int MIN = Integer.MIN_VALUE;
    static final long MAXL = Long.MAX_VALUE;
    static final long MINL = Long.MIN_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            int n = nextInt();
            int[][] ar = nextIntArray(n, n);
            int a = 0, b = 0, c = 0;

            for (int x = 0; x < n; x++) a += ar[x][x];
            b = countValidRows(ar, n);
            c = countValidColumns(ar, n);

            System.out.println("Case #" + i + ": " + a + " " + (n - b) + " " + (n - c));
        }
    }

    static int countValidRows(int[][] ar, int n) {
        int count = 0;
        for (int x = 0; x < n; x++) {
            HashSet<Integer> set = new HashSet<>();
            int max = 0;
            for (int y = 0; y < n; y++) {
                set.add(ar[x][y]);
                max = Math.max(max, ar[x][y]);
            }
            if (set.size() == n && max == n) count++;
        }
        return count;
    }

    static int countValidColumns(int[][] ar, int n) {
        int count = 0;
        for (int x = 0; x < n; x++) {
            HashSet<Integer> set = new HashSet<>();
            int max = 0;
            for (int y = 0; y < n; y++) {
                set.add(ar[y][x]);
                max = Math.max(max, ar[y][x]);
            }
            if (set.size() == n && max == n) count++;
        }
        return count;
    }

    static int nextInt() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static long nextLong() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }

    static String next() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static double nextDouble() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Double.parseDouble(st.nextToken());
    }

    static int[] nextIntArray(int n) throws IOException {
        int[] ar = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = Integer.parseInt(st.nextToken());
        return ar;
    }

    static int[][] nextIntArray(int n, int m) throws IOException {
        int[][] ar = new int[n][m];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) ar[x][y] = Integer.parseInt(st.nextToken());
        }
        return ar;
    }

    static long[] nextLongArray(int n) throws IOException {
        long[] ar = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = Long.parseLong(st.nextToken());
        return ar;
    }

    static long[][] nextLongArray(int n, int m) throws IOException {
        long[][] ar = new long[n][m];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) ar[x][y] = Long.parseLong(st.nextToken());
        }
        return ar;
    }

    static String[] nextStringArray(int n) throws IOException {
        String[] ar = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = st.nextToken();
        return ar;
    }

    static double[] nextDoubleArray(int n) throws IOException {
        double[] ar = new double[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = Double.parseDouble(st.nextToken());
        return ar;
    }

    static double[][] nextDoubleArray(int n, int m) throws IOException {
        double[][] ar = new double[n][m];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) ar[x][y] = Double.parseDouble(st.nextToken());
        }
        return ar;
    }

    static char[] nextCharArray(int n) throws IOException {
        char[] ar = new char[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = st.nextToken().charAt(0);
        return ar;
    }

    static char[][] nextCharArray(int n, int m) throws IOException {
        char[][] ar = new char[n][m];
        for (int x = 0; x < n; x++) {
            String s = br.readLine();
            for (int y = 0; y < m; y++) ar[x][y] = s.charAt(y);
        }
        return ar;
    }
}