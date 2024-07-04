import java.io.*;
import java.util.StringTokenizer;

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

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            String currentWorker = "C";
            int ce = 0, cs = Integer.MAX_VALUE, je = 0, js = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (currentWorker.equals("J")) {
                    if (je <= intervals[i][0]) {
                        je = intervals[i][1];
                        if (js == Integer.MAX_VALUE) js = intervals[i][0];
                        result.append("J");
                    } else if (js >= intervals[i][1]) {
                        js = intervals[i][0];
                        result.append("J");
                        if (je == 0) je = intervals[i][1];
                    } else {
                        currentWorker = "C";
                        i--;
                        continue;
                    }
                } else {
                    if (ce <= intervals[i][0]) {
                        ce = intervals[i][1];
                        if (cs == Integer.MAX_VALUE) cs = intervals[i][0];
                        result.append("C");
                    } else if (cs >= intervals[i][1]) {
                        cs = intervals[i][0];
                        if (ce == 0) ce = intervals[i][1];
                        result.append("C");
                    } else {
                        currentWorker = "J";
                        i--;
                        continue;
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

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}