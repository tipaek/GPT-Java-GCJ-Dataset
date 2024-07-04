import java.io.*;
import java.util.*;

public class Solution {
    private static final int OFFSET = -1000000000;
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Solution sol = new Solution();

        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            sol.solve(sc, out);
            out.flush();
        }
        out.close();
    }

    public void solve(MyScanner sc, PrintWriter out) {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                out.println(i + " " + j);
                out.flush();
                String response = sc.nextLine();
                if ("CENTER".equals(response) || "WRONG".equals(response)) {
                    return;
                }
            }
        }

        int xHit = findHitX(sc, out);
        int yHit = findHitY(sc, out);

        if (checkCenter(sc, out, xHit, yHit)) {
            return;
        }

        out.println(-1234567890 + " " + 1234567890);
        sc.nextLine();
    }

    private int findHitX(MyScanner sc, PrintWriter out) {
        for (int i = 0; i <= 100; i++) {
            out.println((i - OFFSET) + " " + 0);
            out.flush();
            String response = sc.nextLine();
            if ("HIT".equals(response)) {
                return i;
            }
        }
        return 0;
    }

    private int findHitY(MyScanner sc, PrintWriter out) {
        for (int i = 0; i <= 100; i++) {
            out.println(0 + " " + (i - OFFSET));
            out.flush();
            String response = sc.nextLine();
            if ("HIT".equals(response)) {
                return i;
            }
        }
        return 0;
    }

    private boolean checkCenter(MyScanner sc, PrintWriter out, int xHit, int yHit) {
        for (int i = -50; i <= 50; i++) {
            out.println(0 + " " + (yHit - 50));
            out.flush();
            String response = sc.nextLine();
            if ("CENTER".equals(response)) {
                return true;
            }
        }

        for (int i = -50; i <= 50; i++) {
            out.println(i + " " + (yHit - 51));
            out.flush();
            String response = sc.nextLine();
            if ("CENTER".equals(response)) {
                return true;
            }
        }

        for (int i = -50; i <= 50; i++) {
            out.println((xHit - 51) + " " + i);
            out.flush();
            String response = sc.nextLine();
            if ("CENTER".equals(response)) {
                return true;
            }
        }

        out.println((xHit - 50) + " " + 0);
        out.flush();
        String response = sc.nextLine();
        if ("CENTER".equals(response)) {
            return true;
        }

        out.println(0 + " " + (yHit - 50));
        out.flush();
        String response2 = sc.nextLine();
        if ("CENTER".equals(response2)) {
            return true;
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