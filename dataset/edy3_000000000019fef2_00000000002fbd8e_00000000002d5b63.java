import java.util.*;

class Solution {

    static long CAP = 1000000000L;

    static int guess(Scanner in, long x, long y) {
        System.out.println(String.format("%d %d", x, y));
        System.out.flush();
        String input = in.next();

        if ("CENTER".equals(input)) {
            return 0;
        } else if ("HIT".equals(input)) {
            return 1;
        } else if ("MISS".equals(input)) {
            return -1;
        }

        throw new IllegalStateException();
    }

    static void handle(Scanner in, long a, long b) {
        for (int i = -5; i <= 5; ++i) {
            for (int j = -5; j <= 5; ++j) {
                int result = guess(in, i, j);
                if (result == 0) {
                    return;
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        for (int i = 1; i <= n; ++i) {
            handle(in, a, b);
        }
    }
}