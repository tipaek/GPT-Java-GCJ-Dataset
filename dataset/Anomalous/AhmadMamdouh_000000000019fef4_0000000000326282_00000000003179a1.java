import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

    static class Pair {
        int count;
        long max;

        public Pair(int count, long max) {
            this.count = count;
            this.max = max;
        }
    }

    static String[] generate() {
        long range = (long) Math.pow(10, 16);
        Random rand = new Random();
        String secret = "CODEJAMFUN";
        String[] result = new String[10000];

        for (int i = 0; i < 10000; i++) {
            long next = Math.abs(rand.nextLong()) % range;
            next = Math.abs(rand.nextLong()) % next;
            String s = String.valueOf(next);
            StringBuilder transformed = new StringBuilder();

            for (char c : s.toCharArray()) {
                transformed.append(secret.charAt(c - '0'));
            }

            result[i] = transformed.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int t = reader.nextInt();
        int testCase = 1;

        while (t-- > 0) {
            int u = reader.nextInt();
            long range = (long) Math.pow(10, u);
            int[] freq = new int[26];
            HashMap<String, Pair> map = new HashMap<>();
            int[] count = new int[26];

            for (int i = 0; i < 10000; i++) {
                long q = reader.nextLong();
                String s = reader.next();

                for (char c : s.toCharArray()) {
                    freq[c - 'A']++;
                }

                map.putIfAbsent(s, new Pair(0, range));
                Pair p = map.get(s);
                p.count++;
                p.max = Math.min(p.max, q);
                count[s.charAt(0) - 'A']++;
            }

            char[] solution = new char[10];
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0 && count[i] == 0) {
                    solution[0] = (char) ('A' + i);
                }
            }

            TreeMap<Integer, Character> sortedMap = new TreeMap<>();
            for (int i = 0; i < freq.length; i++) {
                if (count[i] > 0) {
                    sortedMap.put(count[i], (char) ('A' + i));
                }
            }

            int digit = 9;
            for (Entry<Integer, Character> entry : sortedMap.entrySet()) {
                if (entry.getValue() == solution[0]) {
                    continue;
                }
                solution[digit--] = entry.getValue();
            }

            System.out.printf("Case #%d: %s\n", testCase++, new String(solution));
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
                throw new RuntimeException(e);
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