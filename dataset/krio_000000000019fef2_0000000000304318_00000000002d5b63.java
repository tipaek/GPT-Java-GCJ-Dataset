import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final long L = 1000000000;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        long A = in.nextLong();
        long B = in.nextLong();
        for (int i = 1; i <= t; ++i) {
            solve(A, B, in);
        }
    }

    private static void solve(long A, long B, Scanner in) {
        long leftX = -L, rightX = L, topY = L, bottomY = -L;
        leftX = findPosition(leftX, 0, true, true, in);
        rightX = findPosition(rightX, 0, true, false, in);
        topY = findPosition(0, topY, false, false, in);
        bottomY = findPosition(0, bottomY, false, true, in);

        long centerX = (rightX + leftX) / 2;
        long centerY = (bottomY + topY) / 2;
        isMiss(centerX, centerY, in);
    }

    private static long findPosition(long x, long y, boolean isX, boolean isPlus, Scanner in) {
        int step = 1;
        while (isMiss(x, y, in)) {
            if (isX) {
                if (isPlus) {
                    x += step;
                } else {
                    x -= step;
                }
            } else {
                if (isPlus) {
                    y += step;
                } else {
                    y -= step;
                }
            }
            step *= 2;
        }

        if (step > 1) {
            do {
                if (isX) {
                    if (isPlus) {
                        x--;
                    } else {
                        x++;
                    }
                } else {
                    if (isPlus) {
                        y--;
                    } else {
                        y++;
                    }
                }

            } while(!isMiss(x, y, in));
        }
        return isX ? x : y;
    }

    private static boolean isMiss(long x, long y, Scanner in) {
        System.out.println(x + " " + y);
        String answer = in.next();

        return "MISS".equals(answer);
    }
}
