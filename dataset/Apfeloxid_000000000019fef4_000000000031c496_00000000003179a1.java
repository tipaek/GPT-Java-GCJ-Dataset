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
            int U = scanner.nextInt();

            Set<Character> seenLetters = new HashSet<>();
            Pair[] seenLettersAtFirstPlace = new Pair[26];

            for (int i = 0; i < 26; i++) {
                seenLettersAtFirstPlace[i] = new Pair((char) ('A' + i));
            }

            for (int i = 0; i < 10_000;  i++) {
                int Qi = scanner.nextInt();
                String Ri = scanner.next();

                seenLettersAtFirstPlace[Ri.charAt(0) - 'A'].amount++;

                for (char c: Ri.toCharArray()) {
                    seenLetters.add(c);
                }
            }

            Arrays.sort(seenLettersAtFirstPlace, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o2.amount - o1.amount;
                }
            });

            String solution = "";

            for (int i = 0; i < 9; i++) {
                solution += seenLettersAtFirstPlace[i].letter;
                seenLetters.remove(seenLettersAtFirstPlace[i].letter);
            }

            Iterator<Character> it = seenLetters.iterator();
            solution = it.next() + solution;

            System.out.println("Case #" + testCase + ": " + solution);
        }
    }
}
