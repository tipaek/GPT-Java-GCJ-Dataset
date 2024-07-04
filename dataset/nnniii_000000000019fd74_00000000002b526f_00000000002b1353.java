import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    private static void solve() throws IOException {
        int N = nextInt();
        for (int i = 1; i <= N; i++) {
            writer.write(String.format("%d 1\n", i));
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