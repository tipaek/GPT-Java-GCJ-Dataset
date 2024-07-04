import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;
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
                if (response.equals("CENTER") || response.equals("WRONG")) return;
            }
        }

        int i0 = findHit(sc, true);
        int i1 = findHit(sc, false);

        if (checkCenter(sc, i1, true) || checkCenter(sc, i1, false) || checkCenter(sc, i0, true) || checkCenter(sc, i0, false)) {
            return;
        }

        out.println((i0 - 50) + " " + 0);
        if (sc.nextLine().equals("CENTER")) return;

        out.println(0 + " " + (i1 - 50));
        if (sc.nextLine().equals("CENTER")) return;

        out.println(-1234567890 + " " + 1234567890);
        sc.nextLine();
    }

    private int findHit(MyScanner sc, boolean isX) {
        for (int i = 0; i <= 100; i++) {
            if (isX) {
                out.println((i - OFFSET) + " " + 0);
            } else {
                out.println(0 + " " + (i - OFFSET));
            }
            out.flush();
            if (sc.nextLine().equals("HIT")) return i;
        }
        return 0;
    }

    private boolean checkCenter(MyScanner sc, int value, boolean isI1) {
        for (int i = -50; i <= 50; i++) {
            if (isI1) {
                out.println(0 + " " + (value - 50));
            } else {
                out.println(i + " " + (value - 51));
            }
            out.flush();
            if (sc.nextLine().equals("CENTER")) return true;
        }
        return false;
    }

    //-----------PrintWriter for faster output---------------------------------

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

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