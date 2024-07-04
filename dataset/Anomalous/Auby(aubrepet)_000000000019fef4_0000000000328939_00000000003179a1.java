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
            String defaultMax = String.valueOf((long) Math.pow(10, scanner.nextDouble()) - 1);
            scanner.nextLine();

            List<Guess> guesses = new ArrayList<>();
            for (int i = 0; i < Math.pow(10, 4); i++) {
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                String localMax = parts[0];
                String answer = parts[1];

                if ("-1".equals(localMax)) {
                    localMax = String.valueOf((long) Math.pow(10, answer.length()) - 1);
                }
                guesses.add(new Guess(localMax, answer));
            }

            guesses.sort(new Comparator<Guess>() {
                @Override
                public int compare(Guess g1, Guess g2) {
                    int pos = 0;
                    while (pos < g1.max.length() && pos < g2.max.length()) {
                        if (g1.max.charAt(pos) == g2.max.charAt(pos)) {
                            pos++;
                        } else {
                            return g1.max.charAt(pos) - g2.max.charAt(pos);
                        }
                    }
                    return g1.max.length() - g2.max.length();
                }
            });

            List<Character> key = new ArrayList<>();
            for (Guess guess : guesses) {
                if (guess.max.startsWith("10") && guess.max.length() == guess.answer.length()) {
                    key.add(guess.answer.charAt(1));
                    break;
                }
            }

            for (int number = 1; number < 10; number++) {
                for (Guess guess : guesses) {
                    if (guess.max.length() != guess.answer.length()) continue;

                    for (int j = 0; j < guess.max.length(); j++) {
                        if (!key.contains(guess.answer.charAt(j))) {
                            key.add(guess.answer.charAt(j));
                            break;
                        }
                    }
                }
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
}