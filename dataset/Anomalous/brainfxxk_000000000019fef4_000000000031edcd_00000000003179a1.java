import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class Solution {

    private static final int NUM_DIGITS = 10;
    private static char[] result;

    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; ++caseIndex) {
            writer.printf("Case #%d: ", caseIndex);
            int u = scanner.nextInt();
            Map<Character, Integer> charToDigit = new HashMap<>();
            Map<char[], Long> constraints = new HashMap<>();
            Set<Character> nonZeroChars = new HashSet<>();

            for (int i = 0; i < 10000; ++i) {
                long m = scanner.nextLong();
                char[] s = scanner.next().toCharArray();
                if (m == -1L) {
                    m = 1L;
                    for (int j = 0; j < s.length; ++j)
                        m *= 10;
                    --m;
                }
                if (s.length > 1)
                    nonZeroChars.add(s[0]);
                constraints.put(s, m);
                for (char c : s)
                    charToDigit.put(c, null);
            }

            List<Character> characters = new ArrayList<>(charToDigit.keySet());
            char[] usedDigits = new char[NUM_DIGITS];
            result = null;
            findSolution(0, characters.size(), characters, charToDigit, usedDigits, nonZeroChars, constraints);

            char currentChar = 'A';
            for (int i = 0; i < NUM_DIGITS; ++i) {
                if (result[i] != 0)
                    writer.print(result[i]);
                else {
                    while (charToDigit.containsKey(currentChar))
                        ++currentChar;
                    charToDigit.put(currentChar, i);
                    writer.print(currentChar);
                }
            }
            writer.println();
        }
        writer.close();
    }

    private static void findSolution(int index, int totalChars, List<Character> characters, Map<Character, Integer> charToDigit, char[] usedDigits, Set<Character> nonZeroChars, Map<char[], Long> constraints) {
        if (index == totalChars) {
            boolean isValid = true;
            for (Map.Entry<char[], Long> entry : constraints.entrySet()) {
                char[] s = entry.getKey();
                long m = entry.getValue();
                long value = 0;
                for (char c : s)
                    value = value * 10 + charToDigit.get(c);
                if (value > m) {
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                result = usedDigits.clone();
        } else {
            for (int i = 0; i < NUM_DIGITS; ++i) {
                if (usedDigits[i] == 0) {
                    if (i == 0 && nonZeroChars.contains(characters.get(index)))
                        continue;
                    charToDigit.put(characters.get(index), i);
                    usedDigits[i] = characters.get(index);
                    findSolution(index + 1, totalChars, characters, charToDigit, usedDigits, nonZeroChars, constraints);
                    if (result != null)
                        break;
                    usedDigits[i] = 0;
                    charToDigit.put(characters.get(index), null);
                }
            }
        }
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;
        private Readable input;
        private CharBuffer buffer;
        private boolean eof;

        private SimpleScanner(InputStream input) {
            this.input = new BufferedReader(new InputStreamReader(input));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            eof = false;
        }

        private char read() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int bytesRead;
                try {
                    bytesRead = input.read(buffer);
                } catch (IOException e) {
                    bytesRead = -1;
                }
                if (bytesRead <= 0) {
                    eof = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void checkEof() {
            if (eof)
                throw new NoSuchElementException();
        }

        private char nextChar() {
            checkEof();
            char ch = read();
            checkEof();
            return ch;
        }

        private String next() {
            char ch;
            do {
                ch = read();
                checkEof();
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