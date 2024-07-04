import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private static final PrintStream ERROR_LOG = System.err;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            long x = SCANNER.nextLong();
            long y = SCANNER.nextLong();
            StringBuilder result = new StringBuilder();

            for (long bit = 0; (1L << bit) <= Math.abs(x) || (1L << bit) <= Math.abs(y); ++bit) {
                boolean xHasBit = hasBit(x, bit);
                boolean yHasBit = hasBit(y, bit);

                ERROR_LOG.printf("Check: %d, X: %d %b, Y: %d %b%n", 1L << bit, x, xHasBit, y, yHasBit);

                if (xHasBit == yHasBit) {
                    if (!xHasBit || bit == 0) {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        break;
                    }
                    char lastDirection = result.charAt(result.length() - 1);
                    result.deleteCharAt(result.length() - 1);
                    ERROR_LOG.printf("Changing char %c%n", lastDirection);

                    switch (lastDirection) {
                        case 'E':
                            result.append("W");
                            x += (1L << (bit - 1));
                            break;
                        case 'W':
                            result.append("E");
                            x -= (1L << (bit - 1));
                            break;
                        case 'N':
                            result.append("S");
                            y += (1L << (bit - 1));
                            break;
                        case 'S':
                            result.append("N");
                            y -= (1L << (bit - 1));
                            break;
                    }
                }

                if (xHasBit) {
                    result.append(x < 0 ? "W" : "E");
                } else {
                    result.append(y < 0 ? "S" : "N");
                }
            }

            if (result.length() == 0) {
                result.append("IMPOSSIBLE");
            }

            OUTPUT.printf("Case #%d: %s%n", caseNum, result);
        }
    }

    private static boolean hasBit(long value, long bit) {
        return (Math.abs(value) & (1L << bit)) != 0;
    }
}