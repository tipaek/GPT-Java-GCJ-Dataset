import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = sc.nextInt();
            for (int test = 1; test <= numberOfTestCases; test++) {
                int upperBound = sc.nextInt();
                int[] letterFrequencies = new int[26];
                for (int i = 0; i < 10_000; i++) {
                    sc.next(); // Read the request, but it's not used
                    String response = sc.next();
                    for (char c : response.toCharArray()) {
                        letterFrequencies[c - 'A']++;
                    }
                }
                List<LetterFrequency> frequencies = new ArrayList<>();
                for (int i = 0; i < letterFrequencies.length; i++) {
                    if (letterFrequencies[i] > 0) {
                        frequencies.add(new LetterFrequency((char) ('A' + i), letterFrequencies[i]));
                    }
                }
                frequencies.sort(Comparator.comparingInt(LetterFrequency::getFrequency));

                System.out.printf("Case #%d: %s%n", test, formatResult(upperBound, frequencies));
            }
        }
    }

    private static String formatResult(int upperBound, List<LetterFrequency> frequencies) {
        StringBuilder result = new StringBuilder();
        if (upperBound == 2) {
            result.append(frequencies.get(0).getLetter());
            for (int i = frequencies.size() - 1; i > 0; i--) {
                result.append(frequencies.get(i).getLetter());
            }
        } else {
            for (int i = frequencies.size() - 1; i >= 0; i--) {
                result.append(frequencies.get(i).getLetter());
            }
        }
        return result.toString();
    }

    private static class LetterFrequency {
        private final char letter;
        private final int frequency;

        public LetterFrequency(char letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
        }

        public int getFrequency() {
            return frequency;
        }

        public char getLetter() {
            return letter;
        }

        @Override
        public String toString() {
            return letter + ": " + frequency;
        }
    }
}