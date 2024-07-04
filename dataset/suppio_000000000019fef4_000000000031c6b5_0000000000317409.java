import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private static class FastReader {
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

    public static void solve(int t, PrintWriter out, int x, int y, String m) {
        int x1 = 0;
        int y1 = 0;
        int x2 = x;
        int y2 = y;

        int minutes = 0;
        // out.printf("START: x1=%d, y1=%d, x2=%d, y2=%d%n", x1, y1, x2, y2);
        for (int i = 0; i < m.length(); i++) {
            if (x1 == x2 && y1 == y2) {
                break;
            }

            switch (m.charAt(i)) {
                case 'N':
                    y2++;
                    break;
                case 'S':
                    y2--;
                    break;
                case 'E':
                    x2++;
                    break;
                case 'W':
                    x2--;
                    break;
            }

            if (x1 < x2) {
                x1++;
            } else {
                if (y1 > y2) {
                    y1--;
                } else if (y1 < y2) {
                    y1++;
                }
            }

            minutes++;
            // out.printf("MOVES: x1=%d, y1=%d, x2=%d, y2=%d%n", x1, y1, x2, y2);
        }

        // out.printf("FINAL: x1=%d, y1=%d, x2=%d, y2=%d%n", x1, y1, x2, y2);

        if (x1 == x2 && y1 == y2) {
            out.printf("Case #%d: %d%n", t, minutes);
        } else {
            out.printf("Case #%d: IMPOSSIBLE%n", t);
        }
    }

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();

            solve(i, out, x, y, m);
        }
    }
}
