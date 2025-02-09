import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        final long MOD = 1000000007;
        int t = sc.nextInt();
        int caseNumber = 0;

        while (caseNumber++ < t) {
            out.println("Case #" + caseNumber + ":");
            int n = sc.nextInt();

            if (n == 1) {
                out.println("1 1");
            } else if (n == 2) {
                out.println("1 1");
                out.println("2 1");
            } else {
                if (n <= 900) {
                    int k = (n + 1) / 2;
                    for (int i = 1; i < k; i++) {
                        out.println(i + " 1");
                    }
                    out.println(k + " 2");
                    out.println(k + " 1");
                    if (n % 2 == 0) {
                        out.println((k + 1) + " 1");
                    }
                } else {
                    int k;
                    if (n % 3 == 0) {
                        k = n / 3 - 1;
                        for (int i = 1; i <= k; i++) {
                            out.println(i + " 1");
                        }
                        out.println((k + 1) + " 2");
                        out.println((k + 2) + " 2");
                        out.println((k + 2) + " 1");
                        out.println((k + 1) + " 1");
                    } else if (n % 3 == 1) {
                        k = n / 3;
                        for (int i = 1; i <= k; i++) {
                            out.println(i + " 1");
                        }
                        out.println((k + 1) + " 2");
                        out.println((k + 2) + " 2");
                    } else {
                        k = n / 3 + 1;
                        for (int i = 1; i <= k; i++) {
                            out.println(i + " 1");
                        }
                        out.println((k + 1) + " 2");
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

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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