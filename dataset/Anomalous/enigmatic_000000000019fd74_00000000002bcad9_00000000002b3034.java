import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        new Thread(null, Solution::solve, "1", 1 << 26).start();
    }

    static void solve() {
        FastReader fr = new FastReader();
        PrintWriter op = new PrintWriter(System.out);

        int t = fr.nextInt();
        for (int ts = 1; ts <= t; ++ts) {
            int n = fr.nextInt();
            String[] a = new String[n];
            int maxLength = 0;
            int maxIndex = -1;

            for (int i = 0; i < n; ++i) {
                a[i] = fr.next();
                if (a[i].length() > maxLength) {
                    maxLength = a[i].length();
                    maxIndex = i;
                }
            }

            boolean valid = true;
            for (int i = n - 1; i >= 0; --i) {
                if (i == maxIndex) continue;
                int j = maxLength - 1;
                for (int k = a[i].length() - 1; k >= 0; --k, --j) {
                    if (a[i].charAt(k) != a[maxIndex].charAt(j)) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) break;
            }

            op.print("Case #" + ts + ": ");
            if (valid) {
                op.println(a[maxIndex].substring(1));
            } else {
                op.println('*');
            }
        }

        op.flush();
        op.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}