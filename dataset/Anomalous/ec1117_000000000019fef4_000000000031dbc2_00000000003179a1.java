import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Autocompletion solver = new Autocompletion();
        solver.solve(1, in, out);
        out.close();
    }

    static class Autocompletion {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int z = 0; z < t; z++) {
                int u = in.nextInt();
                Set<Character> seen = new HashSet<>();
                Map<Character, Integer> rank = new HashMap<>();
                for (int i = 0; i < 10000; i++) {
                    long q = in.nextLong();
                    String r = in.next();
                    for (char c : r.toCharArray()) {
                        seen.add(c);
                    }
                    if (q == -1) {
                        for (char c : r.toCharArray()) {
                            rank.putIfAbsent(c, 9);
                        }
                    } else {
                        if (digits(q) == r.length()) {
                            char firstChar = r.charAt(0);
                            int firstDigit = Integer.parseInt(Long.toString(q).substring(0, 1));
                            rank.put(firstChar, Math.min(rank.getOrDefault(firstChar, firstDigit), firstDigit));
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < 10; i++) {
                    for (Map.Entry<Character, Integer> entry : rank.entrySet()) {
                        if (entry.getValue() == i) {
                            seen.remove(entry.getKey());
                            sb.append(entry.getKey());
                        }
                    }
                }
                String result = seen.iterator().next() + sb.toString();
                out.println("Case #" + (z + 1) + ": " + result);
            }
        }

        private int digits(long q) {
            return (int) Math.log10(q) + 1;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}