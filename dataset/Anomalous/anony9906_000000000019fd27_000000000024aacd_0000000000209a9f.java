import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CodeJam solver = new CodeJam();
        solver.solve(1, in, out);
        out.close();
    }

    static class CodeJam {
        public void solve(int testNumber, FastReader sc, PrintWriter out) {
            int T = sc.nextInt();
            for (int t = 1; t <= T; ++t) {
                char[] s = sc.next().toCharArray();
                int n = s.length;
                int j = 0, openParens = 0;
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; ++i) {
                    while (j < n && s[i] == s[j]) ++j;
                    int len = j - i;
                    int req = s[i] - '0';
                    if (req > openParens) {
                        while (openParens-- > 0) ans.append(')');
                        openParens = req;
                        while (req-- > 0) ans.append('(');
                        while (len-- > 0) ans.append(s[i]);
                    } else {
                        int diff = openParens - req;
                        openParens -= diff;
                        while (diff-- > 0) ans.append(')');
                        while (len-- > 0) ans.append(s[i]);
                    }
                    i = j - 1;
                }
                while (openParens-- > 0) ans.append(')');
                out.println("Case #" + t + ": " + ans);
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}