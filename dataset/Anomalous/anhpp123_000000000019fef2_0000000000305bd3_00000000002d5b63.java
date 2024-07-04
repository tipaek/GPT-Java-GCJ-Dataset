import java.io.*;
import java.util.*;

public class Solution {
    private static final int OFFSET = -1000000000;
    private static final long MOD = 1000000007;
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Solution sol = new Solution();

        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            sol.solve(sc, out);
        }
        out.close();
    }

    public void solve(MyScanner sc, PrintWriter out) {
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

        int i0 = findHitCoordinate(sc, out, true);
        int i1 = findHitCoordinate(sc, out, false);

        if (checkCenter(sc, out, i1, 50) || checkCenter(sc, out, i1, 51) ||
            checkCenter(sc, out, i0, 51) || checkCenter(sc, out, i0, 50)) {
            return;
        }

        out.println((i0 - 50) + " " + 0);
        out.flush();
        if (sc.nextLine().equals("CENTER")) {
            return;
        }

        out.println(0 + " " + (i1 - 50));
        out.flush();
        if (sc.nextLine().equals("CENTER")) {
            return;
        }

        for (int i = 0; i <= 300; i++) {
            out.println(0 + " " + 0);
            out.flush();
            if (sc.nextLine().equals("WRONG")) {
                return;
            }
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

    private boolean checkCenter(MyScanner sc, PrintWriter out, int coordinate, int offset) {
        for (int i = -50; i <= 50; i++) {
            if (coordinate == 0) {
                out.println(0 + " " + (coordinate - offset));
            } else {
                out.println((coordinate - offset) + " " + i);
            }
            out.flush();
            if (sc.nextLine().equals("CENTER")) {
                return true;
            }
        }
        return false;
    }

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
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