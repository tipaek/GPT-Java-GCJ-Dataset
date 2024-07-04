import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            oneRun(i);
        }
    }

    private static void oneRun(int num) throws IOException {
        String[] tokens = br.readLine().split("\\s+");
        long X = clong(tokens[0]);
        long Y = clong(tokens[1]);
        boolean flipX = false;
        boolean flipY = false;

        if (X < 0) {
            flipX = true;
            X = -X;
        }

        if (Y < 0) {
            flipY = true;
            Y = -Y;
        }

        int smallestCard = Integer.MAX_VALUE;
        long[] bestNums = null;
        long large = Math.max(X, Y) * 2;

        for (long i = 0; i <= large; i++) {
            for (long j = 0; j <= large; j++) {
                int card = check(X, Y, i, j);
                if (card != -1 && card < smallestCard) {
                    smallestCard = card;
                    bestNums = new long[]{i, j, X+i, Y+j};
                }
            }
        }

        System.out.print(String.format("Case #%s: ", num));
        if (bestNums == null) {
            System.out.println("IMPOSSIBLE");
        } else {
            if (flipX) {
                long t = bestNums[0];
                bestNums[0] = bestNums[2];
                bestNums[2] = t;
            }
            if (flipY) {
                long t = bestNums[1];
                bestNums[1] = bestNums[3];
                bestNums[3] = t;
            }

            char[] cs = new char[]{'W', 'S', 'E', 'N'};

            for (int i = 0; i < smallestCard; i++) {
                for (int j = 0; j < cs.length; j++) {
                    if ((bestNums[j] & 1) == 1) {
                        System.out.print(cs[j]);
                    }
                    bestNums[j] >>= 1;
                }
            }
            System.out.println();
        }
    }

    private static int check(long x, long y, long a, long b) {
        long c = x + a;
        long d = y + b;

        if ((c & d) == 0 && (a & b) == 0 && ((c | d) & (a | b)) == 0) {
            BitSet D = BitSet.valueOf(new long[]{c | d | a | b});
            int firstClear = D.nextClearBit(0);
            if (D.nextSetBit(firstClear) == -1) {
                return firstClear;
            }
        }
        return -1;
    }

    static long clong(String s) {
        return Long.parseLong(s);
    }
}
