import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int r = scanner.nextInt();
        scanner.nextInt(); // Ignore the third input
        scanner.nextLine(); // Move to the next line

        for (int i = 1; i <= t; i++) {
            int attempts = 300;

            Boundary xBoundary = new Boundary(-1000000000, r == 999999995 ? -999999990 : -999999900);
            Boundary yBoundary = new Boundary(r == 999999995 ? 999999990 : 999999900, 1000000000);

            while (attempts > 0) {
                int xGuess = xBoundary.getNextGuess();
                int yGuess = yBoundary.getNextGuess();

                if (xBoundary.isFound()) {
                    xGuess += r;
                    yGuess = 0;
                }

                if (yBoundary.isFound()) {
                    yGuess -= r;
                }

                System.out.println(xGuess + " " + yGuess);
                String feedback = scanner.nextLine();

                if (feedback.equals("CENTER")) {
                    break;
                } else if (feedback.equals("HIT")) {
                    if (!xBoundary.isFound()) {
                        xBoundary.setHigher(xGuess);
                    } else {
                        yBoundary.setLower(yGuess);
                    }
                } else if (feedback.equals("MISS")) {
                    if (!xBoundary.isFound()) {
                        xBoundary.setLower(xGuess + 1);
                    } else {
                        yBoundary.setHigher(yGuess - 1);
                    }
                } else {
                    System.exit(0);
                }
                attempts--;
            }
        }
    }

    static class Boundary {
        private int lower;
        private int higher;

        Boundary(int lower, int higher) {
            this.lower = lower;
            this.higher = higher;
        }

        public boolean isFound() {
            return lower == higher;
        }

        public int getNextGuess() {
            double guess = (lower + higher) / 2.0;
            return guess < 0 ? (int) Math.floor(guess) : (int) Math.ceil(guess);
        }

        public void setLower(int lower) {
            this.lower = lower;
        }

        public void setHigher(int higher) {
            this.higher = higher;
        }
    }
}