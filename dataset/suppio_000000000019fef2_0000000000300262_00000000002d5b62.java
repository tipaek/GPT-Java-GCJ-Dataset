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

    public static String solve(int x, int y) {
        int dx = Math.abs(x);
        int dy = Math.abs(y);

        if ((dx % 2) == 1 && (dy % 2) == 1 || ((dx % 2) == 0 && (dy % 2) == 0)) {
            return "IMPOSSIBLE";
        }

        String answer1;
        String answer2;

        if (dx % 2 == 1) {
            answer1 = jump(x - 1, y, 2, "E");
            answer2 = jump(x + 1, y, 2, "W");
        } else {
            answer1 = jump(x, y - 1, 2, "N");
            answer2 = jump(x, y + 1, 2, "S");
        }

        if (answer1 == null && answer2 == null) {
            return "IMPOSSIBLE";
        } else if (answer1 == null) {
            return answer2;
        } else if (answer2 == null) {
            return answer1;
        } else {
            return answer1.length() < answer2.length() ? answer1 : answer2;
        }
    }

    public static String jump(int x, int y, int d, String sequence) {
        if (x == 0 && y == 0) {
            return sequence;
        }

        String jumpX = null;
        String jumpY = null;

        if ((Math.abs(x) - d) >= 0) {
            jumpX = x > 0 ? jump(x - d, y, d * 2, sequence + "E") : jump(x + d, y, d * 2, sequence + "W");
        }

        if ((Math.abs(y) - d) >= 0) {
            jumpY = y > 0 ? jump(x, y - d, d * 2, sequence + "N") : jump(x, y + d, d * 2, sequence + "S");
        }

        if (jumpX == null && jumpY == null) {
            return null;
        } else if (jumpX == null) {
            return jumpY;
        } else if (jumpY == null) {
            return jumpX;
        } else {
            return jumpX.length() < jumpY.length() ? jumpX : jumpY;
        }
    }

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            out.printf("Case #%d: %s%n", i, solve(x, y));
        }
    }
}
