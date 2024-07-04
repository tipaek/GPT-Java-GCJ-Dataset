import java.util.*;
import java.io.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    void solve() {
        int T=in.nextInt();
        for(int t=1; t<=T; t++) {
            int n=10000;
            int u=in.nextInt();
            HashMap<Integer, HashSet> q = new HashMap<>();
            HashSet<Character> all = new HashSet<>();
            HashSet<Character> non_zero = new HashSet<>();
            for(int i=0; i<n; i++) {
                int a=in.nextInt();
                String s=in.next();
                HashSet<String> b=q.getOrDefault(a, new HashSet());
                b.add(s);
                q.put(a, b);
                for(int j=0; j<s.length(); j++)
                    all.add(s.charAt(j));
                non_zero.add(s.charAt(0));
            }

            String ans="";
            Character[] ls_all = new Character[all.size()];
            ls_all = all.toArray(ls_all);


            for(int i=0; i<ls_all.length; i++)
                if (!non_zero.contains(ls_all[i])) {
                    ans+=ls_all[i];
                    break;
                }

            HashSet<Character> used = new HashSet<>();
            for(int i=1; i<10; i++) {
                HashSet<String> c = q.get(i);

                for (Iterator<String> it = c.iterator(); it.hasNext(); ) {
                    Character f = it.next().charAt(0);
                    if (!used.contains(f)) {
                        ans+=f;
                        used.add(f);
                        break;
                    }
                }
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
