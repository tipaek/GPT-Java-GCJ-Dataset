// package code.gcj_20.r1c;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Solution {
    public static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        // used for proxying stuff from clojure
        public InputReader() {
        }

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            if (tokenizer.hasMoreTokens()) {
                throw new RuntimeException("Cannot read lines here");
            }
            try {
                String sx = reader.readLine();
                return sx.endsWith("\n") ?
                        sx.substring(0, sx.length() - 1) : sx;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            int ret = Integer.parseInt(next());
            if (ret == -1) System.exit(0);
            return ret;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }


    private static int toStuffBox(int i) {
        if (i % 14 == 0) {
            return 14;
        } else {
            return i % 14;
        }
    }

    public static void solve(InputReader in, int t) {
        int u = in.nextInt();
        Set<Character> st  = new HashSet<>();
        Map<Character, Integer> cnts = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int x = in.nextInt();
            String d = in.next();
            if (st.size() < 10) {
                for (char c : d.toCharArray()) {
                    st.add(c);
                }
            }
            int vx = cnts.getOrDefault(d.charAt(0), 0);
            cnts.put(d.charAt(0), vx + 1);
        }
        st.removeAll(cnts.keySet());
        Character zx = st.iterator().next();
        Character[] cx = cnts.keySet().toArray(new Character[0]);
        Arrays.sort(cx, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (cnts.get(o1) > cnts.get(o2)) {
                    return -1;
                } else  {
                    return 1;
                }
            }
        });

        System.out.println("BCCC" + cnts.toString() + " NNN " + zx);

        String res = "" + zx;

        for (int i = 0; i < 9; i++) {
            res += cx[i];
        }

        System.out.println("Case " + t + ": " + res);
        System.out.flush();
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int T = in.nextInt();

        for(int t = 1; t <= T; t++) {
            solve(in, t);
        }
        System.exit(0);
    }
}
