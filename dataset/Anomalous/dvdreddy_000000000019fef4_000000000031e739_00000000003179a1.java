import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    
    public static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
            if (tokenizer != null && tokenizer.hasMoreTokens()) {
                throw new RuntimeException("Cannot read lines here");
            }
            try {
                String line = reader.readLine();
                return (line != null && line.endsWith("\n")) ? line.substring(0, line.length() - 1) : line;
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

    public static void solve(InputReader in, int caseNumber) {
        int u = in.nextInt();
        Set<Character> uniqueChars = new HashSet<>();
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            int x = in.nextInt();
            String d = in.next();
            if (uniqueChars.size() < 10) {
                for (char c : d.toCharArray()) {
                    uniqueChars.add(c);
                }
            }
            char firstChar = d.charAt(0);
            charCount.put(firstChar, charCount.getOrDefault(firstChar, 0) + 1);
        }

        uniqueChars.removeAll(charCount.keySet());
        Character firstUniqueChar = uniqueChars.iterator().next();
        Character[] sortedChars = charCount.keySet().toArray(new Character[0]);

        Arrays.sort(sortedChars, (o1, o2) -> charCount.get(o2) - charCount.get(o1));

        StringBuilder result = new StringBuilder();
        result.append(firstUniqueChar);
        for (int i = 0; i < 9; i++) {
            result.append(sortedChars[i]);
        }

        System.out.println("Case " + caseNumber + ": " + result.toString());
        System.out.flush();
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            solve(in, t);
        }
        System.exit(0);
    }
}