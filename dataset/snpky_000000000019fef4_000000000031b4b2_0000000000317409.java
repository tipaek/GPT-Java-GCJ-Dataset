import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public void solve(InputReader in, PrintWriter out) {
        int x = in.nextInt(), y = in.nextInt();
        char[] a = in.next().toCharArray();
        if (x == 0 && y == 0) {
            out.println("0");
            return;
        }
        int n = a.length;
        List<int[]> pos = new ArrayList<>();
        pos.add(new int[]{x,y});
        int res = n+1;
        boolean impossible = true;
        for (int i = 0; i < a.length; i++) {
            int[] b = next(x,y, a[i]);
            if ((i+1) >= Math.abs(b[0])+Math.abs(b[1])) {
                impossible = false;
                res = Math.min(res, i+1);
            }
            x = b[0];
            y = b[1];
        }
        if (impossible) {
            out.println("IMPOSSIBLE");
        } else {
            out.println(res);
        }
    }

    public int[] next(int x, int y, char ch) {
        if (ch == 'S') {
            return new int[]{x, y-1};
        } else if (ch == 'N') {
            return new int[]{x, y+1};
        } else if (ch == 'E') {
            return new int[]{x+1, y};
        } else {
            return new int[]{x-1, y};
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution obj = new Solution();
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            obj.solve(in, out);
        }
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

    }
}
