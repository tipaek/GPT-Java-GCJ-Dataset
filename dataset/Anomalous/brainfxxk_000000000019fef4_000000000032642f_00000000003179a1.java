import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class Solution {

    private static final int DIGIT_NUM = 10;
    private static char[] solutionDigits;

    public static void main(String[] args) {
        ScannerWrapper scanner = new ScannerWrapper(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int numberOfCases = scanner.nextInt();
        Random random = new Random(System.currentTimeMillis());

        for (int caseIndex = 1; caseIndex <= numberOfCases; ++caseIndex) {
            writer.print(String.format("Case #%d: ", caseIndex));
            int u = scanner.nextInt();
            Map<Character, Integer> charToDigitMap = new HashMap<>();
            Map<char[], Long> constraints = new HashMap<>();
            Set<Character> nonZeroChars = new HashSet<>();
            boolean randomMode = false;

            for (int i = 0; i < 10000; ++i) {
                long m = scanner.nextLong();
                char[] s = scanner.next().toCharArray();
                if (m == -1L) {
                    randomMode = true;
                    m = random.nextInt(9) + 1;
                    for (int j = 1; j < s.length; ++j)
                        m = m * 10 + random.nextInt(10);
                }
                if (s.length > 1)
                    nonZeroChars.add(s[0]);
                constraints.put(s, m);
                for (char c : s)
                    charToDigitMap.put(c, null);
            }

            List<Character> characters = new ArrayList<>(charToDigitMap.keySet());
            char[] usedDigits = new char[DIGIT_NUM];
            solutionDigits = null;

            while (solutionDigits == null) {
                findSolution(0, characters.size(), characters, charToDigitMap, usedDigits, nonZeroChars, constraints);
                if (randomMode) {
                    for (Map.Entry<char[], Long> entry : constraints.entrySet()) {
                        char[] s = entry.getKey();
                        long m = random.nextInt(9) + 1;
                        for (int j = 1; j < s.length; ++j)
                            m = m * 10 + random.nextInt(10);
                        entry.setValue(m);
                    }
                }
            }

            char c = 'A';
            for (int i = 0; i < DIGIT_NUM; ++i) {
                if (solutionDigits[i] != 0) {
                    writer.print(solutionDigits[i]);
                } else {
                    while (charToDigitMap.containsKey(c))
                        ++c;
                    charToDigitMap.put(c, i);
                    writer.print(c);
                }
            }
            writer.println();
        }
        writer.close();
    }

    private static void findSolution(int depth, int totalChars, List<Character> characters, Map<Character, Integer> charToDigitMap, char[] usedDigits, Set<Character> nonZeroChars, Map<char[], Long> constraints) {
        if (depth == totalChars) {
            boolean isValid = true;
            for (Map.Entry<char[], Long> entry : constraints.entrySet()) {
                char[] s = entry.getKey();
                long m = entry.getValue();
                long computedValue = 0;
                for (char c : s)
                    computedValue = computedValue * 10 + charToDigitMap.get(c);
                if (computedValue > m) {
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                solutionDigits = usedDigits.clone();
        } else {
            for (int i = 0; i < DIGIT_NUM; ++i) {
                if (usedDigits[i] == 0) {
                    if (i == 0 && nonZeroChars.contains(characters.get(depth)))
                        continue;
                    charToDigitMap.put(characters.get(depth), i);
                    usedDigits[i] = characters.get(depth);
                    findSolution(depth + 1, totalChars, characters, charToDigitMap, usedDigits, nonZeroChars, constraints);
                    if (solutionDigits != null)
                        break;
                    usedDigits[i] = 0;
                    charToDigitMap.put(characters.get(depth), null);
                }
            }
        }
    }

    private static class ScannerWrapper {

        private static final int BUFFER_SIZE = 10240;
        private Readable input;
        private CharBuffer buffer;
        private boolean endOfFile;

        private ScannerWrapper(InputStream input) {
            this.input = new BufferedReader(new InputStreamReader(input));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            endOfFile = false;
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
                    endOfFile = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void ensureNotEndOfFile() {
            if (endOfFile)
                throw new NoSuchElementException();
        }

        private char nextChar() {
            ensureNotEndOfFile();
            char ch = read();
            ensureNotEndOfFile();
            return ch;
        }

        private String next() {
            char ch;
            do {
                ch = read();
                ensureNotEndOfFile();
            } while (Character.isWhitespace(ch));
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(ch);
                ch = read();
            } while (!endOfFile && !Character.isWhitespace(ch));
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