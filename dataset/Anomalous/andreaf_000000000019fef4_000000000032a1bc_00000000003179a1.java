import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = sc.nextInt();
            for (int test = 0; test < numberOfTestCases; test++) {
                int upperBound = sc.nextInt();
                int[] letterCounts = new int[26];
                int[] firstLetterCounts = new int[26];

                for (int i = 0; i < 10000; i++) {
                    String request = sc.next();
                    String response = sc.next();
                    for (char c : response.toCharArray()) {
                        letterCounts[c - 'A']++;
                    }
                    firstLetterCounts[response.charAt(0) - 'A']++;
                }

                List<LetterFrequency> frequencies = new ArrayList<>();
                if (upperBound == 2) {
                    for (int i = 0; i < letterCounts.length; i++) {
                        if (letterCounts[i] > 0) {
                            frequencies.add(new LetterFrequency((char) ('A' + i), letterCounts[i]));
                        }
                    }
                } else {
                    for (int i = 0; i < letterCounts.length; i++) {
                        if (firstLetterCounts[i] > 0) {
                            frequencies.add(new LetterFrequency((char) ('A' + i), letterCounts[i]));
                        }
                    }
                }

                frequencies.sort(Comparator.comparingInt(LetterFrequency::getFrequency));

                System.out.printf("Case #%d: %s%n", test + 1, formatResult(upperBound, frequencies));
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