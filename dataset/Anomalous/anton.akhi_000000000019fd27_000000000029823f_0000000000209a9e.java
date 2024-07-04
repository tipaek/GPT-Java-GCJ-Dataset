import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int testCount = nextInt();
        int bitCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            solve(bitCount);
        }
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private class Pattern {
        private char[] bits;

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
            Pattern reversed = new Pattern(bits.length);
            for (int i = 0; i < bits.length; i++) {
                reversed.bits[bits.length - 1 - i] = bits[i];
            }
            return reversed;
        }

        public Pattern inverse() {
            Pattern inversed = new Pattern(bits.length);
            for (int i = 0; i < bits.length; i++) {
                inversed.bits[i] = bits[i] == '1' ? '0' : bits[i] == '0' ? '1' : '?';
            }
            return inversed;
        }

        public boolean set(int position, char bit) {
            if (bits[position] != '?' && bits[position] != bit) {
                return false;
            }
            bits[position] = bit;
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

    private Map<Pattern, Double> patternProbabilities;

    private void solve(int bitCount) {
        patternProbabilities = new HashMap<>();
        Pattern initialPattern = new Pattern(bitCount);
        patternProbabilities.put(initialPattern, 1.0);

        for (int i = 0; i < 150; i++) {
            if (i % 10 == 0) {
                System.err.println(patternProbabilities.size());
                flipPatterns();
                System.err.println(patternProbabilities.size());
            }

            if (patternProbabilities.size() == 1) {
                Pattern singlePattern = patternProbabilities.keySet().iterator().next();
                if (singlePattern.isComplete()) {
                    break;
                }
            }

            List<Integer> bestPositions = findBestPositions(bitCount);
            Collections.shuffle(bestPositions);
            int bestPosition = bestPositions.get(0);
            out.println(bestPosition + 1);
            out.flush();

            char bit = (char) (nextInt() + '0');
            Map<Pattern, Double> nextPatternProbabilities = new HashMap<>();
            for (Map.Entry<Pattern, Double> entry : patternProbabilities.entrySet()) {
                Pattern pattern = entry.getKey();
                double probability = entry.getValue();
                if (pattern.set(bestPosition, bit)) {
                    nextPatternProbabilities.put(pattern, nextPatternProbabilities.getOrDefault(pattern, 0.0) + probability);
                }
            }
            patternProbabilities = nextPatternProbabilities;
        }

        printFinalPattern();
        if (nextToken().equals("N")) {
            System.exit(255);
        }
    }

    private List<Integer> findBestPositions(int bitCount) {
        List<Integer> bestPositions = new ArrayList<>();
        int maxValue = 0;
        int maxUnknowns = 0;

        for (int i = 0; i < bitCount; i++) {
            int zeroCount = 0, oneCount = 0, unknownCount = 0;
            for (Pattern pattern : patternProbabilities.keySet()) {
                if (pattern.bits[i] == '0') {
                    zeroCount++;
                } else if (pattern.bits[i] == '1') {
                    oneCount++;
                } else {
                    unknownCount++;
                }
            }

            int minCount = Math.min(zeroCount, oneCount);
            if (minCount > maxValue || (minCount == maxValue && unknownCount > maxUnknowns)) {
                maxValue = minCount;
                maxUnknowns = unknownCount;
                bestPositions.clear();
            }
            if (minCount == maxValue && unknownCount == maxUnknowns) {
                bestPositions.add(i);
            }
        }

        return bestPositions;
    }

    private void printFinalPattern() {
        double maxProbability = 0.0;
        double highestProbability = 0.0;
        Pattern bestPattern = null;
        Pattern fallbackPattern = null;

        for (Map.Entry<Pattern, Double> entry : patternProbabilities.entrySet()) {
            Pattern pattern = entry.getKey();
            double probability = entry.getValue();
            if (pattern.isComplete() && probability > maxProbability) {
                bestPattern = pattern;
                maxProbability = probability;
            }
            if (probability > highestProbability) {
                highestProbability = probability;
                fallbackPattern = pattern;
            }
        }

        if (bestPattern == null) {
            for (char bit : fallbackPattern.bits) {
                out.print(bit == '1' ? '1' : '0');
            }
            out.println();
        } else {
            out.println(bestPattern);
        }
        out.flush();
    }

    private void flipPatterns() {
        Map<Pattern, Double> nextPatternProbabilities = new HashMap<>();
        double totalProbability = 0.0;

        for (Map.Entry<Pattern, Double> entry : patternProbabilities.entrySet()) {
            Pattern pattern = entry.getKey();
            double probability = entry.getValue() * 0.25;

            if (probability < 1e-8) {
                continue;
            }

            totalProbability += 4 * probability;
            addPatternWithProbability(nextPatternProbabilities, pattern, probability);
            addPatternWithProbability(nextPatternProbabilities, pattern.inverse(), probability);
            addPatternWithProbability(nextPatternProbabilities, pattern.reverse(), probability);
            addPatternWithProbability(nextPatternProbabilities, pattern.inverse().reverse(), probability);
        }

        patternProbabilities = nextPatternProbabilities;
        normalizeProbabilities(totalProbability);
    }

    private void addPatternWithProbability(Map<Pattern, Double> patternProbabilities, Pattern pattern, double probability) {
        patternProbabilities.put(pattern, patternProbabilities.getOrDefault(pattern, 0.0) + probability);
    }

    private void normalizeProbabilities(double totalProbability) {
        for (Map.Entry<Pattern, Double> entry : patternProbabilities.entrySet()) {
            patternProbabilities.put(entry.getKey(), entry.getValue() / totalProbability);
        }
    }
}