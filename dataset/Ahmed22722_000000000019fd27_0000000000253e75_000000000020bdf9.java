
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
        TreeMap<Integer, Integer> map;
        int cameron = 0, jamie = 0, n;
        Set<Integer> set;
        boolean k = false;
        for (int i1 = 1; i1 <= t; i1++) {
            n = in.nextInt();
            map = new TreeMap<>();

            for (int i2 = 0; i2 < n; i2++) {
                map.put(in.nextInt(), in.nextInt());
            }

            set = map.keySet();
            for (int start : set) {
                if (start >= cameron) {
                    s.append('C');
                    cameron = map.get(start);
                } else if (start >= jamie) {
                    s.append('J');
                    cameron = map.get(start);
                } else {
                    k = true;
                }
            }
            if (k) {
                out.printf("Case #%d: IMPOSSIBLE \n", i1);
            } else {
                out.printf("Case #%d: %s \n", i1, s);
            }
            k = false;
            cameron = jamie = 0;
            s=new StringBuilder();
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