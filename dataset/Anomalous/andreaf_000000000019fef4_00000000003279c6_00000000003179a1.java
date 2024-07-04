import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 0; testCase < testCases; testCase++) {
                int upperBound = scanner.nextInt();
                int[] letterFrequencies = new int[26];
                for (int i = 0; i < 10_000; i++) {
                    String request = scanner.next();
                    String response = scanner.next();
                    for (int j = Math.max(0, response.length() - 3); j < response.length(); j++) {
                        letterFrequencies[response.charAt(j) - 'A']++;
                    }
                }
                List<LetterFrequency> frequencies = new ArrayList<>();
                for (int i = 0; i < letterFrequencies.length; i++) {
                    if (letterFrequencies[i] > 0) {
                        frequencies.add(new LetterFrequency((char) ('A' + i), letterFrequencies[i]));
                    }
                }
                frequencies.sort(Comparator.comparingInt(LetterFrequency::getFrequency));
                System.out.printf("Case #%d: %s%n", testCase + 1, formatResult(upperBound, frequencies));
            }
        }
    }

    private static String formatResult(int upperBound, List<LetterFrequency> frequencies) {
        StringBuilder result = new StringBuilder();
        if (upperBound == 2) {
            result.append(frequencies.get(0).getCharacter());
            for (int i = frequencies.size() - 1; i >= 1; i--) {
                result.append(frequencies.get(i).getCharacter());
            }
        } else {
            for (int i = frequencies.size() - 1; i >= 0; i--) {
                result.append(frequencies.get(i).getCharacter());
            }
        }
        return result.toString();
    }

    private static class LetterFrequency {
        private final char character;
        private final int frequency;

        public LetterFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        public int getFrequency() {
            return frequency;
        }

        public char getCharacter() {
            return character;
        }

        @Override
        public String toString() {
            return character + ": " + frequency;
        }
    }
}