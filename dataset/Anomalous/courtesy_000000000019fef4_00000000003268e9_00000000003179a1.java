import java.io.*;
import java.util.*;

public class Solution {

    public static ScannerWrapper scanner = new ScannerWrapper();
    public static OutputWriter outputWriter = new OutputWriter();

    public static void main(String[] args) throws Exception {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int U = scanner.nextInt();
            Map<Character, Integer> frequencyMap = new HashMap<>();
            Set<Character> uniqueChars = new HashSet<>();

            for (int i = 0; i < 10000; i++) {
                String M = scanner.next();
                String R = scanner.next();

                frequencyMap.put(R.charAt(0), frequencyMap.getOrDefault(R.charAt(0), 0) + 1);
                for (char c : R.toCharArray()) {
                    uniqueChars.add(c);
                }
            }

            char[] answer = new char[10];
            for (int i = 1; i < 10; i++) {
                char maxChar = '1';
                int maxCount = -1;
                for (char currentChar : uniqueChars) {
                    int count = frequencyMap.getOrDefault(currentChar, -1);
                    if (count > maxCount) {
                        maxCount = count;
                        maxChar = currentChar;
                    }
                }
                answer[i] = maxChar;
                frequencyMap.put(maxChar, -1);
                uniqueChars.remove(maxChar);
            }
            answer[0] = uniqueChars.iterator().next();

            System.out.println("Case #" + testCase + ": " + new String(answer));
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class ScannerWrapper {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public ScannerWrapper() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer("");
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }
    }
}