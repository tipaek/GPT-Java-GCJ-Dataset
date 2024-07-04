import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class DigitFrequencySolver {
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

    static final int[] indexMapping = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int unknownValue = scanner.nextInt();
                int[] queries = new int[1000];
                char[][] responses = new char[1000][];
                for (int i = 0; i < 1000; i++) {
                    queries[i] = scanner.nextInt();
                    responses[i] = scanner.next().toCharArray();
                }
                int[] characterCount = new int[128];
                int[] firstCharacterCount = new int[128];
                for (int i = 0; i < 1000; i++) {
                    for (char character : responses[i]) {
                        characterCount[character]++;
                    }
                    firstCharacterCount[responses[i][0]]++;
                }
                ArrayList<CharacterFrequency> frequencyList = new ArrayList<>();
                for (int i = 0; i < characterCount.length; i++) {
                    if (characterCount[i] > 0) {
                        frequencyList.add(new CharacterFrequency((char) i, firstCharacterCount[i]));
                    }
                }
                if (frequencyList.size() != 10) {
                    throw new IllegalStateException("Frequency list size is not equal to 10");
                }
                Collections.sort(frequencyList);
                char[] result = new char[10];
                for (int i = 0; i < 10; i++) {
                    result[indexMapping[i]] = frequencyList.get(i).character;
                }
                System.out.printf("Case #%d: %s%n", testCase, new String(result));
            }
        }
    }
}

public class Solution {
    public static void main(String... args) throws Exception {
        DigitFrequencySolver.main(args);
    }
}