import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int numPatterns = scanner.nextInt();
            String[] patterns = new String[numPatterns];
            for (int i = 0; i < numPatterns; i++) {
                patterns[i] = scanner.next();
            }

            boolean isValid = true;
            char[] result = new char[20000];
            Arrays.fill(result, '?');
            int index = 0;

            for (String pattern : patterns) {
                String[] segments = splitPattern(pattern);

                if (segments[0].length() > 0) {
                    for (int j = 0; j < segments[0].length(); j++) {
                        if (result[j] != '?' && segments[0].charAt(j) != result[j]) {
                            isValid = false;
                            break;
                        }
                        result[j] = segments[0].charAt(j);
                    }
                    index = Math.max(segments[0].length(), index);
                }

                if (!isValid) break;

                if (segments[segments.length - 1].length() > 0) {
                    String lastSegment = segments[segments.length - 1];
                    for (int j = 0; j < lastSegment.length(); j++) {
                        if (result[result.length - 1 - j] != '?' && lastSegment.charAt(lastSegment.length() - 1 - j) != result[result.length - 1 - j]) {
                            isValid = false;
                            break;
                        }
                        result[result.length - 1 - j] = lastSegment.charAt(lastSegment.length() - 1 - j);
                    }
                }

                if (!isValid) break;

                for (int i = 1; i < segments.length - 1; i++) {
                    index++;
                    String segment = segments[i];
                    for (int j = 0; j < segment.length(); j++) {
                        result[index++] = segment.charAt(j);
                    }
                }
            }

            output.append("Case #").append(t + 1).append(": ");
            if (!isValid) {
                output.append("*\n");
            } else {
                for (char c : result) {
                    if (c != '?') {
                        output.append(c);
                    }
                }
                output.append("\n");
            }
        }

        System.out.println(output);
    }

    public static String[] splitPattern(String pattern) {
        ArrayList<String> segments = new ArrayList<>();
        int i = 0;

        while (i < pattern.length()) {
            int prev = i;
            int j = i;
            while (j < pattern.length() && pattern.charAt(j) != '*') {
                j++;
            }
            segments.add(pattern.substring(i, j));
            i = j;
            if (i == prev) {
                i = prev + 1;
            }
        }

        return segments.toArray(new String[0]);
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buffer[currentChar++];
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
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

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}