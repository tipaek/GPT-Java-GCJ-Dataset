import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int r = in.nextInt();
        in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            int counter = 300;

            Boundary x = new Boundary(-1000000000, r == 999999995 ? -999999990 : -999999900);
            Boundary y = new Boundary(-1000000000, r == 999999995 ? -999999990 : -999999900);
            while (counter > 0) {
                int xGuess = x.getNextGuess();
                int yGuess = y.getNextGuess();

                if (x.isFound()) {
                    xGuess += r;
                } else {
                    yGuess = 0;
                }

                if (y.isFound()) {
                    yGuess += r;
                }

                System.out.println(xGuess + " " + yGuess);
                String result = in.nextLine();

                if (result.equals("CENTER")) {
                    break;
                }
                if (result.equals("HIT")) {
                    if (!x.isFound()) {
                        x.setHigher(xGuess);
                    } else {
                        y.setHigher(yGuess);
                    }
                } else if (result.equals("MISS")) {
                    if (!x.isFound()) {
                        x.setLower(xGuess+1);
                    } else {
                        y.setLower(yGuess+1);
                    }
                } else {
                    System.exit(0);
                }
                counter--;
            }
        }
    }

    static class Boundary {
        int lower;
        int higher;

        Boundary(int lower, int higher) {
            this.lower = lower;
            this.higher = higher;
        }

        public boolean isFound() {
            return lower == higher;
        }

        public int getNextGuess() {
            double guess = (lower + higher)/2.0;
            return (int)Math.floor(guess);
        }

        public int getLower() {
            return lower;
        }

        public void setLower(int lower) {
            this.lower = lower;
        }

        public int getHigher() {
            return higher;
        }

        public void setHigher(int higher) {
            this.higher = higher;
        }
    }
}