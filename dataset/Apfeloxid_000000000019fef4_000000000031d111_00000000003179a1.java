import java.util.*;

public class Solution {

    static class Pair {
        char letter;
        int amount;

        public Pair(char letter) {
            this.letter = letter;
            amount = 0;
        }
    }

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            scanner.nextInt();

            Set<Character> seenLetters = new HashSet<>();
            Pair[] seenLettersAtFirstPlace = new Pair[26];

            for (int i = 0; i < 26; i++) {
                seenLettersAtFirstPlace[i] = new Pair((char) ('A' + i));
            }

            for (int i = 0; i < 10_000; i++) {
                scanner.next();
                String Ri = scanner.next();

                seenLettersAtFirstPlace[Ri.charAt(0) - 'A'].amount++;   //Runtime

                for (char c: Ri.toCharArray()) {
                    seenLetters.add(c);
                }
            }

            Arrays.sort(seenLettersAtFirstPlace, (o1, o2) -> o2.amount - o1.amount);

            StringBuilder solution = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                solution.append(seenLettersAtFirstPlace[i].letter);
                seenLetters.remove(seenLettersAtFirstPlace[i].letter);
            }

            Iterator<Character> it = seenLetters.iterator(); //
            solution.insert(0, it.next());

            System.out.println("Case #" + testCase + ": " + solution);
        }
    }
}
