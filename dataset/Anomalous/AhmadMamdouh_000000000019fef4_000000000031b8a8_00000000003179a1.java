import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Solution {

    static class Pair {
        int count;
        long max;

        public Pair(int count, long max) {
            this.count = count;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        int testCaseNumber = 1;

        while (testCases-- > 0) {
            int u = reader.nextInt();
            long range = (long) Math.pow(10, u);
            HashMap<String, Pair> map = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                long q = reader.nextLong();
                String s = reader.next();

                map.putIfAbsent(s, new Pair(0, range));
                Pair pair = map.get(s);
                pair.count++;
                pair.max = Math.min(q, pair.max);
            }

            char[] solution = new char[10];
            boolean[] taken = new boolean[26];

            for (int d = 1; d < 10; d++) {
                for (Entry<String, Pair> entry : map.entrySet()) {
                    String s = entry.getKey();
                    Pair pair = entry.getValue();

                    if (pair.max == d && !taken[s.charAt(0) - 'A']) {
                        taken[s.charAt(0) - 'A'] = true;
                        solution[d] = s.charAt(0);
                    }
                }
            }

            for (Entry<String, Pair> entry : map.entrySet()) {
                String s = entry.getKey();
                Pair pair = entry.getValue();

                if (pair.max == 10 && !taken[s.charAt(1) - 'A']) {
                    taken[s.charAt(1) - 'A'] = true;
                    solution[0] = s.charAt(1);
                }
            }

            System.out.printf("Case #%d: %s\n", testCaseNumber++, new String(solution));
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
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
    }
}