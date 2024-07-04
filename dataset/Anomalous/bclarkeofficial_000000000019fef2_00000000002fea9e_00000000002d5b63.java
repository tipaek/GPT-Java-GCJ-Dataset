import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int radius = scanner.nextInt();
            scanner.nextInt(); // Skip the second input
            scanner.nextLine(); // Consume the newline

            int attempts = 300;
            Boundary xBoundary = new Boundary(-1000000000, radius == 999999995 ? -999999990 : -999999900);
            Boundary yBoundary = new Boundary(radius == 999999995 ? 999999990 : 999999900, 1000000000);

            while (attempts > 0) {
                int xGuess = xBoundary.nextGuess();
                int yGuess = yBoundary.nextGuess();

                if (xBoundary.isDetermined()) {
                    xGuess += radius;
                } else {
                    yGuess = 0;
                }

                if (yBoundary.isDetermined()) {
                    yGuess -= radius;
                }

                System.out.println(xGuess + " " + yGuess);
                String feedback = scanner.nextLine();

                if (feedback.equals("CENTER")) {
                    break;
                } else if (feedback.equals("HIT")) {
                    if (!xBoundary.isDetermined()) {
                        xBoundary.setUpperBound(xGuess);
                    } else {
                        yBoundary.setLowerBound(yGuess);
                    }
                } else if (feedback.equals("MISS")) {
                    if (!xBoundary.isDetermined()) {
                        xBoundary.setLowerBound(xGuess + 1);
                    } else {
                        yBoundary.setUpperBound(yGuess - 1);
                    }
                } else {
                    System.exit(0);
                }
                attempts--;
            }
        }
    }

    static class Boundary {
        private int lowerBound;
        private int upperBound;

        Boundary(int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        public boolean isDetermined() {
            return lowerBound == upperBound;
        }

        public int nextGuess() {
            double guess = (lowerBound + upperBound) / 2.0;
            return (int) (guess < 0 ? Math.floor(guess) : Math.ceil(guess));
        }

        public void setLowerBound(int lowerBound) {
            this.lowerBound = lowerBound;
        }

        public void setUpperBound(int upperBound) {
            this.upperBound = upperBound;
        }
    }
}