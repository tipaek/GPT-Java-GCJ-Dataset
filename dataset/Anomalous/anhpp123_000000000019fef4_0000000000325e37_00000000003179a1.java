import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;
    private StringBuilder sb = new StringBuilder();
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        Solution sol = new Solution();
        for (int tt = 0; tt < t; tt++) {
            sol.solve(sc);
            out.flush();
        }
        out.close();
    }

    public void solve(MyScanner sc) {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                out.println(i + " " + j);
                out.flush();
                String response = sc.nextLine();
                if (response.equals("CENTER") || response.equals("WRONG")) {
                    return;
                }
            }
        }

        int i0 = 0, i1 = 0;
        while (i0 <= 100) {
            out.println((i0 - OFFSET) + " " + 0);
            out.flush();
            String response = sc.nextLine();
            if (response.equals("HIT")) {
                out.println((i0 - OFFSET) + " " + -1);
                out.flush();
                String res2 = sc.nextLine();
                out.println((i0 - OFFSET) + " " + 1);
                out.flush();
                String res3 = sc.nextLine();
                int a1 = res2.equals("HIT") ? 1 : 0;
                int a2 = res3.equals("HIT") ? 1 : 0;
                if (a1 == 0 && a2 == 0) {
                    out.println(0 + " " + (i1 - 50));
                    String res4 = sc.nextLine();
                    if (res4.equals("CENTER")) {
                        return;
                    }
                }
                break;
            }
            i0++;
        }

        while (i1 <= 100) {
            out.println(0 + " " + (i1 - OFFSET));
            out.flush();
            String response = sc.nextLine();
            if (response.equals("HIT")) {
                out.println(-1 + " " + (i1 - OFFSET));
                out.flush();
                String res2 = sc.nextLine();
                out.println(1 + " " + (i1 - OFFSET));
                out.flush();
                String res3 = sc.nextLine();
                int a1 = res2.equals("HIT") ? 1 : 0;
                int a2 = res3.equals("HIT") ? 1 : 0;
                if (a1 == 0 && a2 == 0) {
                    out.println(0 + " " + (i1 - 50));
                    String res4 = sc.nextLine();
                    if (res4.equals("CENTER")) {
                        return;
                    }
                }
                break;
            }
            i1++;
        }

        out.println((i0 - 51) + " " + (i1 - 51));
        String res4 = sc.nextLine();
        if (res4.equals("CENTER")) {
            return;
        }
        out.println(-1234567890 + " " + 1234567890);
        sc.nextLine();  // Read the response but do nothing with it
    }

    //-----------PrintWriter for faster output---------------------------------
    //-----------MyScanner class for faster input------------------------------
    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        public String nextLine() {
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