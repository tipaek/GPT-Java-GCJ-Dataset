import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class B {
    static class Pair implements Comparable<Pair> {
        final char character;
        final int frequency;

        public Pair(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }

    static final int[] indexMapping = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    static final int MAX_SIZE = 10000;

    public static void main(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int U = scanner.nextInt();
                long[] queries = new long[MAX_SIZE];
                char[][] responses = new char[MAX_SIZE][];
                for (int i = 0; i < MAX_SIZE; i++) {
                    queries[i] = scanner.nextLong();
                    responses[i] = scanner.next().toCharArray();
                }
                int[] characterCount = new int[128];
                for (int i = 0; i < MAX_SIZE; i++) {
                    for (char c : responses[i]) {
                        characterCount[c]++;
                    }
                }
                ArrayList<Pair> frequencyList = new ArrayList<>();
                for (int i = 0; i < characterCount.length; i++) {
                    if (characterCount[i] > 0) {
                        frequencyList.add(new Pair((char) i, characterCount[i]));
                    }
                }
                if (frequencyList.size() != 10) {
                    throw new IllegalStateException("Expected exactly 10 unique characters.");
                }
                Collections.sort(frequencyList);
                char[] result = new char[10];
                for (int i = 0; i < 10; i++) {
                    result[indexMapping[i]] = frequencyList.get(i).character;
                }
                System.out.printf("Case #%d: %s\n", t, new String(result));
            }
        }
    }
}

public class Solution {
    public static void main(String... args) throws Exception {
        B.main();
    }
}