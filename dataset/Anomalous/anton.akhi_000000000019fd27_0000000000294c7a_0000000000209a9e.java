import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void execute() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int testCount = readInt();
        int bitCount = readInt();
        for (int i = 1; i <= testCount; i++) {
            processTest(bitCount);
        }
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int readInt() {
        return Integer.parseInt(nextToken());
    }

    private class Pattern {
        char[] bits;
        boolean isInverse;
        boolean isReversed;

        public Pattern(int bitCount) {
            bits = new char[bitCount];
            Arrays.fill(bits, '?');
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(bits);
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof Pattern) && Arrays.equals(bits, ((Pattern) obj).bits);
        }

        public Pattern reverse() {
            Pattern reversedPattern = new Pattern(bits.length);
            for (int i = 0; i < bits.length; i++) {
                reversedPattern.bits[bits.length - 1 - i] = bits[i];
            }
            reversedPattern.isInverse = isInverse;
            reversedPattern.isReversed = !isReversed;
            return reversedPattern;
        }

        public Pattern inverse() {
            Pattern inversedPattern = new Pattern(bits.length);
            for (int i = 0; i < bits.length; i++) {
                inversedPattern.bits[i] = bits[i] == '1' ? '0' : bits[i] == '0' ? '1' : '?';
            }
            inversedPattern.isInverse = !isInverse;
            inversedPattern.isReversed = isReversed;
            return inversedPattern;
        }

        public boolean setBit(int position, char bit) {
            if (bits[position] != '?' && bits[position] != bit) {
                return false;
            }
            bits[position] = bit;
            return true;
        }
    }

    private void processTest(int bitCount) {
        Pattern initialPattern = new Pattern(bitCount);
        Set<Pattern> patterns = new HashSet<>();
        patterns.add(initialPattern);

        for (int i = 0; i < 150; i++) {
            if (i % 10 == 0) {
                updatePatterns(patterns);
            }
            int bestPosition = 0;
            int minValue = 0;
            int questionCount = 0;

            for (int j = 0; j < bitCount; j++) {
                int zeroCount = 0;
                int oneCount = 0;
                int questionMarkCount = 0;

                for (Pattern pattern : patterns) {
                    if (pattern.bits[j] == '0') {
                        zeroCount++;
                    } else if (pattern.bits[j] == '1') {
                        oneCount++;
                    } else {
                        questionMarkCount++;
                    }
                }

                int minValueAtPosition = Math.min(oneCount, zeroCount);
                if (minValueAtPosition > minValue || (minValueAtPosition == minValue && questionCount < questionMarkCount)) {
                    bestPosition = j;
                    minValue = minValueAtPosition;
                    questionCount = questionMarkCount;
                }
            }

            out.println(bestPosition + 1);
            out.flush();
            char bit = (char) (readInt() + '0');
            Set<Pattern> updatedPatterns = new HashSet<>();

            for (Pattern pattern : patterns) {
                if (pattern.setBit(bestPosition, bit)) {
                    updatedPatterns.add(pattern);
                }
            }
            patterns = updatedPatterns;
        }

        for (Pattern pattern : patterns) {
            for (char bit : pattern.bits) {
                out.print(bit);
            }
            out.println();
            out.flush();
            break;
        }
        nextToken();
    }

    private void updatePatterns(Set<Pattern> patterns) {
        Set<Pattern> updatedPatterns = new HashSet<>();
        for (Pattern pattern : patterns) {
            updatedPatterns.add(pattern);
            updatedPatterns.add(pattern.reverse());
            updatedPatterns.add(pattern.inverse());
            updatedPatterns.add(pattern.inverse().reverse());
        }
        patterns = updatedPatterns;
    }
}