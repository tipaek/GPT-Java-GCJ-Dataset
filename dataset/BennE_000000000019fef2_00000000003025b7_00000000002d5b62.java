
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    public static final String IMPOSSIBLE = "IMPOSSIBLE";
    public static final String X_PLUS = "E";
    public static final String X_MINUS = "W";
    public static final String Y_PLUS = "N";
    public static final String Y_MINUS = "S";


    private static String getSolution(final Scanner scanner) {
        final long x = scanner.nextLong();
        final long y = scanner.nextLong();

        long currentX = 0;
        long currentY = 0;

        long step = 1;
        StringBuilder result = new StringBuilder();
        while(true) {
            final long xDiff = Math.abs(x - currentX);
            final long yDiff = Math.abs(y - currentY);

            final long stepSize = (long) Math.pow(2, step-1);
            final long nextStepSize = (long) Math.pow(2, step);
            final long nextNextStepSize = (long) Math.pow(2, step+1);

            if(isImpossible(xDiff, yDiff, nextStepSize, 0)) {
                return IMPOSSIBLE;
            }

            if(xDiff % nextStepSize > 0) {
                if(xDiff - stepSize != 0
                        && isPossible(xDiff + stepSize, yDiff, nextNextStepSize, nextStepSize)) {
                    if(currentX < x) {
                        currentX -= stepSize;
                        result.append(X_MINUS);
                    } else {
                        currentX += stepSize;
                        result.append(X_PLUS);
                    }
                } else if(isPossible(xDiff - stepSize, yDiff, nextNextStepSize, nextStepSize)) {
                    if(currentX < x) {
                        currentX += stepSize;
                        result.append(X_PLUS);
                    } else {
                        currentX -= stepSize;
                        result.append(X_MINUS);
                    }
                } else {
                    return IMPOSSIBLE;
                }
            } else if(yDiff % nextStepSize > 0) {
                if(yDiff - stepSize != 0
                        && isPossible(xDiff, yDiff + stepSize, nextNextStepSize, nextStepSize)) {
                    if(currentY < y) {
                        currentY -= stepSize;
                        result.append(Y_MINUS);
                    } else {
                        currentY += stepSize;
                        result.append(Y_PLUS);
                    }
                } else if(isPossible(xDiff, yDiff - stepSize, nextNextStepSize, nextStepSize)) {
                    if(currentY < y) {
                        currentY += stepSize;
                        result.append(Y_PLUS);
                    } else {
                        currentY -= stepSize;
                        result.append(Y_MINUS);
                    }
                } else {
                    return IMPOSSIBLE;
                }
            } else {
                return IMPOSSIBLE;
            }

            if(currentX == x && currentY == y) {
                return result.toString();
            }

            step++;
            if(step > 40) {
                return IMPOSSIBLE;
            }
        }
    }

    public static boolean isPossible(long xDiff, long yDiff, long nextNextStepSize, long nextStepSize) {
        return !isImpossible(xDiff, yDiff, nextNextStepSize, nextStepSize);
    }

    public static boolean isImpossible(long xDiff, long yDiff, long nextNextStepSize, long nextStepSize) {
        if(xDiff == 0 && yDiff == 0) {
            return false;
        }
        if (nextStepSize != 0) {
                final boolean canFinish =
                        xDiff == nextStepSize ||
                        yDiff == nextStepSize;
            if (canFinish) {
                return false;
            }
        }

        final boolean bothMustStep =
                xDiff % nextNextStepSize > 0 &&
                yDiff % nextNextStepSize > 0;
        final boolean neitherCanStep =
                xDiff % nextNextStepSize == 0 &&
                yDiff % nextNextStepSize == 0;

        return bothMustStep || neitherCanStep;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
//        final Scanner scanner = new Scanner(new FileInputStream("A.in"));

        final int testCases = scanner.nextInt();
        for(int i = 1; i<= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }
}
