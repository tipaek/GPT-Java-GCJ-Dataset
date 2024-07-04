import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader() {
        }

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
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
        return (i % 14 == 0) ? 14 : i % 14;
    }

    public static void solve(InputReader in, int t) {
        int u = in.nextInt();
        Set<Character> uniqueChars = new HashSet<>();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            int x = in.nextInt();
            String d = in.next();

            if (uniqueChars.size() < 10) {
                for (char c : d.toCharArray()) {
                    uniqueChars.add(c);
                }
            }

            frequencyMap.put(d.charAt(0), frequencyMap.getOrDefault(d.charAt(0), 0) + 1);
        }

        uniqueChars.removeAll(frequencyMap.keySet());
        Character firstChar = uniqueChars.iterator().next();
        Character[] sortedChars = frequencyMap.keySet().toArray(new Character[0]);

        Arrays.sort(sortedChars, (o1, o2) -> frequencyMap.get(o2) - frequencyMap.get(o1));

        StringBuilder result = new StringBuilder();
        result.append(firstChar);

        for (int i = 0; i < 9; i++) {
            result.append(sortedChars[i]);
        }

        System.out.println("Case " + t + ": " + result.toString());
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            solve(in, t);
        }
    }
}