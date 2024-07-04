import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solve(InputReader sc, PrintWriter pw) {
        int t = sc.nextInt();
        for (int iter = 1; iter <= t; iter++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int repeatedRows = 0, repeatedCols = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(arr[i])) {
                    repeatedRows++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicates(getColumn(arr, i))) {
                    repeatedCols++;
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += arr[i][i];
            }

            pw.println("Case #" + iter + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int num(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    static class Pair {
        int u, v;

        Pair(int a, int b) {
            this.u = a;
            this.v = b;
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long fastPow(long base, long exp, long mod) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        long half = fastPow(base, exp / 2, mod);
        long halfSq = (half * half) % mod;
        return exp % 2 == 0 ? halfSq : (halfSq * base) % mod;
    }

    static long modInverse(long n, long mod) {
        return fastPow(n, mod - 2, mod);
    }

    public static void feedArr(long[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
    }

    public static void feedArr(double[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }
    }

    public static void feedArr(int[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void feedArr(String[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
    }

    public static String printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString();
    }

    public static String printArr(long[] arr) {
        StringBuilder sb = new StringBuilder();
        for (long val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString();
    }

    public static String printArr(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString();
    }

    public static String printArr(double[] arr) {
        StringBuilder sb = new StringBuilder();
        for (double val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}