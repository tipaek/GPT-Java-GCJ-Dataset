import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            String[] patterns = new String[N];
            for (int i = 0; i < N; i++) {
                patterns[i] = in.next();
            }

            boolean isValid = true;
            char[] result = new char[9999];
            Arrays.fill(result, '?');

            int index = 0;

            for (String pattern : patterns) {
                String[] parts = splitPattern(pattern);

                if (parts[0].length() > 0) {
                    for (int j = 0; j < parts[0].length(); j++) {
                        if (result[j] != '?' && parts[0].charAt(j) != result[j]) {
                            isValid = false;
                            break;
                        }
                        result[j] = parts[0].charAt(j);
                    }
                    index = Math.max(parts[0].length(), index);
                }

                if (!isValid) break;

                if (parts[parts.length - 1].length() > 0) {
                    String last = parts[parts.length - 1];
                    for (int j = 0; j < last.length(); j++) {
                        if (result[result.length - 1 - j] != '?' && last.charAt(last.length() - 1 - j) != result[result.length - 1 - j]) {
                            isValid = false;
                            break;
                        }
                        result[result.length - 1 - j] = last.charAt(last.length() - 1 - j);
                    }
                }

                if (!isValid) break;

                for (int i = 1; i < parts.length - 1; i++) {
                    index++;
                    String word = parts[i];

                    for (int j = 0; j < word.length(); j++) {
                        result[index++] = word.charAt(j);
                    }
                }
            }

            sb.append("Case #").append(t + 1).append(": ");
            if (!isValid) {
                sb.append("*\n");
            } else {
                for (char c : result) {
                    if (c != '?') {
                        sb.append(c);
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static String[] splitPattern(String pattern) {
        ArrayList<String> parts = new ArrayList<>();

        int i = 0;
        while (i < pattern.length()) {
            int prev = i;
            int j = i;
            while (j < pattern.length() && pattern.charAt(j) != '*') {
                j++;
            }

            parts.add(pattern.substring(i, j));
            i = j;
            if (i == prev) {
                i = prev + 1;
            }
        }

        return parts.toArray(new String[0]);
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buffer[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
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
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return result.toString();
        }
    }
}