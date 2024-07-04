import java.io.*;
import java.util.*;

public class Solution {
    // TODO: do not forget
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    //    private static final String INPUT_FILE = "A-large.in";
    private static final String OUTPUT_FILE = "A-large.out";

    class Pair {
        Character c;
        Long cnt;
        Pair (Character cc, Long cntt) {
            this.c = cc;
            this.cnt = cntt;
        }
    }

    private void run(InputReader in, PrintWriter out) {
        int u = in.nextInt();
        long cnt[] = new long[26];
        for (int i = 0; i < 10000; ++i) {
            long q = in.nextLong();
            String r = in.next();
            for (int j = 0; j < r.length(); ++j) {
                char c = r.charAt(j);
                cnt[c - 'A']++;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return (int)(o2.cnt.longValue() - o1.cnt.longValue());
                    }
                }
        )
                ;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                pq.add(new Pair(Character.valueOf((char)('A' + i)), Long.valueOf(cnt[i])));
            }
        }
        String s = "";
        while (pq.size() > 0) {
            s += pq.poll().c;
        }
        out.print(s.substring(9));
        out.print(s.substring(0, 9));
        //TPFOXLUSHB
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