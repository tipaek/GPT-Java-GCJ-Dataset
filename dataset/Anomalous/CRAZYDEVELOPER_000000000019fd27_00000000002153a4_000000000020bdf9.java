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
            Pair[] begin = new Pair[n];
            Pair[] end = new Pair[n];
            for (int i = 0; i < n; i++) {
                begin[i] = new Pair(i, sc.nextInt());
                end[i] = new Pair(i, sc.nextInt());
            }

            Arrays.sort(begin, Comparator.comparingInt(p -> p.v));
            Arrays.sort(end, Comparator.comparingInt(p -> p.v));

            int i = 0, j = 0;
            char[] ans = new char[n];
            boolean f1 = false, f2 = false;

            while (i < n && j < n) {
                if (begin[i].v < end[j].v) {
                    if (f1 && f2) {
                        pw.println("Case #" + iter + ": IMPOSSIBLE");
                        continue;
                    }
                    if (!f1) {
                        ans[begin[i].u] = 'C';
                        f1 = true;
                    } else {
                        ans[begin[i].u] = 'J';
                        f2 = true;
                    }
                    i++;
                } else {
                    if (ans[end[j].u] == 'C')
                        f1 = false;
                    else
                        f2 = false;
                    j++;
                }
            }
            pw.println("Case #" + iter + ": " + new String(ans));
        }
    }

    static class Pair {
        int u, v;

        Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;
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
        return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }
}