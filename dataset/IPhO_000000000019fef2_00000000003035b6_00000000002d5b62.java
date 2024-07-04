import java.util.*;
import java.io.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    void solve() {
        int T=in.nextInt();
        for(int t=1; t<=T; t++) {
            int x=in.nextInt(), y=in.nextInt();
            System.out.print(String.format("Case #%d: ", t));
            if (!dfs(x, y, ""))
                System.out.println("IMPOSSIBLE");
        }


    }

    boolean dfs(int x, int y, String ans) {
        if (x==0 && y==0) {
            System.out.println(ans);
            return true;
        }
        int mod = Math.abs(x)%2 + Math.abs(y)%2;
        if (mod==2 || mod==0)
            return false;

        if (Math.abs(x) + Math.abs(y) == 1) {
            if (Math.abs(x) % 2 == 1) {
                if (x == 1)
                    return dfs(0, 0, new String(ans + "E"));
                else
                    return dfs(0, 0, new String(ans + "W"));
            }
            else {
                if (y==1)
                    return dfs(0, 0, new String(ans + "N"));
                else
                    return dfs(0, 0, new String(ans + "S"));
            }
        }

        if (Math.abs(x)%2==1) {
            if (dfs((x + 1) / 2, y / 2, new String(ans + "W")))
                return true;
            if (dfs((x - 1) / 2, y / 2, new String(ans + "E")))
                return true;
        }
        else {
            if (dfs(x / 2, (y + 1) / 2, new String(ans + "S")))
                return true;
            if (dfs(x / 2, (y - 1) / 2, new String(ans + "N")))
                return true;
        }
        return false;
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
