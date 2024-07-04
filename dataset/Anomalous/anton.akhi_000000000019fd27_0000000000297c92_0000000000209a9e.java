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
        int bits = nextInt();
        for (int test = 1; test <= testCount; test++) {
            solve(bits);
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

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private class Pattern {
        private char[] bits;

        public Pattern(int length) {
            bits = new char[length];
            Arrays.fill(bits, '?');
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(bits);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Pattern && Arrays.equals(bits, ((Pattern) obj).bits);
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

    private HashMap<Pattern, Double> patternMap;

    private void solve(int bits) {
        patternMap = new HashMap<>();
        Pattern initialPattern = new Pattern(bits);
        patternMap.put(initialPattern, 1.0);

        for (int i = 0; i < 150; i++) {
            if (i % 10 == 0) {
                System.err.println(patternMap);
                flipPatterns();
                System.err.println(patternMap);
            }

            if (patternMap.size() == 1) {
                Pattern pattern = patternMap.keySet().iterator().next();
                if (pattern.isComplete()) {
                    break;
                }
            }

            ArrayList<Integer> candidatePositions = new ArrayList<>();
            int maxZerosOnes = 0;
            int maxQuestions = 0;

            for (int j = 0; j < bits; j++) {
                int zeros = 0;
                int ones = 0;
                int questions = 0;

                for (Pattern pattern : patternMap.keySet()) {
                    switch (pattern.bits[j]) {
                        case '0':
                            zeros++;
                            break;
                        case '1':
                            ones++;
                            break;
                        case '?':
                            questions++;
                            break;
                    }
                }

                int minZerosOnes = Math.min(zeros, ones);
                if (minZerosOnes > maxZerosOnes || (minZerosOnes == maxZerosOnes && questions > maxQuestions)) {
                    maxZerosOnes = minZerosOnes;
                    maxQuestions = questions;
                    candidatePositions.clear();
                }

                if (minZerosOnes == maxZerosOnes && questions == maxQuestions) {
                    candidatePositions.add(j);
                }
            }

            Collections.shuffle(candidatePositions);
            int bestPosition = candidatePositions.get(0);
            out.println(bestPosition + 1);
            out.flush();

            char bit = (char) (nextInt() + '0');
            HashMap<Pattern, Double> nextPatternMap = new HashMap<>();

            for (Pattern pattern : patternMap.keySet()) {
                double probability = patternMap.get(pattern);
                if (pattern.set(bestPosition, bit)) {
                    nextPatternMap.put(pattern, nextPatternMap.getOrDefault(pattern, 0.0) + probability);
                }
            }

            patternMap = nextPatternMap;
        }

        double highestProbability = 0.0;
        Pattern bestPattern = null;
        for (Pattern pattern : patternMap.keySet()) {
            double probability = patternMap.get(pattern);
            if (pattern.isComplete() && probability > highestProbability) {
                bestPattern = pattern;
                highestProbability = probability;
            }
        }

        out.println(bestPattern);
        out.flush();

        if (nextToken().equals("N")) {
            System.exit(255);
        }
    }

    private void flipPatterns() {
        HashMap<Pattern, Double> nextPatternMap = new HashMap<>();
        double totalProbability = 0;

        for (Pattern pattern : patternMap.keySet()) {
            double probability = patternMap.get(pattern) * 0.25;
            if (probability < 1e-8) {
                continue;
            }

            totalProbability += 4 * probability;
            nextPatternMap.put(pattern, nextPatternMap.getOrDefault(pattern, 0.0) + probability);

            Pattern inversedPattern = pattern.inverse();
            nextPatternMap.put(inversedPattern, nextPatternMap.getOrDefault(inversedPattern, 0.0) + probability);

            Pattern reversedPattern = pattern.reverse();
            nextPatternMap.put(reversedPattern, nextPatternMap.getOrDefault(reversedPattern, 0.0) + probability);

            Pattern reversedInversedPattern = reversedPattern.inverse();
            nextPatternMap.put(reversedInversedPattern, nextPatternMap.getOrDefault(reversedInversedPattern, 0.0) + probability);
        }

        patternMap = nextPatternMap;
        for (Pattern pattern : patternMap.keySet()) {
            patternMap.put(pattern, patternMap.get(pattern) / totalProbability);
        }
    }
}