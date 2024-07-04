import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;
    private static final PrintStream LOG = System.err;

    public static void main(String[] args) {
        int t = IN.nextInt();
        for (int g = 1; g <= t; ++g) {
            long x = IN.nextLong();
            long y = IN.nextLong();
            StringBuilder sb = new StringBuilder();
            for (long bit = 0; (1<<bit) <= abs(x) || (1<<bit) <= abs(y); ++bit) {
                boolean haveX = testBit(x, bit);
                boolean haveY = testBit(y, bit);
                LOG.println("Check: " + (1<<bit) + ", X: " + x + " " + haveX + ", y: " + y + " " + haveY);
                if (haveX == haveY) {
                    if (!haveX || bit == 0) {
                        sb.replace(0, sb.length(), "IMPOSSIBLE");
                        break;
                    }
                    char last = sb.charAt(sb.length()-1);
                    sb.deleteCharAt(sb.length()-1);
                    LOG.println("Changing char " + last);
                    if (last == 'E') {
                        sb.append("W");
                        x += (1<<(bit-1));
                        haveX = false;
                    }
                    if (last == 'W') {
                        sb.append("E");
                        x -= (1<<(bit-1));
                        haveX = false;
                    }
                    if (last == 'N') {
                        sb.append("S");
                        y += (1<<(bit-1));
                        haveY = false;
                    }
                    if (last == 'S') {
                        sb.append("N");
                        y -= (1<<(bit-1));
                        haveY = false;
                    }
                }
                if (haveX) {
                    if (x < 0) {
                        sb.append("W");
                    } else {
                        sb.append("E");
                    }
                } else {
                    if (y < 0) {
                        sb.append("S");
                    } else {
                        sb.append("N");
                    }
                }
            }
            if (sb.length() == 0) {
                sb.append("IMPOSSIBLE");
            }
            OUT.println("Case #" + g + ": " + sb);
        }
    }

    private static boolean testBit(long val, long bit) {
        return (abs(val) & 1<<bit) != 0;
    }

    private static long abs(long val) {
        return (val < 0 ? -val : val);
    }
}