import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private static final PrintStream LOGGER = System.err;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            long x = SCANNER.nextLong();
            long y = SCANNER.nextLong();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (long bit = 0; (1L << bit) <= Math.abs(x) || (1L << bit) <= Math.abs(y); ++bit) {
                boolean bitInX = isBitSet(x, bit);
                boolean bitInY = isBitSet(y, bit);
                LOGGER.println("Check: " + (1L << bit) + ", X: " + x + " " + bitInX + ", Y: " + y + " " + bitInY);

                if (bitInX == bitInY) {
                    if (!bitInX || bit == 0) {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                    char lastDirection = result.charAt(result.length() - 1);
                    result.deleteCharAt(result.length() - 1);
                    LOGGER.println("Changing char " + lastDirection);

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

                if (bitInX) {
                    result.append(x < 0 ? "W" : "E");
                } else {
                    result.append(y < 0 ? "S" : "N");
                }
            }

            if (isPossible) {
                OUTPUT.println("Case #" + caseNumber + ": " + result);
            } else {
                OUTPUT.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isBitSet(long value, long bit) {
        return (Math.abs(value) & (1L << bit)) != 0;
    }
}