import java.io.*;
import java.util.*;

public class Solution {

    private static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double fraction = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    fraction /= 10;
                    result += (c - '0') * fraction;
                    c = read();
                }
            }
            return result * sign;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        private boolean isSpaceChar(int c) {
            return filter != null ? filter.isSpaceChar(c) : c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = in.readInt();
        for (int t = 0; t < testCases; t++) {
            StringBuilder answer = new StringBuilder();
            Set<Character> usedChars = new HashSet<>();
            Set<Character> usedCharsFirstPlace = new HashSet<>();
            Map<Integer, List<String>> mapping = new HashMap<>();
            int u = in.readInt();
            String[] responses = new String[10000];
            int[] queries = new int[10000];

            for (int i = 0; i < responses.length; i++) {
                queries[i] = in.readInt();
                responses[i] = in.readString();
                for (char ch : responses[i].toCharArray()) {
                    usedChars.add(ch);
                }
                usedCharsFirstPlace.add(responses[i].charAt(0));
                if (queries[i] != -1) {
                    mapping.computeIfAbsent(queries[i], k -> new ArrayList<>()).add(responses[i]);
                }
            }

            // Find zero
            usedChars.removeAll(usedCharsFirstPlace);
            Iterator<Character> iter = usedChars.iterator();
            answer.append(iter.next());

            List<String> ones = mapping.get(1);
            answer.append(ones.get(0));

            List<String> twos = mapping.get(2);
            for (String ts : twos) {
                if (ts.charAt(0) != answer.charAt(1)) {
                    answer.append(ts.charAt(0));
                    break;
                }
            }

            for (int i = 3; i < 10; i++) {
                List<String> numbers = mapping.get(i);
                for (String number : numbers) {
                    char c = number.charAt(0);
                    if (answer.chars().noneMatch(ch -> ch == c)) {
                        answer.append(c);
                        break;
                    }
                }
            }

            output.append("Case #").append(t + 1).append(": ").append(answer.toString()).append('\n');
        }
        System.out.print(output.toString());
    }
}