import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class Solution {

    private static final int DIGIT_NUM = 10;
    private static char[] result;

    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; ++caseIndex) {
            writer.printf("Case #%d: ", caseIndex);
            int u = scanner.nextInt();
            long upperLimit = (long) Math.pow(10, u) - 1;
            Map<Character, Integer> charToDigitMap = new HashMap<>();
            Map<char[], Long> stringLimits = new HashMap<>();
            Set<Character> nonZeroChars = new HashSet<>();
            for (int i = 0; i < 10000; ++i) {
                long m = scanner.nextLong();
                if (m == -1L) m = upperLimit;
                char[] s = scanner.next().toCharArray();
                nonZeroChars.add(s[0]);
                stringLimits.put(s, m);
                for (char c : s) charToDigitMap.put(c, null);
            }
            List<Character> characters = new ArrayList<>(charToDigitMap.keySet());
            char[] usedDigits = new char[DIGIT_NUM];
            result = null;
            findMapping(0, characters.size(), characters, charToDigitMap, usedDigits, nonZeroChars, stringLimits);
            char fillerChar = 'A';
            for (int i = 0; i < DIGIT_NUM; ++i) {
                if (result[i] != 0) {
                    writer.print(result[i]);
                } else {
                    while (charToDigitMap.containsKey(fillerChar)) ++fillerChar;
                    charToDigitMap.put(fillerChar, i);
                    writer.print(fillerChar);
                }
            }
            writer.println();
        }
        writer.close();
    }

    private static void findMapping(int index, int totalChars, List<Character> characters, Map<Character, Integer> charToDigitMap, char[] usedDigits, Set<Character> nonZeroChars, Map<char[], Long> stringLimits) {
        if (index == totalChars) {
            boolean isValid = true;
            for (Map.Entry<char[], Long> entry : stringLimits.entrySet()) {
                char[] s = entry.getKey();
                long m = entry.getValue();
                long value = 0;
                for (char c : s) value = value * 10 + charToDigitMap.get(c);
                if (value > m) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) result = usedDigits.clone();
        } else {
            for (int i = 0; i < DIGIT_NUM; ++i) {
                if (usedDigits[i] == 0) {
                    if (i == 0 && nonZeroChars.contains(characters.get(index))) continue;
                    charToDigitMap.put(characters.get(index), i);
                    usedDigits[i] = characters.get(index);
                    findMapping(index + 1, totalChars, characters, charToDigitMap, usedDigits, nonZeroChars, stringLimits);
                    if (result != null) break;
                    usedDigits[i] = 0;
                    charToDigitMap.put(characters.get(index), null);
                }
            }
        }
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable input;
        private CharBuffer buffer;
        private boolean eof;

        public SimpleScanner(InputStream input) {
            this.input = new BufferedReader(new InputStreamReader(input));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            eof = false;
        }

        private char read() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int numRead;
                try {
                    numRead = input.read(buffer);
                } catch (IOException e) {
                    numRead = -1;
                }
                if (numRead <= 0) {
                    eof = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void ensureNotEof() {
            if (eof) throw new NoSuchElementException();
        }

        private char nextChar() {
            ensureNotEof();
            char ch = read();
            ensureNotEof();
            return ch;
        }

        private String next() {
            char ch;
            do {
                ch = read();
                ensureNotEof();
            } while (Character.isWhitespace(ch));
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(ch);
                ch = read();
            } while (!eof && !Character.isWhitespace(ch));
            return sb.toString();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}