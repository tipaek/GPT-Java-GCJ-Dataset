import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().execute();
    }

    private void execute() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 0; testCase < testCases; testCase++) {
            String defaultMaxValue = String.valueOf((long) Math.pow(10, scanner.nextDouble()) - 1);
            scanner.nextLine();

            List<Guess> guesses = new ArrayList<>();
            for (int i = 0; i < Math.pow(10, 4); i++) {
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                String localMax = parts[0];
                String record = parts[1];

                if ("-1".equals(localMax)) {
                    localMax = String.valueOf((long) Math.pow(10, record.length()) - 1);
                }
                guesses.add(new Guess(localMax, record));
            }

            guesses.sort(new GuessComparator());

            List<Character> key = new ArrayList<>();
            for (Guess guess : guesses) {
                if (guess.max.startsWith("10") && guess.max.length() == guess.answer.length()) {
                    key.add(guess.answer.charAt(1));
                    break;
                }
            }

            int number = 1;
            for (Guess guess : guesses) {
                if (guess.max.charAt(0) - '0' != number) {
                    continue;
                }
                if (key.contains(guess.answer.charAt(0))) {
                    continue;
                }
                number++;
                key.add(guess.answer.charAt(0));
            }

            StringBuilder result = new StringBuilder();
            for (Character character : key) {
                result.append(character);
            }
            System.out.println("Case #" + (testCase + 1) + ": " + result.toString());
        }
    }

    private static class Guess {
        String max;
        String answer;

        public Guess(String max, String answer) {
            this.max = max;
            this.answer = answer;
        }
    }

    private static class GuessComparator implements Comparator<Guess> {
        @Override
        public int compare(Guess g1, Guess g2) {
            int index = 0;
            while (index < g1.max.length() && index < g2.max.length()) {
                if (g1.max.charAt(index) == g2.max.charAt(index)) {
                    index++;
                    continue;
                }
                return g1.max.charAt(index) - g2.max.charAt(index);
            }
            if (g1.max.length() != g2.max.length()) {
                return g1.max.length() - g2.max.length();
            }
            return g1.max.charAt(index) - g2.max.charAt(index);
        }
    }
}