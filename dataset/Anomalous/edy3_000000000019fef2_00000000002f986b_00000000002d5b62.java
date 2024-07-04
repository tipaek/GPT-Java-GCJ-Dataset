import java.util.*;

class Solution {
    private static final int COUNT = 32;
    private static final long[] POWERS = new long[COUNT];
    
    static {
        long val = 1;
        for (int i = 0; i < COUNT; ++i) {
            POWERS[i] = val;
            val <<= 1;
        }
    }

    private static String solve(long x, long y) {
        if (x == 0 && y == 0) {
            return "";
        }

        long absX = Math.abs(x);
        long absY = Math.abs(y);
        long lookingFor = absX + absY;
        int maxIndex = 0;

        for (int i = 0; i < COUNT; ++i) {
            if (POWERS[i] > lookingFor) {
                maxIndex = i;
                break;
            }
        }
        maxIndex--;

        StringBuilder sb = new StringBuilder();
        while (maxIndex >= 0) {
            long pow2 = POWERS[maxIndex];

            if (absX >= absY) {
                if (x > 0) {
                    sb.append("E");
                    x -= pow2;
                } else {
                    sb.append("W");
                    x += pow2;
                }
            } else {
                if (y > 0) {
                    sb.append("N");
                    y -= pow2;
                } else {
                    sb.append("S");
                    y += pow2;
                }
            }

            absX = Math.abs(x);
            absY = Math.abs(y);
            maxIndex--;
        }

        if (x != 0 || y != 0) {
            return "IMPOSSIBLE";
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();

            System.out.printf("Case #%d: %s%n", i, solve(x, y));
        }
    }
}