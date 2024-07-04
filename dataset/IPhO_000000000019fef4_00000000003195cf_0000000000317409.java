import java.util.*;
import java.io.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    void solve() {
        int T=in.nextInt();
        for(int t=1; t<=T; t++) {
            int x=in.nextInt(), y=in.nextInt();
            String s=in.next(), ans="";
            if (x==0 && y==0) {
                ans="0";
            }
            else {
                for (int i = 0; i < s.length(); i++) {
                    switch (s.charAt(i)) {
                        case 'S': y--; break;
                        case 'N': y++; break;
                        case 'E': x++; break;
                        case 'W': x--; break;
                    }
                    if (Math.abs(x)+Math.abs(y)<=i+1) {
                        ans = (i + 1) + "";
                        break;
                    }
                }
                if (ans.equals(""))
                    ans="IMPOSSIBLE";
            }

            System.out.println(String.format("Case #%d: %s", t, ans));
        }

    }

    void run() {
        try {
            in = new FastScanner(new File("CF.in"));
            out = new PrintWriter(new File("CF.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
    }

    public static void main(String[] args) {
        new Solution().runIO();
    }

}
