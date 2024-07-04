import java.io.*;
import java.util.*;

public class Solution {
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "A-large.out";

    private static class Pair {
        Character character;
        Long count;

        Pair(Character character, Long count) {
            this.character = character;
            this.count = count;
        }
    }

    private void process(InputReader in, PrintWriter out) {
        int u = in.nextInt();
        long[] counts = new long[26];
        
        for (int i = 0; i < 10000; ++i) {
            long q = in.nextLong();
            String response = in.next();
            for (int j = 0; j < response.length(); ++j) {
                char c = response.charAt(j);
                counts[c - 'A']++;
            }
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Long.compare(o2.count, o1.count);
            }
        });

        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] > 0) {
                priorityQueue.add(new Pair((char) ('A' + i), counts[i]));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            result.append(priorityQueue.poll().character);
        }

        out.print(result.substring(9));
        out.print(result.substring(0, 9));
    }

    public static void main(String[] args) {
        InputReader in;
        PrintWriter out;
        try {
            in = READ_FROM_FILE == 1 ? new InputReader(new FileInputStream(INPUT_FILE)) : new InputReader(System.in);
            out = WRITE_TO_FILE == 1 ? new PrintWriter(OUTPUT_FILE) : new PrintWriter(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            out.print("Case #" + i + ": ");
            solution.process(in, out);
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