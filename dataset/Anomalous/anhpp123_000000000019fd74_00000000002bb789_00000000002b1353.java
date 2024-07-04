import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        final long MOD = 1000000007;
        int testCases = scanner.nextInt();
        int currentCase = 0;

        while (currentCase++ < testCases) {
            out.println("Case #" + currentCase + ": ");
            int n = scanner.nextInt();

            if (n == 1) {
                out.println("1 1");
            } else if (n == 2) {
                out.println("1 1");
                out.println("2 1");
            } else {
                if (n <= 900) {
                    int k = (n + 1) / 2;
                    for (int i = 1; i <= k; i++) {
                        out.println(i + " 1");
                    }
                    out.println(k + " 2");
                    if (n % 2 == 0) {
                        out.println((n / 2) + " 1");
                    }
                } else {
                    int k = n / 3 + 1;
                    for (int i = 1; i <= k; i++) {
                        out.println(i + " 1");
                    }
                    out.println(k + " 2");
                    if (n % 3 == 0) {
                        out.println((k - 1) + " 2");
                    } else if (n % 3 == 1) {
                        out.println((k - 1) + " 2");
                        out.println((k - 1) + " 1");
                    } else {
                        out.println(k + " 1");
                        out.println(k + " 2");
                    }
                }
            }
        }
        out.close();
    }

    public String solve(int n, int[] s, int[] e) {
        return "";
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}