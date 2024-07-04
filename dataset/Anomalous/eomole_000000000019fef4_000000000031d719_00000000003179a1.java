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

    public static void main(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int U = scanner.nextInt();
                int[] questions = new int[1000];
                char[][] responses = new char[1000][];
                
                for (int i = 0; i < 1000; i++) {
                    questions[i] = scanner.nextInt();
                    responses[i] = scanner.next().toCharArray();
                }
                
                int[] charCounts = new int[128];
                int[] firstCharCounts = new int[128];
                
                for (int i = 0; i < 1000; i++) {
                    for (char c : responses[i]) {
                        charCounts[c]++;
                    }
                    firstCharCounts[responses[i][0]]++;
                }
                
                ArrayList<Pair> charList = new ArrayList<>();
                for (int i = 0; i < charCounts.length; i++) {
                    if (charCounts[i] > 0) {
                        charList.add(new Pair((char) i, firstCharCounts[i]));
                    }
                }
                
                Collections.sort(charList);
                char[] result = new char[10];
                
                for (int i = 0; i < 10; i++) {
                    result[indexMapping[i]] = charList.get(i).character;
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