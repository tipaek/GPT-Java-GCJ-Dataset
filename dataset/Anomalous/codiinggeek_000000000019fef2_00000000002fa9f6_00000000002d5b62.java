import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            long x = reader.nextLong();
            long y = reader.nextLong();
            String result = determineMovement(x, y);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static String determineMovement(long x, long y) {
        long absSum = Math.abs(x) + Math.abs(y);

        if (absSum == 1) {
            if (x == 0 && y == 1) return "N";
            if (x == 0 && y == -1) return "S";
            if (x == 1 && y == 0) return "E";
            if (x == -1 && y == 0) return "W";
        } else if (absSum == 3) {
            String s1 = "", s2 = "";
            if (x >= 0 && y >= 0) {
                s1 = "N";
                s2 = "E";
            } else if (x <= 0 && y <= 0) {
                s1 = "S";
                s2 = "W";
            } else if (x <= 0 && y >= 0) {
                s1 = "N";
                s2 = "W";
            } else if (x >= 0 && y <= 0) {
                s1 = "S";
                s2 = "E";
            }

            x = Math.abs(x);
            y = Math.abs(y);

            if (x == 3 && y == 0) return s2 + s2;
            if (y == 3 && x == 0) return s1 + s1;
            if (x == 1 && y == 2) return s2 + s1;
            if (x == 2 && y == 1) return s1 + s2;
        }

        return "IMPOSSIBLE";
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
}