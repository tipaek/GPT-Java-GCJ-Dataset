import java.io.*;
import java.util.*;
public class Solution {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        int b = sc.nextInt();
        int eq = -1;
        int nq = -1;
        for (int k = 1; k <= t; k++) {
            int[] out = new int[b + 1];
            for (int i = 1; i <= b / 2; i++) {
                if (i > 1 && ((i - 1) * 2) % 10 == 0) {
                    boolean flip = false;
                    boolean swap = false;
                    if (eq != -1) {
                        System.out.println(eq);
                        int x = sc.nextInt();
                        if (x != out[eq])
                            flip = true;
                    }
                    if (nq != -1) {
                        System.out.println(nq);
                        int x = sc.nextInt();
                        if (x != out[nq])
                            swap = true;
                    }
                    if (flip && !swap) {
                        for (int j = 1; j < i; j++) {
                            int x = 1 - out[j];
                            out[j] = 1 - out[b - j + 1];
                            out[b - j + 1] = x;
                        }
                    }
                    if (flip && swap) {
                        for (int j = 1; j < i; j++) {
                            int x = out[j];
                            out[b - j + 1] = 1 - out[b - j + 1];
                            out[j] = 1 - x;
                        }
                    }
                    if (swap && !flip) {
                        for (int j = 1; j < i; j++) {
                            int x = out[j];
                            out[j] = out[b - j + 1];
                            out[b - j + 1] = x;
                        }
                    }
                }
                System.out.println(i);
                out[i] = sc.nextInt();
                System.out.println(b - i + 1);
                out[b - i + 1] = sc.nextInt();
                if (out[i] == out[b - i + 1]) {
                    eq = i;
                } else nq = i;
            }
            if (b % 2 == 1) {
                System.out.println((b + 1) / 2);
                out[b / 2 + 1] = sc.nextInt();
                eq = b / 2 + 1;
                if ((b / 2) % 5 == 0) {
                    boolean flip = false;
                    boolean swap = false;
                    if (eq != -1) {
                        System.out.println(eq);
                        int x = sc.nextInt();
                        if (x != out[eq])
                            flip = true;
                        out[eq] = x;
                    }
                    if (nq != -1) {
                        System.out.println(nq);
                        int x = sc.nextInt();
                        if (x != out[nq])
                            swap = true;
                    }
                    if (flip && !swap) {
                        for (int j = 1; j <= b / 2; j++) {
                            int x = 1 - out[j];
                            out[j] = 1 - out[b - j + 1];
                            out[b - j + 1] = x;
                        }
                    }
                    if (flip && swap) {
                        for (int j = 1; j <= b / 2; j++) {
                            int x = out[j];
                            out[b - j + 1] = 1 - out[b - j + 1];
                            out[j] = 1 - x;
                        }
                    }
                    if (swap && !flip) {
                        for (int j = 1; j <= b / 2; j++) {
                            int x = out[j];
                            out[j] = out[b - j + 1];
                            out[b - j + 1] = x;
                        }
                    }

                }
            }
            for (int i =1;i<=b;i++)
                System.out.print(out[i]);
            System.out.println();
            String s = sc.next();
            if (s.equals("N"))
                break;
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }

}