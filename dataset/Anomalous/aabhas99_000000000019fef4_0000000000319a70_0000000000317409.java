import java.io.*;
import java.util.*;
import java.math.*;

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
        int t = nextInt();
        int caseIndex = 0;

        while (t-- > 0) {
            StringBuilder result = new StringBuilder();
            caseIndex++;
            int X = nextInt();
            int Y = nextInt();
            String s = nextString();
            int minSteps = MAX_INT;
            int steps = 0;

            for (char ch : s.toCharArray()) {
                steps++;
                switch (ch) {
                    case 'N': Y++; break;
                    case 'E': X++; break;
                    case 'W': X--; break;
                    case 'S': Y--; break;
                }
                int distance = Math.abs(X) + Math.abs(Y);
                if (distance <= steps) {
                    minSteps = Math.min(minSteps, steps);
                }
            }
            if (minSteps == MAX_INT) {
                result.append("IMPOSSIBLE");
            } else {
                result.append(minSteps);
            }
            result.append("\n");
            print("Case #" + caseIndex + ": " + result);
        }
    }

    static int nextInt() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static long nextLong() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }

    static String nextString() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static double nextDouble() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Double.parseDouble(st.nextToken());
    }

    static void print(Object obj) {
        System.out.print(obj);
    }

    static void println(Object obj) {
        System.out.println(obj);
    }

    static void println() {
        System.out.println();
    }

    static int[] readIntArray(int n) throws IOException {
        int[] array = new int[n];
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        return array;
    }

    static long[] readLongArray(int n) throws IOException {
        long[] array = new long[n];
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }
        return array;
    }

    static String[] readStringArray(int n) throws IOException {
        String[] array = new String[n];
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = st.nextToken();
        }
        return array;
    }

    static double[] readDoubleArray(int n) throws IOException {
        double[] array = new double[n];
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Double.parseDouble(st.nextToken());
        }
        return array;
    }

    static char[] readCharArray(int n) throws IOException {
        char[] array = new char[n];
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = st.nextToken().charAt(0);
        }
        return array;
    }

    static int[][] readIntMatrix(int n, int m) throws IOException {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return matrix;
    }

    static long[][] readLongMatrix(int n, int m) throws IOException {
        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; i++) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Long.parseLong(st.nextToken());
            }
        }
        return matrix;
    }

    static double[][] readDoubleMatrix(int n, int m) throws IOException {
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Double.parseDouble(st.nextToken());
            }
        }
        return matrix;
    }

    static char[][] readCharMatrix(int n, int m) throws IOException {
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        return matrix;
    }

    static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder(array.length * 11);
        for (int value : array) {
            sb.append(value).append(' ');
        }
        System.out.println(sb);
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder(row.length * 2);
            for (int value : row) {
                sb.append(value).append(' ');
            }
            System.out.println(sb);
        }
    }

    static void printArray(long[] array) {
        StringBuilder sb = new StringBuilder(array.length * 20);
        for (long value : array) {
            sb.append(value).append(' ');
        }
        System.out.println(sb);
    }

    static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            StringBuilder sb = new StringBuilder(row.length * 2);
            for (long value : row) {
                sb.append(value).append(' ');
            }
            System.out.println(sb);
        }
    }

    static void printArray(String[] array) {
        StringBuilder sb = new StringBuilder(array.length * 2);
        for (String value : array) {
            sb.append(value).append(' ');
        }
        System.out.println(sb);
    }

    static void printArray(double[] array) {
        StringBuilder sb = new StringBuilder(array.length * 20);
        for (double value : array) {
            sb.append(value).append(' ');
        }
        System.out.println(sb);
    }

    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            StringBuilder sb = new StringBuilder(row.length * 4);
            for (double value : row) {
                sb.append(value).append(' ');
            }
            System.out.println(sb);
        }
    }

    static void printArray(char[] array) {
        StringBuilder sb = new StringBuilder(array.length * 2);
        for (char value : array) {
            sb.append(value).append(' ');
        }
        System.out.println(sb);
    }

    static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            StringBuilder sb = new StringBuilder(row.length * 2);
            for (char value : row) {
                sb.append(value).append(' ');
            }
            System.out.println(sb);
        }
    }
}