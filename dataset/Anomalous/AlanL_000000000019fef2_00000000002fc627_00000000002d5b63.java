import java.util.*;
import java.io.*;

public class Solution {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        int a = readInt();
        int b = readInt();

        for (int z = 1; z <= t; z++) {
            int curxStart = -1000000000 + a;
            int curyStart = -1000000000 + b;
            int curxEnd = 1000000000 - a;
            int curyEnd = 1000000000 - b;

            outerLoop:
            for (int i = curxStart; i <= curxEnd; i++) {
                for (int j = curyStart; j <= curyEnd; j++) {
                    System.out.println(i + " " + j);
                    String response = readLine();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    }
                }
            }
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