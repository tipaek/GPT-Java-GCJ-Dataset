import java.util.*;

public class Solution {

    static class Pair {
        char letter;
        int amount;

        public Pair(char letter) {
            this.letter = letter;
            this.amount = 0;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int U = scanner.nextInt();

            Set<Character> seenLetters = new HashSet<>();
            Pair[] letterFrequency = new Pair[26];

            for (int i = 0; i < 26; i++) {
                letterFrequency[i] = new Pair((char) ('A' + i));
            }

            for (int i = 0; i < 10_000; i++) {
                int Qi = scanner.nextInt();
                String Ri = scanner.next();

                letterFrequency[Ri.charAt(0) - 'A'].amount++;

                for (char c : Ri.toCharArray()) {
                    seenLetters.add(c);
                }
            }

            Arrays.sort(letterFrequency, (o1, o2) -> o2.amount - o1.amount);

            StringBuilder solution = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                solution.append(letterFrequency[i].letter);
                seenLetters.remove(letterFrequency[i].letter);
            }

            Iterator<Character> it = seenLetters.iterator();
            solution.insert(0, it.next());

            System.out.println("Case #" + testCase + ": " + solution);
        }
    }
}