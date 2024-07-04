import java.util.*;
import java.io.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    void solve() {
        int T=in.nextInt();
        for(int t=1; t<=T; t++) {
            int n=in.nextInt(), d=in.nextInt(), ans;
            long[]a=new long[n];
            for(int i=0; i<n; i++) {
                a[i]=in.nextLong();
            }
            Arrays.sort(a);
            int c=1, max=0;
            for(int i=1; i<n; i++) {
                if (a[i]==a[i-1]) {
                    c++;
                }
                else {
                    max=Math.max(max, c);
                    c=1;
                }
            }
            max=Math.max(max, c);
            if (max>=d) {
                ans=0;
            }
            else {
                if (d==2) {
                    ans=1;
                }
                else {
                    boolean f=false;
                    for(int i=0; i<n-1; i++) {
                        for(int j=i+1; j<n; j++) {
                            if (a[i]*2==a[j]) {
                                f = true;
                                break;
                            }
                        }
                        if (f) break;
                    }
                    if (f) {
                        ans=1;
                    }
                    else {
                        ans=2;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d", t, ans));
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
