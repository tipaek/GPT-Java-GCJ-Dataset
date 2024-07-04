import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
        int T = readInt();
        int B = readInt();
        StringBuilder array = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            array.setLength(0);

            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                System.out.flush();
                array.append(readInt());
            }

            System.out.println(array.toString());
            System.out.flush();

            String result = nextLine();
            if ("N".equals(result)) {
                break;
            }
        }
    }

    private static void exitImmediately() {
        pw.close();
        System.exit(0);
    }

    private static long readLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextLine() throws IOException {
        String s = br.readLine();
        if (s == null) {
            exitImmediately();
        }
        st = null;
        return s;
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
        }
        return st.nextToken();
    }
}