import java.io.*;
import java.util.*;

public class Solution {
    static final long MOD = 1000000007L;
    static final int MAX_INT = Integer.MAX_VALUE;
    static final int MIN_INT = Integer.MIN_VALUE;
    static final long MAX_LONG = Long.MAX_VALUE;
    static final long MIN_LONG = Long.MIN_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int testCases = i();
        for (int t = 1; t <= testCases; t++) {
            String s = s();
            StringBuilder sb = new StringBuilder();
            char currentChar = s.charAt(0);
            int currentIndex = 0;
            int lastIndex = -1;
            int level = 0;

            for (char c : s.toCharArray()) {
                lastIndex++;
                if (c != currentChar) {
                    int currentDigit = currentChar - '0';
                    if (level < currentDigit) {
                        appendParentheses(sb, '(', currentDigit - level);
                        sb.append(s, currentIndex, lastIndex);
                        level = currentDigit;
                    } else if (level > currentDigit) {
                        appendParentheses(sb, ')', level - currentDigit);
                        sb.append(s, currentIndex, lastIndex);
                        level = currentDigit;
                    } else {
                        sb.append(s, currentIndex, lastIndex);
                    }
                    currentChar = c;
                    currentIndex = lastIndex;
                }
            }

            lastIndex++;
            int currentDigit = currentChar - '0';
            if (level < currentDigit) {
                appendParentheses(sb, '(', currentDigit - level);
                sb.append(s, currentIndex, lastIndex);
                appendParentheses(sb, ')', currentDigit);
            } else if (level > currentDigit) {
                appendParentheses(sb, ')', level - currentDigit);
                sb.append(s, currentIndex, lastIndex);
                appendParentheses(sb, ')', currentDigit);
            } else {
                sb.append(s, currentIndex, lastIndex);
            }

            System.out.println("Case #" + t + ": " + sb);
        }
    }

    static void appendParentheses(StringBuilder sb, char parenthesis, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(parenthesis);
        }
    }

    static int i() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static long l() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }

    static String s() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static double d() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Double.parseDouble(st.nextToken());
    }

    // Utility methods for printing
    static void p(Object p) { System.out.print(p); }
    static void pl(Object p) { System.out.println(p); }

    // Array input methods
    static int[] ari(int n) throws IOException {
        int[] ar = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = Integer.parseInt(st.nextToken());
        return ar;
    }

    static int[][] ari(int n, int m) throws IOException {
        int[][] ar = new int[n][m];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) ar[x][y] = Integer.parseInt(st.nextToken());
        }
        return ar;
    }

    static long[] arl(int n) throws IOException {
        long[] ar = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = Long.parseLong(st.nextToken());
        return ar;
    }

    static long[][] arl(int n, int m) throws IOException {
        long[][] ar = new long[n][m];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) ar[x][y] = Long.parseLong(st.nextToken());
        }
        return ar;
    }

    static String[] ars(int n) throws IOException {
        String[] ar = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = st.nextToken();
        return ar;
    }

    static double[] ard(int n) throws IOException {
        double[] ar = new double[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = Double.parseDouble(st.nextToken());
        return ar;
    }

    static double[][] ard(int n, int m) throws IOException {
        double[][] ar = new double[n][m];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) ar[x][y] = Double.parseDouble(st.nextToken());
        }
        return ar;
    }

    static char[] arc(int n) throws IOException {
        char[] ar = new char[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) ar[x] = st.nextToken().charAt(0);
        return ar;
    }

    static char[][] arc(int n, int m) throws IOException {
        char[][] ar = new char[n][m];
        for (int x = 0; x < n; x++) {
            String s = br.readLine();
            for (int y = 0; y < m; y++) ar[x][y] = s.charAt(y);
        }
        return ar;
    }

    // Array printing methods
    static void p(int[] ar) {
        StringBuilder sb = new StringBuilder();
        for (int a : ar) sb.append(a).append(" ");
        System.out.println(sb);
    }

    static void p(int[][] ar) {
        for (int[] a : ar) {
            StringBuilder sb = new StringBuilder();
            for (int aa : a) sb.append(aa).append(" ");
            System.out.println(sb);
        }
    }

    static void p(long[] ar) {
        StringBuilder sb = new StringBuilder();
        for (long a : ar) sb.append(a).append(" ");
        System.out.println(sb);
    }

    static void p(long[][] ar) {
        for (long[] a : ar) {
            StringBuilder sb = new StringBuilder();
            for (long aa : a) sb.append(aa).append(" ");
            System.out.println(sb);
        }
    }

    static void p(String[] ar) {
        StringBuilder sb = new StringBuilder();
        for (String a : ar) sb.append(a).append(" ");
        System.out.println(sb);
    }

    static void p(double[] ar) {
        StringBuilder sb = new StringBuilder();
        for (double a : ar) sb.append(a).append(" ");
        System.out.println(sb);
    }

    static void p(double[][] ar) {
        for (double[] a : ar) {
            StringBuilder sb = new StringBuilder();
            for (double aa : a) sb.append(aa).append(" ");
            System.out.println(sb);
        }
    }

    static void p(char[] ar) {
        StringBuilder sb = new StringBuilder();
        for (char aa : ar) sb.append(aa).append(" ");
        System.out.println(sb);
    }

    static void p(char[][] ar) {
        for (char[] a : ar) {
            StringBuilder sb = new StringBuilder();
            for (char aa : a) sb.append(aa).append(" ");
            System.out.println(sb);
        }
    }
}