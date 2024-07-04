
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Solution {
    private final static FastReader in = new FastReader();
    private final static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        StringBuilder s = new StringBuilder();
        char current[];
        int val;
        int valueOfP = 0, valueOfDiff;
        for (int i1 = 1; i1 <= t; i1++) {
            current = in.next().toCharArray();
            for (int i2 = 0; i2 < current.length; i2++) {
                val = (current[i2] - '0');
                if (valueOfP > val) {
                    valueOfDiff = valueOfP - val;
                    for (int i3 = 0; i3 < valueOfDiff; i3++) {
                        s.append(')');
                    }
                    valueOfP -= valueOfDiff;
                } else if (valueOfP < val) {
                    valueOfDiff = val - valueOfP;
                    for (int i3 = 0; i3 < valueOfDiff; i3++) {
                        s.append('(');
                    }
                    valueOfP += valueOfDiff;
                }
                s.append(current[i2]);
                if (i2 == current.length - 1) {
                    for (int i3 = 0; i3 < valueOfP; i3++) {
                        s.append(')');
                    }
                }
            }
            out.printf("Case #%d: %s \n", i1, s);
            s = new StringBuilder();
            valueOfP = 0;
        }
        out.flush();
    }

    private static final class FastReader {
        private static BufferedReader BF;
        private static StringTokenizer ST;

        public FastReader() {
            BF = new BufferedReader(new InputStreamReader(System.in));
            ST = null;
        }

        public final String next() {
            while (ST == null || !ST.hasMoreTokens()) {
                try {
                    ST = new StringTokenizer(BF.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return ST.nextToken();
        }

        final int nextInt() {
            return Integer.parseInt(next());
        }

    }


}