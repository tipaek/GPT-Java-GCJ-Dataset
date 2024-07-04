
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;


public class Solution {
    private final static FastReader in = new FastReader();
    private final static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        StringBuilder s = new StringBuilder();
        ArrayList<Pair<Integer, Integer>> arr;
        int cameron = 0, jamie = 0, n;
        Set<Integer> set;
        int key, value;
        boolean k = false;
        for (int i1 = 1; i1 <= t; i1++) {
            n = in.nextInt();
            arr = new ArrayList<>();

            for (int i2 = 0; i2 < n; i2++) {
                key = in.nextInt();
                value = in.nextInt();
                arr.add(new Pair<>(key, value));
            }
            Collections.sort(arr, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> integerIntegerPair, Pair<Integer, Integer> t1) {
                    return integerIntegerPair.getKey() - t1.getKey();
                }
            });

            for (int i2 = 0; i2 < n; i2++) {
                if (arr.get(i2).getKey() >= cameron) {
                    s.append('C');
                    cameron = arr.get(i2).getValue();
                } else if (arr.get(i2).getKey() >= jamie) {
                    s.append('J');
                    jamie = arr.get(i2).getValue();
                } else {
                    k = true;
                    break;
                }
            }
            if (k) {
                out.printf("Case #%d: IMPOSSIBLE \n", i1);
            } else {
                out.printf("Case #%d: %s \n", i1, s);
            }
            k = false;
            cameron = jamie = 0;
            s = new StringBuilder();
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