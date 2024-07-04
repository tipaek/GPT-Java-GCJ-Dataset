import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int A = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int B = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            try {
                solve(in, A, B);
            } catch (CenterException ignored) {
            }
        }

    }

    private static void solve(Scanner sc, int A, int B) throws CenterException {

        int size = (int) Math.pow(10, 9);
        int quarter = size / 2;
        int x = 0;
        int y = 0;
        int[][] candidates = new int[][]{
                new int[]{0, 0},
                new int[]{quarter, quarter},
                new int[]{quarter, -quarter},
                new int[]{-quarter, quarter},
                new int[]{-quarter, -quarter},
        };

        for (int[] candidate : candidates) {
            if (shoot(candidate[0], candidate[1], sc)) {
                x = candidate[0];
                y = candidate[1];
                break;
            }
        }

        int guessY = y;
        int guessX = x;

        int leftBound = binarySearchFindHighest(-size, guessX, (guess) -> !shoot(guess, guessY, sc)) + 1;
        int rightBound = binarySearchFindHighest(guessX, size, (guess) -> shoot(guess, guessY, sc));


        int lowBound = binarySearchFindHighest(-size, guessY, (guess) -> !shoot(guessX, guess, sc)) + 1;
        int upperBound = binarySearchFindHighest(guessX, size, (guess) -> shoot(guessX, guess, sc));

        int centerY = (upperBound + lowBound) / 2;
        int centerX = (rightBound + leftBound) / 2;

        shoot(centerX, centerY, sc);

        throw new RuntimeException("That should have been the center?");
        // Start by finding a hit

    }

    private static int binarySearchFindHighest(int low, int high, Function<Integer, Boolean> predictor) {
        if (predictor.apply(high)) {
            return high;
        }

        while (high - low > 1) {
            int middle = (high + low)/2;
            if (predictor.apply(middle)) {
                low = middle;
            } else {
                high = middle;
            }
        }

        return low;
    }


    private static boolean shoot(int x, int y, Scanner sc) throws CenterException {
        System.out.println(String.format("%s %s", x, y));
        System.out.flush();

        String result = sc.nextLine().trim();
        if (result.equals("CENTER")) {
            throw new CenterException();
        }
        return result.equals("HIT");
    }

    private static class CenterException extends RuntimeException {

    }

}
  