import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    private static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    result += (c - '0') * m;
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

        public boolean isSpaceChar(int c) {
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
        int[] frequency = new int[10];
        for (int i = 0; i < 10000; i++) {
            long upperBound = getRandomIntInRange(1, Long.MAX_VALUE);
            long randomNum = getRandomIntInRange(1, upperBound);
            String numberStr = String.valueOf(randomNum);
            for (int j = 0; j < numberStr.length(); j++) {
                char c = numberStr.charAt(j);
                frequency[Character.getNumericValue(c)]++;
            }
        }
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(i + " is present " + frequency[i] + " times");
        }
    }

    public static void attempt1(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = in.readInt();
        for (int t = 0; t < testCases; t++) {
            StringBuilder answer = new StringBuilder();
            HashSet<Character> usedChars = new HashSet<>();
            HashSet<Character> firstPlaceChars = new HashSet<>();
            HashMap<Integer, ArrayList<String>> mapping = new HashMap<>();
            int u = in.readInt();
            String[] responses = new String[10000];
            int[] queries = new int[10000];
            for (int i = 0; i < responses.length; i++) {
                queries[i] = in.readInt();
                responses[i] = in.readString();
                for (int j = 0; j < responses[i].length(); j++) {
                    usedChars.add(responses[i].charAt(j));
                }
                firstPlaceChars.add(responses[i].charAt(0));
                if (queries[i] != -1) {
                    mapping.computeIfAbsent(queries[i], k -> new ArrayList<>()).add(responses[i]);
                }
            }

            // Find zero
            usedChars.removeAll(firstPlaceChars);
            Iterator<Character> iter = usedChars.iterator();
            answer.append(iter.next());

            ArrayList<String> ones = mapping.get(1);
            answer.append(ones.get(0));

            ArrayList<String> twos = mapping.get(2);
            for (String str : twos) {
                if (str.charAt(0) != answer.charAt(1)) {
                    answer.append(str.charAt(0));
                    break;
                }
            }
            for (int i = 3; i < 10; i++) {
                ArrayList<String> numList = mapping.get(i);
                for (String str : numList) {
                    char c = str.charAt(0);
                    if (answer.chars().noneMatch(ch -> ch == c)) {
                        answer.append(c);
                        break;
                    }
                }
            }

            sb.append("Case #").append(t + 1).append(": ").append(answer.toString()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = in.readInt();
        for (int t = 0; t < testCases; t++) {
            StringBuilder answer = new StringBuilder();
            HashSet<Character> usedChars = new HashSet<>();
            HashSet<Character> firstPlaceChars = new HashSet<>();
            int u = in.readInt();
            String[] responses = new String[10000];
            int[] queries = new int[10000];
            int[] frequency = new int[26];
            for (int i = 0; i < responses.length; i++) {
                queries[i] = in.readInt();
                responses[i] = in.readString();
                for (int j = 0; j < responses[i].length(); j++) {
                    usedChars.add(responses[i].charAt(j));
                    frequency[responses[i].charAt(j) - 'A']++;
                }
                firstPlaceChars.add(responses[i].charAt(0));
            }

            // Find zero
            usedChars.removeAll(firstPlaceChars);
            Iterator<Character> iter = usedChars.iterator();
            answer.append(iter.next());

            char zeroChar = answer.charAt(0);
            int previousMax = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                int max = 0;
                int maxIndex = -1;
                for (int j = 0; j < frequency.length; j++) {
                    if (zeroChar == (char) ('A' + j)) continue;
                    if (frequency[j] >= max && frequency[j] < previousMax) {
                        max = frequency[j];
                        maxIndex = j;
                    }
                }
                answer.append((char) ('A' + maxIndex));
                previousMax = max;
            }
            sb.append("Case #").append(t + 1).append(": ").append(answer.toString()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}