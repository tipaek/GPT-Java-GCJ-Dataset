import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCases = sc.nextInt();
            for (int test = 0; test < numberOfTestCases; test++) {
                int upperBound = sc.nextInt();
                int[] letterFrequencies = new int[26];
                for (int q = 0; q < 10_000; q++) {
                    String request = sc.next();
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
                frequencies.sort(new FrequencyComparator());

                System.out.printf("Case #%d: %s%n", test + 1, formatFrequencies(frequencies));
            }
        }
    }

    private static String formatFrequencies(List<LetterFrequency> frequencies) {
        StringBuilder result = new StringBuilder();
        if (!frequencies.isEmpty()) {
            result.append(frequencies.get(0).getCharacter());
            for (int i = frequencies.size() - 1; i > 0; i--) {
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

        public char getCharacter() {
            return character;
        }

        public int getFrequency() {
            return frequency;
        }

        @Override
        public String toString() {
            return character + ": " + frequency;
        }
    }

    private static class FrequencyComparator implements Comparator<LetterFrequency> {
        @Override
        public int compare(LetterFrequency lf1, LetterFrequency lf2) {
            return Integer.compare(lf1.getFrequency(), lf2.getFrequency());
        }
    }
}