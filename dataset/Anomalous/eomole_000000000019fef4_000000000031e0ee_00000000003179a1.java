import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class DigitFrequencyAnalyzer {
    static class CharacterFrequency implements Comparable<CharacterFrequency> {
        final char character;
        final int frequency;

        public CharacterFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(CharacterFrequency other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }

    static final int[] digitMapping = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    static final int MAX_ENTRIES = 10000;

    public static void main(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int U = scanner.nextInt();
                long[] queries = new long[MAX_ENTRIES];
                char[][] responses = new char[MAX_ENTRIES][];
                for (int i = 0; i < MAX_ENTRIES; i++) {
                    queries[i] = scanner.nextLong();
                    responses[i] = scanner.next().toCharArray();
                }

                int[] characterCount = new int[128];
                int[] initialCharacterCount = new int[128];
                for (int i = 0; i < MAX_ENTRIES; i++) {
                    for (char c : responses[i]) {
                        characterCount[c]++;
                    }
                    initialCharacterCount[responses[i][0]]++;
                }

                ArrayList<CharacterFrequency> frequencyList = new ArrayList<>();
                for (int i = 0; i < characterCount.length; i++) {
                    if (characterCount[i] > 0) {
                        frequencyList.add(new CharacterFrequency((char) i, initialCharacterCount[i]));
                    }
                }

                if (frequencyList.size() != 10) {
                    throw new IllegalStateException("Invalid number of unique characters found.");
                }

                Collections.sort(frequencyList);
                char[] result = new char[10];
                for (int i = 0; i < 10; i++) {
                    result[digitMapping[i]] = frequencyList.get(i).character;
                }

                System.out.printf("Case #%d: %s\n", testCase, new String(result));
            }
        }
    }
}

public class Solution {
    public static void main(String... args) {
        DigitFrequencyAnalyzer.main(args);
    }
}