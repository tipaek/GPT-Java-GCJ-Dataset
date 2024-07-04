import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    private static void solve() throws IOException {
        int N = nextInt();
        int r = 1;
        int k = 1;
        for (int i = 1; i <= N; i++) {
            writer.write(String.format("%d %d\n", r, k));

            if (r % 2 == 1) {
                if (k == 1) r++;
                else k--;
            } else if (k == r) {
                r++;
                k++;
            } else {
                k++;
            }

            if (i % 500000000 == 0) {
                writer.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            writer.write(String.format("Case #%d:\n", t));
            solve();
            writer.flush();
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    static BufferedReader reader;
    static BufferedWriter writer;

    static StringTokenizer st;

    private static String next() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(reader.readLine());
        }

        return st.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}