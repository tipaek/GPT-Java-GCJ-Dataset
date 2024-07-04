import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Solution sol = new Solution();
        
        int testCaseCount = sc.nextInt();
        for (int testCaseNumber = 1; testCaseNumber <= testCaseCount; testCaseNumber++) {
            sol.solve(sc, out);
            out.flush();
        }
        out.close();
    }

    public void solve(MyScanner sc, PrintWriter out) {
        int xHit = findHitCoordinate(sc, out, true);
        int yHit = findHitCoordinate(sc, out, false);

        if (scanForCenter(sc, out, xHit, yHit)) return;
        if (scanForCenter(sc, out, xHit, yHit - 1)) return;
        if (scanForCenter(sc, out, xHit - 1, yHit)) return;

        out.println((xHit - 50) + " " + 0);
        out.flush();
        if (sc.nextLine().equals("CENTER")) return;

        out.println(0 + " " + (yHit - 50));
        out.flush();
        if (sc.nextLine().equals("CENTER")) return;

        for (int i = 0; i <= 300; i++) {
            out.println(0 + " " + 0);
            out.flush();
        }
    }

    private int findHitCoordinate(MyScanner sc, PrintWriter out, boolean isXCoordinate) {
        for (int i = 0; i <= 100; i++) {
            if (isXCoordinate) {
                out.println((i - OFFSET) + " " + 0);
            } else {
                out.println(0 + " " + (i - OFFSET));
            }
            out.flush();
            if (sc.nextLine().equals("HIT")) {
                return i;
            }
        }
        return 0;
    }

    private boolean scanForCenter(MyScanner sc, PrintWriter out, int xHit, int yHit) {
        for (int i = -50; i <= 50; i++) {
            out.println(xHit + " " + (yHit + i));
            out.flush();
            if (sc.nextLine().equals("CENTER")) return true;
        }
        return false;
    }

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