import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    static int L, R, top, bottom, ans;

    public static void solve(InputReader sc, PrintWriter pw) {
        int t = sc.nextInt();
        for (int iter = 1; iter <= t; iter++) {
            char[] chrr = sc.next().toCharArray();
            StringBuilder sbr = new StringBuilder();
            int n = 0;
            for (char c : chrr) {
                while (n > c - '0') {
                    sbr.append(')');
                    n--;
                }
                while (n < c - '0') {
                    sbr.append('(');
                    n++;
                }
                sbr.append(c);
            }
            while (n > 0) {
                sbr.append(')');
                n--;
            }
            pw.println("Case #" + iter + ": " + sbr.toString());
        }
    }

    public static void swap(char[] chrr, int i, int j) {
        char temp = chrr[i];
        chrr[i] = chrr[j];
        chrr[j] = temp;
    }

    public static int num(int n) {
        int a = 0;
        while (n > 0) {
            a += (n & 1);
            n >>= 1;
        }
        return a;
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
        for (int i = 5; i * i <= n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long fast_pow(long base, long n, long M) {
        if (n == 0) return 1;
        if (n == 1) return base;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }

    public static void feedArr(long[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextLong();
    }

    public static void feedArr(double[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextDouble();
    }

    public static void feedArr(int[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
    }

    public static void feedArr(String[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.next();
    }

    public static String printArr(int[] arr) {
        StringBuilder sbr = new StringBuilder();
        for (int i : arr)
            sbr.append(i).append(" ");
        return sbr.toString();
    }

    public static String printArr(long[] arr) {
        StringBuilder sbr = new StringBuilder();
        for (long i : arr)
            sbr.append(i).append(" ");
        return sbr.toString();
    }

    public static String printArr(String[] arr) {
        StringBuilder sbr = new StringBuilder();
        for (String i : arr)
            sbr.append(i).append(" ");
        return sbr.toString();
    }

    public static String printArr(double[] arr) {
        StringBuilder sbr = new StringBuilder();
        for (double i : arr)
            sbr.append(i).append(" ");
        return sbr.toString();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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