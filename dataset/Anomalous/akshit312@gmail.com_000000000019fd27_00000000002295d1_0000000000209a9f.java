import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    void pre() throws Exception {}

    void solve(int testCase) throws Exception {
        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            String s = n();
            int cur = 0;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int z = s.charAt(i) - '0';
                while (cur > z) {
                    ans.append(')');
                    cur--;
                }
                while (cur < z) {
                    ans.append('(');
                    cur++;
                }
                ans.append(s.charAt(i));
            }
            while (cur != 0) {
                ans.append(')');
                cur--;
            }
            pn("Case #" + (ii + 1) + ": " + ans);
        }
    }

    static boolean multipleTC = false, memory = false;
    FastReader in;
    PrintWriter out;

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = (multipleTC) ? ni() : 1;
        pre();
        for (int t = 1; t <= T; t++) solve(t);
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        if (memory) {
            new Thread(null, () -> {
                try {
                    new Solution().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "1", 1 << 28).start();
        } else {
            new Solution().run();
        }
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    void nd(Object o) {
        out.println(o);
    }

    void pni(Object o) {
        out.println(o);
        out.flush();
    }

    String n() throws Exception {
        return in.next();
    }

    String nln() throws Exception {
        return in.nextLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

    long nl() throws Exception {
        return Long.parseLong(in.next());
    }

    double nd() throws Exception {
        return Double.parseDouble(in.next());
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}