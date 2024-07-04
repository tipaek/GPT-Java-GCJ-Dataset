import java.io.*;
import java.util.*;

public class Solution {
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "A-large.out";

    private static class Pair implements Comparable<Pair> {
        private final Character c;
        private final Long cnt;

        Pair(Character c, Long cnt) {
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair other) {
            return other.cnt.compareTo(this.cnt);
        }
    }

    private void run(InputReader in, PrintWriter out) {
        int u = in.nextInt();
        long[] cnt = new long[26];

        for (int i = 0; i < 10000; i++) {
            in.nextLong();
            String r = in.next();
            for (char c : r.toCharArray()) {
                cnt[c - 'A']++;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                pq.add(new Pair((char) ('A' + i), cnt[i]));
            }
        }

        StringBuilder s = new StringBuilder();
        while (!pq.isEmpty()) {
            s.append(pq.poll().c);
        }

        if (u > 2) {
            out.print(s);
        } else {
            out.print(s.substring(9)).append(s.substring(0, 9));
        }
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
        for (int i = 1; i <= cases; i++) {
            out.print("Case #" + i + ": ");
            solution.run(in, out);
            out.println();
        }

        out.flush();
        out.close();
    }

    private static class InputReader {
        private final BufferedReader reader;
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
    }
}