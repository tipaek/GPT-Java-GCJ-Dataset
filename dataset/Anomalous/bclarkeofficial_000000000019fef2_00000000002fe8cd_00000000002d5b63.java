import java.util.*;
import java.io.*;

public class SolutionJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int radius = scanner.nextInt();
            scanner.nextInt(); // Skipping the second integer input
            scanner.nextLine(); // Consume the remaining newline
            int attempts = 300;

            Boundary xBoundary = new Boundary(-1000000000, radius == 999999995 ? -999999990 : -999999900);
            Boundary yBoundary = new Boundary(radius == 999999995 ? 999999990 : 999999900, 1000000000);

            while (attempts > 0) {
                int xGuess = xBoundary.getNextGuess();
                int yGuess = yBoundary.getNextGuess();

                if (xBoundary.isFound()) {
                    xGuess += radius;
                } else {
                    yGuess = 0;
                }

                if (yBoundary.isFound()) {
                    yGuess -= radius;
                }

                System.out.println(xGuess + " " + yGuess);
                String feedback = scanner.nextLine();
                if (feedback.equals("CENTER")) {
                    break;
                }
                if (feedback.equals("HIT")) {
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