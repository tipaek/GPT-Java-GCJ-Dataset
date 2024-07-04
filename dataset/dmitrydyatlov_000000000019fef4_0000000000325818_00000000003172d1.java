import java.io.*;
import java.util.*;

public class Solution {
    // TODO: do not forget
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    //    private static final String INPUT_FILE = "A-large.in";
    private static final String OUTPUT_FILE = "A-large.out";

    private void run(InputReader in, PrintWriter out) {
        int n = in.nextInt(), d = in.nextInt();
        Map<Long, Integer> m = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            Long a = Long.valueOf(in.nextLong());
            if (m.containsKey(a)) {
                m.put(a, m.get(a) + 1);
            } else {
                m.put(a, Integer.valueOf(1));
            }
        }
        if (d == 2) {
            for (Map.Entry<Long, Integer> en : m.entrySet()) {
                if (en.getValue().intValue() > 1) {
                    out.print(0);
                    return;
                }
            }
            out.print(1);
            return;
        }

        if (d == 3) {
            Set<Long> keys = m.keySet();
            boolean canInOne = false;
            for (Map.Entry<Long, Integer> en : m.entrySet()) {
                if (en.getValue().intValue() > 2) {
                    out.print(0);
                    return;
                }
                if (en.getValue().intValue() == 2) {
                    Long size2 = en.getKey();
                    for (Long l : keys) {
                        if (l.compareTo(size2) > 0) {
                            canInOne = true;
                            break;
                        }
                    }
                }
            }
            if (canInOne) {
                out.print(1);
                return;
            }
            for (Long l : keys) {
                if (keys.contains(Long.valueOf(l.longValue() * 2))) {
                    out.print(1);
                    return;
                }
            }
            out.print(2);
            return;
        }

        out.print(d - 1); // make WA
    }

    public static void main(String[] args) {
        InputReader in;
        PrintWriter out;
        try {
            if (READ_FROM_FILE == 1) {
                in = new InputReader(new FileInputStream(INPUT_FILE));
            } else {
                in = new InputReader(System.in);
            }
            if (WRITE_TO_FILE == 1) {
                out = new PrintWriter(OUTPUT_FILE);
            } else {
                out = new PrintWriter(System.out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        int cases = in.nextInt();
        for(int i = 1; i <= cases; ++i) {
            out.print("Case #" + i + ": ");
            solution.run(in, out);
            out.println();
        }

        out.flush();
        out.close();
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextCharacter() {
            return next().charAt(0);
        }
    }
}