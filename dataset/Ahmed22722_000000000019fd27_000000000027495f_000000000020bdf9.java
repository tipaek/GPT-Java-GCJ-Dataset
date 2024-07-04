

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Solution {
    private final static FastReader in = new FastReader();
    private final static PrintWriter out = new PrintWriter(System.out);

    public static class pa implements Comparable<pa> {
        int key, value;

        public pa(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Solution.pa pa) {
            return this.key - pa.key;

        }
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        char[] s;
        ArrayList<pa> arr;
        int cameron = 0, jamie = 0, n;
        int key, value;
        boolean k = false;
        StringBuilder stringBuilder;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i1 = 1; i1 <= t; i1++) {
            n = in.nextInt();
            arr = new ArrayList<>();
            s = new char[n];
            for (int i2 = 0; i2 < n; i2++) {
                key = in.nextInt();
                value = in.nextInt();
                map.put(key + "" + value, i2);
                arr.add(new pa(key, value));
            }
            Collections.sort(arr);
            for (int i2 = 0; i2 < n; i2++) {
                key = arr.get(i2).getKey();
                value = arr.get(i2).getValue();
                if (key >= cameron) {
                    s[map.get(key + "" + value)] = 'C';
                    cameron = value;
                } else if (key >= jamie) {
                    s[map.get(key + "" + value)] = 'J';
                    jamie = value;
                } else {
                    k = true;
                }
            }
            if (k) {
                out.printf("Case #%d: IMPOSSIBLE\n", i1);
            } else {
                stringBuilder = new StringBuilder();
                for (char ch : s) {
                    stringBuilder.append(ch);
                }
                out.printf("Case #%d: %s\n", i1, stringBuilder.toString());
            }
            k = false;
            cameron = jamie = 0;

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