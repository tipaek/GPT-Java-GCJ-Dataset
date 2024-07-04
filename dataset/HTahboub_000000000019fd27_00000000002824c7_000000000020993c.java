import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static void solve() throws IOException {
        int t = readInt();
        for (int p = 1; p <= t; ++p) {
            var n = readInt();
            HashSet[] arr = new HashSet[n];
            int trace = 0;
            int c = 0;
            int r = 0;
            HashSet<Integer> curr;
            for (int i = 0; i < n; ++i) {
                curr = new HashSet<>();
                for (int j = 0; j < n; ++j) {
                    int a = readInt();
                    if (i == j) trace += a;

                    curr.add(a);

                    if (arr[j] == null) arr[j] = new HashSet<Integer>();
                    arr[j].add(a);
                }
                if (curr.size() < n) ++c;
            }
            for (var i : arr)
                if (i.size() < n) ++r;
            System.out.println("Case #" + p + ": " + trace + " " + c + " " + r);
        }
    }

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
