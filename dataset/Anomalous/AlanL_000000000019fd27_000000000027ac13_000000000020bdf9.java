import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int z = 1; z <= t; z++) {
            int n = readInt();
            Integer[][] arr = new Integer[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = readInt();
                arr[i][1] = readInt();
            }

            System.out.print("Case #" + z + ": ");
            boolean isPossible = true;
            StringBuilder ans = new StringBuilder();
            String currentAssignee = "J";
            int je = 0, js = Integer.MAX_VALUE, ce = 0, cs = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int start = arr[i][0];
                int end = arr[i][1];

                if (currentAssignee.equals("J")) {
                    if (je <= start) {
                        je = end;
                        if (js == Integer.MAX_VALUE) js = start;
                        ans.append("J");
                    } else if (js >= end) {
                        js = start;
                        ans.append("J");
                        if (je == 0) je = end;
                    } else {
                        currentAssignee = "C";
                        i--;
                        continue;
                    }
                } else {
                    if (ce <= start) {
                        ce = end;
                        if (cs == Integer.MAX_VALUE) cs = start;
                        ans.append("C");
                    } else if (cs >= end) {
                        cs = start;
                        ans.append("C");
                        if (ce == 0) ce = end;
                    } else {
                        currentAssignee = "J";
                        i--;
                        continue;
                    }
                }
            }

            if (ans.length() < n) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans.toString());
            }
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
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

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return input.readLine().trim();
    }
}