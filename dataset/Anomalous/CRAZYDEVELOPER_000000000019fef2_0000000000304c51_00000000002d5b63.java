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

    static int L, R, top, bottom;

    public static void solve(InputReader sc, PrintWriter pw) {
        int t = sc.nextInt();
        long A = sc.nextLong(), B = sc.nextLong();

        for (int iter = 1; iter <= t; iter++) {
            long d = 1000000000, l = -1000000000, u = -1000000000, r = 1000000000;
            while (l <= r && u <= d) {
                long mx = (l + r) / 2;
                long my = (u + d) / 2;
                println(mx + " " + my);
                String ver = sc.next();
                
                if (ver.equals("CENTER")) continue;

                if (ver.equals("HIT")) {
                    boolean found = false;

                    if (isValid(mx + A)) {
                        println((mx + A) + " " + my);
                        ver = sc.next();
                        if (ver.equals("CENTER")) continue;
                        if (ver.equals("HIT")) {
                            l = mx + 1;
                            r = Math.min(r, mx + A);
                            found = true;
                        }
                    }

                    if (!found && isValid(mx - A)) {
                        println((mx - A) + " " + my);
                        ver = sc.next();
                        if (ver.equals("CENTER")) continue;
                        if (ver.equals("HIT")) {
                            r = mx - 1;
                            l = Math.max(l, mx - A);
                        }
                    }

                    found = false;

                    if (isValid(my + A)) {
                        println(mx + " " + (my + A));
                        ver = sc.next();
                        if (ver.equals("CENTER")) continue;
                        if (ver.equals("HIT")) {
                            u = my + 1;
                            d = Math.min(d, my + A);
                            found = true;
                        }
                    }

                    if (!found && isValid(my - A)) {
                        println(mx + " " + (my - A));
                        ver = sc.next();
                        if (ver.equals("CENTER")) continue;
                        if (ver.equals("HIT")) {
                            d = my - 1;
                            u = Math.max(u, my - A);
                        }
                    }
                }

                if (ver.equals("MISS")) break;
            }
        }
    }

    static boolean isValid(long value) {
        return value <= 1000000000 && value >= -1000000000;
    }

    static void println(String s) {
        System.out.println(s);
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

    static long fast_pow(long base, long n, long M) {
        if (n == 0) return 1;
        if (n == 1) return base;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0) return (halfn * halfn) % M;
        else return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }

    public static void feedArr(long[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextLong();
    }

    public static void feedArr(double[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextDouble();
    }

    public static void feedArr(int[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
    }

    public static void feedArr(String[] arr, InputReader sc) {
        for (int i = 0; i < arr.length; i++) arr[i] = sc.next();
    }

    public static String printArr(int[] arr) {
        StringBuilder sbr = new StringBuilder();
        for (int i : arr) sbr.append(i).append(" ");
        return sbr.toString();
    }

    public static String printArr(long[] arr) {
        StringBuilder sbr = new StringBuilder();
        for (long i : arr) sbr.append(i).append(" ");
        return sbr.toString();
    }

    public static String printArr(String[] arr) {
        StringBuilder sbr = new StringBuilder();
        for (String i : arr) sbr.append(i).append(" ");
        return sbr.toString();
    }

    public static String printArr(double[] arr) {
        StringBuilder sbr = new StringBuilder();
        for (double i : arr) sbr.append(i).append(" ");
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