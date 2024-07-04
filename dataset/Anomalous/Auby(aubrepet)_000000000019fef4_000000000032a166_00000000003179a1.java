import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
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
                String record = parts[1];

                if ("-1".equals(localMax)) {
                    localMax = String.valueOf((long) Math.pow(10, record.length()) - 1);
                }
                guesses.add(new Guess(localMax, record));
            }

            guesses.sort(new Comparator<Guess>() {
                @Override
                public int compare(Guess g1, Guess g2) {
                    int pos = 0;
                    while (pos < g1.max.length() - 1 && pos < g2.max.length() - 1) {
                        if (g1.max.charAt(pos) == g2.max.charAt(pos)) {
                            pos++;
                        } else {
                            return g1.max.charAt(pos) - g2.max.charAt(pos);
                        }
                    }
                    if (g1.max.length() != g2.max.length()) {
                        return g1.max.length() - g2.max.length();
                    }
                    return g1.max.charAt(pos) - g2.max.charAt(pos);
                }
            });

            List<Character> key = new ArrayList<>();
            for (Guess guess : guesses) {
                if (guess.max.startsWith("10") && guess.max.length() == guess.answer.length()) {
                    key.add(guess.answer.charAt(1));
                    break;
                }
            }

            int number = 1;
            while (number < 10) {
                for (Guess guess : guesses) {
                    if (guess.max.length() != guess.answer.length()) {
                        continue;
                    }
                    boolean found = false;
                    for (int i = 0; i < guess.max.length(); i++) {
                        if (guess.max.charAt(i) - '0' != number || key.contains(guess.answer.charAt(i))) {
                            if (guess.max.charAt(i) != '1') {
                                break;
                            }
                        } else {
                            number++;
                            key.add(guess.answer.charAt(i));
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (Character ch : key) {
                result.append(ch);
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