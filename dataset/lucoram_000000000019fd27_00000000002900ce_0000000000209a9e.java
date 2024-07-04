import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static PrintWriter pw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // int qq = 1;
        // int qq = Integer.MAX_VALUE;
        int qq = readInt();
        for (int casenum = 1; casenum <= qq; casenum++) {
            int a = readInt();
            int b = readInt();
            int n = readInt();
            while (a <= b) {
                int mid = (a + b + 1) / 2;
                System.out.println(mid);
                System.out.flush();
                String ret = nextLine();
                if (ret.equals("CORRECT")) {
                    break;
                }
                if (ret.equals("TOO_SMALL")) {
                    a = mid + 1;
                } else {
                    b = mid - 1;
                }
            }
        }
        pw.close();
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
