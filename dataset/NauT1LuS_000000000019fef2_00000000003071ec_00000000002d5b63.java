import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//
        int cases = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        cases:
        for (int c = 1; c <= cases; c++) {
            for (long i = -1000_000_000; i < 1000_000_000; i += 250_000_000) {
                long x = i + 125_000_000;
                for (long j = -1000_000_000; j < 1000_000_000; j += 250_000_000) {
                    long y = j + 125_000_000;
                    String result = getPoint(in, x, y);
                    if ("CENTER".equals(result.trim())) {
                        continue cases;
                    }
                    if ("HIT".equals(result.trim())) {
                        findBounds(in, x, y, b);
                        continue cases;
                    }

                }
            }
        }

    }

    private static String getPoint(Scanner in, long x, long y) {
        System.out.print(x);
        System.out.print(" ");
        System.out.print(y);
        System.out.println();
        return in.next();
    }

    private static void findBounds(Scanner in, long x, long y, long b) {
        long l = binarySearch(in, x - b * 2, x, y, true);
        if (l == Long.MIN_VALUE) return;
        long r = binarySearchEnd(in, x, x + b * 2, y, true);
        if (r == Long.MIN_VALUE) return;
        long mx = (r + l) / 2;
        long u = binarySearch(in, y - b * 2, y, mx, false);
        if (u == Long.MIN_VALUE) return;
        long d = binarySearchEnd(in, y, y + b * 2, mx, false);
        if (d == Long.MIN_VALUE) return;
        //center??
        long my = (u + d) / 2;

        int radius = 6;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                String result = getPoint(in, mx - radius / 2 + i, my - radius / 2 + j);
                if ("CENTER".equals(result.trim())) {
                    return;
                }
            }
        }
        System.out.println("FAILED");
    }

    private static long binarySearch(Scanner in, long left, long right, long other,  boolean xory) {
        right = Math.max(right, -1000_000_000);
        right = Math.min(right,1000_000_000);

        left = Math.max(left, -1000_000_000);
        left = Math.min(left,1000_000_000);

        while (left + 1 < right) {
            long mid = (right + left) / 2;
            mid = Math.max(mid, -1000_000_000);
            mid = Math.min(mid,1000_000_000);
            String result;

            if(xory){
                result = getPoint(in, mid, other);
            }else{
                result = getPoint(in, other, mid);
            }

            if ("CENTER".equals(result.trim())) {
                return Long.MIN_VALUE;
            }
            if ("HIT".equals(result.trim())) {
                right = mid;
            }
            if ("MISS".equals(result.trim())) {
                left = mid;
            }
        }
        return right;
    }

    private static long binarySearchEnd(Scanner in, long down, long upper, long other, boolean xory) {
        upper = Math.max(upper, -1000_000_000);
        upper = Math.min(upper,1000_000_000);

        down = Math.max(down, -1000_000_000);
        down = Math.min(down,1000_000_000);

        while (down + 1 < upper) {
            long mid = (upper + down) / 2;
            mid = Math.max(mid, -1000_000_000);
            mid = Math.min(mid,1000_000_000);
            String result;
            if(xory){
                result = getPoint(in, mid, other);
            }else{
                result = getPoint(in, other, mid);
            }

            if ("CENTER".equals(result.trim())) {
                return Long.MIN_VALUE;
            }
            if ("HIT".equals(result.trim())) {
                down = mid;
            }
            if ("MISS".equals(result.trim())) {
                upper = mid;
            }
        }
        return upper;
    }


}
