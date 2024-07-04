import java.util.Scanner;

class Solution {

    static class CompletedException extends RuntimeException {
    }

    static final long CAP = 1000000000L;

    static boolean guess(Scanner in, long x, long y) {
        System.out.printf("%d %d%n", x, y);
        System.out.flush();
        String response = in.next();

        switch (response) {
            case "CENTER":
                throw new CompletedException();
            case "HIT":
                return true;
            case "MISS":
                return false;
            default:
                throw new IllegalStateException();
        }
    }

    static void handle(Scanner in, long a, long b) {
        long r = CAP - a;

        long minX = -2 * r;
        long maxX = 0;
        while (minX <= maxX) {
            long guessX = minX + (maxX - minX) / 2;
            if (guess(in, CAP + guessX, 0)) {
                minX = guessX + 1;
            } else {
                maxX = guessX - 1;
            }
        }

        long minY = -2 * r;
        long maxY = 0;
        while (minY <= maxY) {
            long guessY = minY + (maxY - minY) / 2;
            if (guess(in, 0, CAP + guessY)) {
                minY = guessY + 1;
            } else {
                maxY = guessY - 1;
            }
        }

        for (long i = maxX - 5; i <= maxX + 5; ++i) {
            for (long j = maxY - 5; j <= maxY + 5; ++j) {
                guess(in, r + i, r + j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        for (int i = 0; i < n; ++i) {
            try {
                handle(in, a, b);
            } catch (CompletedException e) {
                // Continue to the next test case
            }
        }
    }
}