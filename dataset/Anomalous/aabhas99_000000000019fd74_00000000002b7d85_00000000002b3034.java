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
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            int n = nextInt();
            String[] ar = new String[n];
            int maxLength = MIN_INT;

            for (int i = 0; i < n; i++) {
                ar[i] = nextString();
                maxLength = Math.max(maxLength, ar[i].length());
            }

            StringBuilder result = new StringBuilder();
            boolean isValid = true;

            for (int length = 1; length <= maxLength; length++) {
                char currentChar = '.';

                for (int i = 0; i < n; i++) {
                    int charIndex = ar[i].length() - length;
                    if (charIndex >= 0 && ar[i].charAt(charIndex) != '*') {
                        if (currentChar == '.') {
                            currentChar = ar[i].charAt(charIndex);
                        } else if (ar[i].charAt(charIndex) != currentChar) {
                            System.out.println("Case #" + caseNumber + ": *");
                            isValid = false;
                            break;
                        }
                    }
                }

                if (!isValid) {
                    break;
                }

                if (currentChar == '.') {
                    System.out.println("Case #" + caseNumber + ": " + result.reverse());
                    isValid = false;
                    break;
                }

                result.append(currentChar);
            }

            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + result.reverse());
            }
        }
    }

    static int nextInt() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static long nextLong() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }

    static String nextString() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static double nextDouble() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        return array;
    }

    static long[] readLongArray(int n) throws IOException {
        long[] array = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }
        return array;
    }

    static String[] readStringArray(int n) throws IOException {
        String[] array = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = st.nextToken();
        }
        return array;
    }

    static double[] readDoubleArray(int n) throws IOException {
        double[] array = new double[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Double.parseDouble(st.nextToken());
        }
        return array;
    }

    static char[] readCharArray(int n) throws IOException {
        char[] array = new char[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = st.nextToken().charAt(0);
        }
        return array;
    }

    static int[][] readIntMatrix(int n, int m) throws IOException {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return matrix;
    }

    static long[][] readLongMatrix(int n, int m) throws IOException {
        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Long.parseLong(st.nextToken());
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
        StringBuilder sb = new StringBuilder();
        for (int val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int val : row) {
                sb.append(val).append(" ");
            }
            System.out.println(sb);
        }
    }

    static void printArray(long[] array) {
        StringBuilder sb = new StringBuilder();
        for (long val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (long val : row) {
                sb.append(val).append(" ");
            }
            System.out.println(sb);
        }
    }

    static void printArray(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (String val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    static void printArray(double[] array) {
        StringBuilder sb = new StringBuilder();
        for (double val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (double val : row) {
                sb.append(val).append(" ");
            }
            System.out.println(sb);
        }
    }

    static void printArray(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (char val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (char val : row) {
                sb.append(val).append(" ");
            }
            System.out.println(sb);
        }
    }
}