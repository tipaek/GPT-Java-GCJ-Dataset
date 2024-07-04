import java.util.*;
import java.io.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    void solve() {
        int T=in.nextInt();
        for(int x=1; x<=T; x++) {
            int N=in.nextInt();
            int[][] M=new int[N][N];
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    M[i][j]=in.nextInt();
            int k=0, r=0, c=0;
            for(int i=0; i<N; i++)
                k+=M[i][i];
            for(int i=0; i<N; i++) {
                HashMap<Integer, Boolean> hmr=new HashMap<>();
                for(int j=0; j<N; j++)
                    if (hmr.get(M[i][j])!=null) {
                        r++;
                        break;
                    }
                    else hmr.put(M[i][j],true);

                HashMap<Integer, Boolean> hmc=new HashMap<>();
                for(int j=0; j<N; j++)
                    if (hmc.get(M[j][i])!=null) {
                        c++;
                        break;
                    }
                    else hmc.put(M[j][i],true);
            }
            System.out.println(String.format("Case #%d: %d %d %d", x, k, r, c));
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
