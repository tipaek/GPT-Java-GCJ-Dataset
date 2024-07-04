import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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

        private int readInt() {
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

        private String readString() {
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

        private double readDouble() {
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
                double multiplier = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    multiplier /= 10;
                    result += (c - '0') * multiplier;
                    c = read();
                }
            }
            return result * sign;
        }

        private long readLong() {
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
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static long getRandomIntInRange(long startInclusive, long endExclusive) {
        return ThreadLocalRandom.current().nextLong(startInclusive, endExclusive);
    }

    public static void util() {
        int[] frequencies = new int[10];
        for (int i = 0; i < 10000; i++) {
            long upperBound = getRandomIntInRange(1, Long.MAX_VALUE);
            long randomNumber = getRandomIntInRange(1, upperBound);
            String numberString = String.valueOf(randomNumber);
            for (char c : numberString.toCharArray()) {
                frequencies[Character.getNumericValue(c)]++;
            }
        }
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(i + " is present " + frequencies[i] + " times");
        }
    }

    public static void attempt1(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCount = in.readInt();
        for (int t = 0; t < testCount; t++) {
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
                for (char c : responses[i].toCharArray()) {
                    usedChars.add(c);
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
                for (String num : numbers) {
                    char c = num.charAt(0);
                    if (answer.chars().noneMatch(ch -> ch == c)) {
                        answer.append(c);
                        break;
                    }
                }
            }

            sb.append("Case #").append(t + 1).append(": ").append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCount = in.readInt();
        for (int t = 0; t < testCount; t++) {
            StringBuilder answer = new StringBuilder();
            Set<Character> usedChars = new HashSet<>();
            Set<Character> usedCharsFirstPlace = new HashSet<>();
            int u = in.readInt();
            String[] responses = new String[10000];
            int[] queries = new int[10000];
            int[] frequencies = new int[26];
            for (int i = 0; i < responses.length; i++) {
                queries[i] = in.readInt();
                responses[i] = in.readString();
                for (char c : responses[i].toCharArray()) {
                    usedChars.add(c);
                    frequencies[c - 'A']++;
                }
                usedCharsFirstPlace.add(responses[i].charAt(0));
            }

            // Find zero
            usedChars.removeAll(usedCharsFirstPlace);
            Iterator<Character> iter = usedChars.iterator();
            answer.append(iter.next());

            int beforeMax = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                int max = 0;
                int indexMax = -1;
                for (int j = 0; j < frequencies.length; j++) {
                    if (frequencies[j] >= max && frequencies[j] < beforeMax) {
                        max = frequencies[j];
                        indexMax = j;
                    }
                }
                answer.append((char) ('A' + indexMax));
                beforeMax = max;
            }
            sb.append("Case #").append(t + 1).append(": ").append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}