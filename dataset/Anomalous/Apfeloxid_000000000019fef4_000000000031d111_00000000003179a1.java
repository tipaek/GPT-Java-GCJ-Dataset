import java.util.*;

public class Solution {

    static class Pair {
        char letter;
        int count;

        public Pair(char letter) {
            this.letter = letter;
            this.count = 0;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            scanner.nextInt();  // Skip the first integer

            Set<Character> uniqueLetters = new HashSet<>();
            Pair[] letterFrequency = new Pair[26];

            for (int i = 0; i < 26; i++) {
                letterFrequency[i] = new Pair((char) ('A' + i));
            }

            for (int i = 0; i < 10_000; i++) {
                scanner.next();  // Skip the first string
                String Ri = scanner.next();

                letterFrequency[Ri.charAt(0) - 'A'].count++;

                for (char c : Ri.toCharArray()) {
                    uniqueLetters.add(c);
                }
            }

            Arrays.sort(letterFrequency, (a, b) -> b.count - a.count);

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                result.append(letterFrequency[i].letter);
                uniqueLetters.remove(letterFrequency[i].letter);
            }

            Iterator<Character> iterator = uniqueLetters.iterator();
            if (iterator.hasNext()) {
                result.insert(0, iterator.next());
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}