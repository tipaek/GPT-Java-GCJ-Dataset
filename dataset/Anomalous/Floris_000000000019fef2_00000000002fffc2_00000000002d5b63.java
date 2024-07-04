import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    private static final long M = 1000000000;

    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);

        int cases = sc.nextInt();
        long a = sc.nextLong();
        long b = sc.nextLong();

        for (int cs = 1; cs <= cases; cs++) {
            try {
                long startX, startY;
                do {
                    startX = (long) (Math.random() * 2 * M - M);
                    startY = (long) (Math.random() * 2 * M - M);
                } while ("MISS".equals(query(sc, startX, startY)));

                long right = findBoundary(sc, startX, startY, true, true);
                long left = findBoundary(sc, startX, startY, true, false);
                long down = findBoundary(sc, startX, startY, false, true);
                long up = findBoundary(sc, startX, startY, false, false);

                query(sc, (left + right) / 2, (up + down) / 2);
                throw new RuntimeException();
            } catch (ArrayStoreException e) {
                // Center found, continue to next case
            }
        }
    }

    private static long findBoundary(Scanner sc, long startX, long startY, boolean isHorizontal, boolean isPositive) {
        long primary = isHorizontal ? startX : startY;
        long secondary = isHorizontal ? startY : startX;
        long limit = isPositive ? M : -M;
        
        while (primary != (primary + limit) / 2) {
            long mid = (primary + limit) / 2;
            if ("MISS".equals(query(sc, isHorizontal ? mid : secondary, isHorizontal ? secondary : mid))) {
                limit = mid;
            } else {
                primary = mid;
            }
        }
        return primary;
    }

    private static String query(Scanner sc, long x, long y) {
        System.out.println(x + " " + y);
        System.out.flush();
        String response = sc.next();
        if ("CENTER".equals(response)) {
            throw new ArrayStoreException();
        }
        return response;
    }
}