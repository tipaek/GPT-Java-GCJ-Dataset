import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;
    private boolean endOfFile = false;

    private void execute() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int testCount = readInt();
        int bitCount = readInt();
        for (int test = 1; test <= testCount; test++) {
            process(bitCount);
        }
        writer.close();
    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                endOfFile = true;
                return "0";
            }
        }
        return tokenizer.nextToken();
    }

    private int readInt() {
        return Integer.parseInt(nextToken());
    }

    private long readLong() {
        return Long.parseLong(nextToken());
    }

    private double readDouble() {
        return Double.parseDouble(nextToken());
    }

    private class Pattern {
        private char[] bits;

        public Pattern(int size) {
            bits = new char[size];
            Arrays.fill(bits, '?');
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(bits);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pattern) {
                return Arrays.equals(bits, ((Pattern) obj).bits);
            }
            return false;
        }

        public Pattern reverse() {
            Pattern reversed = new Pattern(bits.length);
            for (int i = 0; i < bits.length; i++) {
                reversed.bits[bits.length - 1 - i] = bits[i];
            }
            return reversed;
        }

        public Pattern invert() {
            Pattern inverted = new Pattern(bits.length);
            for (int i = 0; i < bits.length; i++) {
                inverted.bits[i] = (bits[i] == '1') ? '0' : (bits[i] == '0') ? '1' : '?';
            }
            return inverted;
        }

        public boolean setBit(int position, char value) {
            if (bits[position] != '?' && bits[position] != value) {
                return false;
            }
            bits[position] = value;
            return true;
        }

        public boolean isComplete() {
            for (char bit : bits) {
                if (bit == '?') {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String toString() {
            return new String(bits);
        }
    }

    private Set<Pattern> patternSet;

    private void process(int bitCount) {
        patternSet = new HashSet<>();
        Pattern initialPattern = new Pattern(bitCount);
        patternSet.add(initialPattern);

        for (int i = 0; i < 150; i++) {
            if (i % 10 == 0) {
                transformPatterns();
            }
            if (patternSet.size() == 1) {
                Pattern singlePattern = patternSet.iterator().next();
                if (singlePattern.isComplete()) {
                    break;
                }
            }
            int bestPosition = 0;
            int minValue = Integer.MAX_VALUE;
            int maxQuestionMarks = 0;

            for (int j = 0; j < bitCount; j++) {
                int zeroCount = 0;
                int oneCount = 0;
                int questionCount = 0;

                for (Pattern pattern : patternSet) {
                    char bit = pattern.bits[j];
                    if (bit == '0') {
                        zeroCount++;
                    } else if (bit == '1') {
                        oneCount++;
                    } else {
                        questionCount++;
                    }
                }

                int minCount = Math.min(zeroCount, oneCount);
                if (minCount < minValue || (minCount == minValue && questionCount > maxQuestionMarks)) {
                    bestPosition = j;
                    minValue = minCount;
                    maxQuestionMarks = questionCount;
                }
            }

            writer.println(bestPosition + 1);
            writer.flush();
            char bitValue = (char) (readInt() + '0');
            Set<Pattern> nextPatterns = new HashSet<>();

            for (Pattern pattern : patternSet) {
                if (pattern.setBit(bestPosition, bitValue)) {
                    nextPatterns.add(pattern);
                }
            }
            patternSet = nextPatterns;
        }

        for (Pattern pattern : patternSet) {
            writer.println(pattern);
            writer.flush();
            break;
        }
        nextToken();
    }

    private void transformPatterns() {
        Set<Pattern> transformedPatterns = new HashSet<>();
        for (Pattern pattern : patternSet) {
            transformedPatterns.add(pattern);
            transformedPatterns.add(pattern.reverse());
            transformedPatterns.add(pattern.invert());
            transformedPatterns.add(pattern.invert().reverse());
        }
        patternSet = transformedPatterns;
    }
}