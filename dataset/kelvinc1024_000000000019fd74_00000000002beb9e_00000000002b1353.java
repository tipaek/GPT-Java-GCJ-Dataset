import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void solve() {
        int n = scan.nextInt();
        int level = 0;
        while ((1 << (level + 1)) <= n) {
            level++;
        }
        boolean fromBack = true;
        while (n != 0) {
            n -= 1 << level;
            if (fromBack) {
                for (int i = level; i >= 0; i--) {
                    out.println((level + 1) + " " + (i + 1));
                }
            } else {
                for (int i = 0; i <= level; i++) {
                    out.println((level + 1) + " " + (i + 1));
                }
            }
            fromBack = !fromBack;
            if (n == 0) break;

            int nextLevel = 0;
            while ((1 << (nextLevel + 1)) <= n) {
                nextLevel++;
            }
            for (int i = level - 1; i > nextLevel; i--) {
                if (fromBack) {
                    out.println((i + 1) + " " + (level + 1));
                } else {
                    out.println((i + 1) + " " + 1);
                }
                n--;
                if (n == 0) break;
                int temp = 0;
                while ((1 << (temp + 1)) <= n) {
                    temp++;
                }
                nextLevel = temp;
            }
            level = nextLevel;
        }
    }

    public static void main(String[] args) throws Exception {
        scan = new MyScanner();
//        out = new PrintWriter(new BufferedOutputStream(System.out));
        out = System.out;

        // your code
        int t = scan.nextInt();
        for (int ttc = 1; ttc <= t; ttc++) {
            out.println("Case #" + ttc + ": ");
            solve();
        }

        out.close();
    }

    static PrintStream out;
    //-----------PrintWriter for faster output---------------------------------
//    public static PrintWriter out;
    public static MyScanner scan;

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
    //--------------------------------------------------------

}