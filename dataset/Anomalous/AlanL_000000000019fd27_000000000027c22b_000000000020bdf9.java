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
            Integer[][] intervals = new Integer[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = readInt();
                intervals[i][1] = readInt();
            }
            System.out.print("Case #" + z + ": ");
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();
            int jeEnd = -1, jsStart = Integer.MAX_VALUE;
            int ceEnd = -1, csStart = Integer.MAX_VALUE;
            String currentPerson = "je";

            for (int i = 0; i < n; i++) {
                if (currentPerson.equals("je")) {
                    if (jeEnd <= intervals[i][0]) {
                        jeEnd = intervals[i][1];
                        jsStart = Math.min(jsStart, intervals[i][0]);
                        result.append("J");
                    } else if (jsStart >= intervals[i][1]) {
                        jsStart = intervals[i][0];
                        result.append("J");
                        jeEnd = jeEnd == -1 ? intervals[i][1] : jeEnd;
                    } else {
                        currentPerson = "ce";
                        i--;
                    }
                } else {
                    if (ceEnd <= intervals[i][0]) {
                        ceEnd = intervals[i][1];
                        csStart = Math.min(csStart, intervals[i][0]);
                        result.append("C");
                    } else if (csStart >= intervals[i][1]) {
                        csStart = intervals[i][0];
                        result.append("C");
                        ceEnd = ceEnd == -1 ? intervals[i][1] : ceEnd;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result.toString());
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