import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(FastReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int caseNum = 1; caseNum <= t; caseNum++) {
                String s = in.nextLine();
                s = '0' + s + '0';
                StringBuilder sb = new StringBuilder();
                char[] st = s.toCharArray();
                int n = s.length();
                
                for (int i = 0; i < n - 1; i++) {
                    int diff = st[i + 1] - st[i];
                    sb.append(st[i]);
                    if (diff > 0) {
                        for (int j = 0; j < diff; j++) {
                            sb.append('(');
                        }
                    } else {
                        for (int j = 0; j < -diff; j++) {
                            sb.append(')');
                        }
                    }
                }
                
                out.println("Case #" + caseNum + ": " + sb.substring(1));
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}