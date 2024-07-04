import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int A = 0;
    static int B = 0;

    public static int[] findHorizontal(int x, int y, Scanner in) {
        int leftBoundary = Math.max(x - 2 * A, -1000000000);
        int rightBoundary = x;
        int left = binarySearchHorizontal(leftBoundary, rightBoundary, y, in, 1);
        if (left == 1000000001) {
            return new int[]{left, left};
        }

        rightBoundary = x;
        leftBoundary = Math.min(x + 2 * A, 1000000000);
        int right = binarySearchHorizontal(rightBoundary, leftBoundary, y, in, -1);
        if (right == 1000000001) {
            return new int[]{right, right};
        }

        return new int[]{left, right};
    }

    public static int findVertical(int x, int y, Scanner in) {
        int lowerBoundary = Math.max(y - 2 * A, -1000000000);
        int upperBoundary = y;
        return binarySearchVertical(lowerBoundary, upperBoundary, x, in, 1);
    }

    public static int binarySearchVertical(int lowerBoundary, int upperBoundary, int x, Scanner in, int step) {
        if (lowerBoundary == upperBoundary) {
            return lowerBoundary;
        }

        int mid = (lowerBoundary + upperBoundary) / 2;
        String guess = x + " " + mid;
        System.out.println(guess);
        String response = in.next();

        if (response.equals("CENTER")) {
            return 1000000001;
        } else if (response.equals("HIT")) {
            guess = x + " " + (mid - step);
            System.out.println(guess);
            String secondResponse = in.next();
            if (secondResponse.equals("HIT")) {
                return binarySearchVertical(lowerBoundary, mid - step, x, in, step);
            } else {
                return mid;
            }
        } else {
            guess = x + " " + (mid + step);
            System.out.println(guess);
            String secondResponse = in.next();
            if (secondResponse.equals("HIT")) {
                return mid + step;
            }
            return binarySearchVertical(mid + step, upperBoundary, x, in, step);
        }
    }

    public static int binarySearchHorizontal(int lowerBoundary, int upperBoundary, int y, Scanner in, int step) {
        if (lowerBoundary == upperBoundary) {
            return lowerBoundary;
        }

        int mid = (lowerBoundary + upperBoundary) / 2;
        String guess = mid + " " + y;
        System.out.println(guess);
        String response = in.next();

        if (response.equals("CENTER")) {
            return 1000000001;
        } else if (response.equals("HIT")) {
            guess = (mid - step) + " " + y;
            System.out.println(guess);
            String secondResponse = in.next();
            if (secondResponse.equals("HIT")) {
                return binarySearchHorizontal(lowerBoundary, mid - step, y, in, step);
            } else {
                return mid;
            }
        } else {
            guess = (mid + step) + " " + y;
            System.out.println(guess);
            String secondResponse = in.next();
            if (secondResponse.equals("HIT")) {
                return mid + step;
            }
            return binarySearchHorizontal(mid + step, upperBoundary, y, in, step);
        }
    }

    public static void solve(String guess, Scanner in) {
        int spaceIndex = guess.indexOf(" ");
        int x = Integer.parseInt(guess.substring(0, spaceIndex));
        int y = Integer.parseInt(guess.substring(spaceIndex + 1));

        int[] horizontal = findHorizontal(x, y, in);
        if (horizontal[0] == 1000000001) {
            return;
        }

        int lower = findVertical(x, y, in);
        if (lower == 1000000001) {
            return;
        }

        int upper = y + (x - horizontal[0]) * (horizontal[1] - x) / (y - lower);
        int centerX = (horizontal[0] + horizontal[1]) / 2;
        int centerY = (lower + upper) / 2;

        String finalGuess = centerX + " " + centerY;
        System.out.println(finalGuess);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();

        for (int t = 1; t <= T; ++t) {
            String[] guesses = {
                "1000000000 1000000000",
                "-1000000000 1000000000",
                "1000000000 -1000000000",
                "-1000000000 -1000000000"
            };
            boolean hit = false;
            int index = 0;

            while (!hit && index < guesses.length) {
                String guess = guesses[index];
                System.out.println(guess);
                String response = in.next();
                if (response.equals("CENTER")) {
                    return;
                } else if (response.equals("HIT")) {
                    hit = true;
                }
                index++;
            }

            solve(guesses[--index], in);
        }
        in.close();
    }
}