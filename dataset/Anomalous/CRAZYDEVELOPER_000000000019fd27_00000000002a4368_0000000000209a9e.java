import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    
    static int L, R, top, bottom, ans;

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
        int n = sc.nextInt();

        for (int iter = 1; iter <= t; iter++) {
            int[] arr = new int[n + 1];
            StringBuilder sbr;
            if (n == 10) {
                sbr = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    System.out.println(i);
                    arr[i] = sc.nextInt();
                    sbr.append(arr[i]);
                }
                System.out.println(sbr.toString());
                String s = sc.next();
                if (s.equals("N"))
                    System.out.println("Wrong Answer");
                continue;
            } else {
                int task = 4;
                int p1 = -1, p2 = -1, q = 10, i = 1, k = 1;
                while (true) {
                    while (i < n + 1 - k && q > 0) {
                        System.out.println(i);
                        arr[i] = sc.nextInt();
                        q--;
                        i++;
                        if (q == 0) {
                            i--;
                            break;
                        }
                        System.out.println(n + 1 - k);
                        arr[n + 1 - k] = sc.nextInt();
                        k++;
                        q--;
                    }
                    if (i >= n + 1 - k) {
                        sbr = new StringBuilder();
                        for (int j = 1; j <= n; j++)
                            sbr.append(arr[j]);
                        System.out.println(sbr.toString());
                        String s = sc.next();
                        if (s.equals("N"))
                            System.out.println("Wrong Answer");
                        continue;
                    }
                    if (i == n + 1 - k && q > 0) {
                        System.out.println(i);
                        arr[i] = sc.nextInt();
                        sbr = new StringBuilder();
                        for (int j = 1; j <= n; j++)
                            sbr.append(arr[j]);
                        System.out.println(sbr.toString());
                        String s = sc.next();
                        if (s.equals("N"))
                            System.out.println("Wrong Answer");
                        continue;
                    }
                    q = 10;
                    if (p1 == -1 || p2 == -1) {
                        for (int j = 1; j <= k; j++) {
                            if ((arr[j] ^ arr[n + 1 - j]) == 1 && p2 == -1)
                                p2 = j;
                            if ((arr[j] ^ arr[n + 1 - j]) == 0 && p1 == -1)
                                p1 = j;
                        }
                    }
                    if (p1 == -1) {
                        System.out.println(p2);
                        int temp = sc.nextInt();
                        q--;
                        if (arr[p2] != temp) {
                            task = 1;
                            execute(arr, task, i);
                        }
                    } else if (p2 == -1) {
                        System.out.println(p1);
                        int temp = sc.nextInt();
                        q--;
                        if (arr[p1] != temp) {
                            task = 1;
                            execute(arr, task, i);
                        }
                    } else {
                        System.out.println(p2);
                        int temp = sc.nextInt();
                        System.out.println(p1);
                        int tmp = sc.nextInt();
                        q -= 2;
                        if (arr[p1] == tmp) {
                            task = arr[p2] == temp ? 4 : 2;
                        } else {
                            task = arr[p2] == temp ? 3 : 1;
                        }
                        execute(arr, task, i);
                    }
                }
            }
        }
    }

    public static void execute(int[] arr, int task, int l) {
        int n = arr.length - 1;
        int temp;
        switch (task) {
            case 1:
                for (int i = 1; i <= l; i++) {
                    arr[i] ^= 1;
                    arr[n + 1 - i] ^= 1;
                }
                break;
            case 2:
                for (int i = 1; i <= l; i++) {
                    temp = arr[i];
                    arr[i] = arr[n + 1 - i];
                    arr[n + 1 - i] = temp;
                }
                break;
            case 3:
                for (int i = 1; i <= l; i++) {
                    temp = arr[i];
                    arr[i] = arr[n + 1 - i];
                    arr[n + 1 - i] = temp;
                    arr[i] ^= 1;
                    arr[n + 1 - i] ^= 1;
                }
                break;
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
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base;
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