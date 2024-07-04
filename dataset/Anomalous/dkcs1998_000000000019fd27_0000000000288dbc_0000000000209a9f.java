import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
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

    static class Var {
        int a, b;

        Var(int x, int y) {
            a = x;
            b = y;
        }
    }

    static class Comp implements Comparator<Var> {
        @Override
        public int compare(Var o1, Var o2) {
            return Integer.compare(o2.b, o1.b);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        for (int kt = 1; kt <= t; kt++) {
            String str = sc.nextLine();
            char[] s = str.toCharArray();
            int n = s.length;
            StringBuilder res = new StringBuilder();
            int op = 0;

            for (int i = 0; i < n; i++) {
                int j = i;

                while (j < n && s[i] == s[j]) {
                    j++;
                }

                int m = s[i] - '0';

                if (m > op) {
                    for (int k = 0; k < m - op; k++) {
                        res.append("(");
                    }
                } else {
                    for (int k = 0; k < op - m; k++) {
                        res.append(")");
                    }
                }

                op = m;

                for (int k = 0; k < j - i; k++) {
                    res.append(s[i]);
                }

                i = j - 1;
            }

            for (int k = 0; k < op; k++) {
                res.append(")");
            }

            System.out.println(res);
        }
    }
}