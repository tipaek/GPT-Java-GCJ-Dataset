import java.util.*;

class Solution {

    static class CompletedException extends RuntimeException {

    }

    static long CAP = 1000000000L;

    static boolean guess(Scanner in, long x, long y) {
        System.out.println(String.format("%d %d", x, y));
        System.out.flush();
        String input = in.next();

        if ("CENTER".equals(input)) {
            throw new CompletedException();
        } else if ("HIT".equals(input)) {
            return true;
        } else if ("MISS".equals(input)) {
            return false;
        }

        throw new IllegalStateException();
    }

    static void handle(Scanner in, long a, long b) {

        long r = CAP - a;

        long minX = (r * 2) * -1;
        long maxX = 0;
        while (minX <= maxX) {
            long guessX = minX + (maxX - minX) / 2;
            boolean hit = guess(in, CAP + guessX, 0);
            if (hit) {
                minX = guessX + 1;
            } else {
                maxX = guessX - 1;
            }
        }

        long minY = (r * 2) * -1;
        long maxY = 0;
        while (minY <= maxY) {
            long guessY = minY + (maxY - minY) / 2;
            boolean hit = guess(in, 0, CAP + guessY);
            if (hit) {
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
        for (int i = 1; i <= n; ++i) {
            try {
                handle(in, a, b);
            } catch (CompletedException e) {
                continue;
            }
        }
    }
}