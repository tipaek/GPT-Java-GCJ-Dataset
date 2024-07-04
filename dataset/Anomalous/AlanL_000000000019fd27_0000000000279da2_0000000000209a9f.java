import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int z = 1; z <= t; z++) {
            String[] line = readLine().split("");
            int cur = 0;
            System.out.print("Case #" + z + ": ");
            for (String s : line) {
                int val = Integer.parseInt(s);
                if (cur < val) {
                    for (int j = 0; j < val - cur; j++) {
                        System.out.print("(");
                    }
                } else {
                    for (int j = 0; j < cur - val; j++) {
                        System.out.print(")");
                    }
                }
                System.out.print(val);
                cur = val;
            }
            for (int i = 0; i < cur; i++) {
                System.out.print(")");
            }
            System.out.println();
        }
    }

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    private static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private static char readChar() throws IOException {
        return next().charAt(0);
    }

    private static String readLine() throws IOException {
        return input.readLine().trim();
    }
}