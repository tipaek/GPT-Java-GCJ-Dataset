import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static int nextPowerOfTwo(long value) {
        int result = 1;
        while (result <= value) {
            result <<= 1;
        }
        return result;
    }

    private static boolean isPowerOfTwo(int value) {
        return (value & (value - 1)) == 0;
    }

    private static boolean isValidCombination(int xNext, int xDiff, int yNext, int yDiff) {
        int combined = xNext | xDiff | yNext | yDiff;
        return (xNext & xDiff) == 0 && (xNext & yNext) == 0 && (xNext & yDiff) == 0 &&
               (xDiff & yNext) == 0 && (xDiff & yDiff) == 0 && (yNext & yDiff) == 0 &&
               isPowerOfTwo(combined + 1);
    }

    private static String convertToDirections(int xNext, int xDiff, int yNext, int yDiff) {
        StringBuilder directions = new StringBuilder();
        int i = 1;
        while (i <= xNext || i <= xDiff || i <= yNext || i <= yDiff) {
            if ((i & xNext) != 0) {
                directions.append("E");
            } else if ((i & xDiff) != 0) {
                directions.append("W");
            } else if ((i & yNext) != 0) {
                directions.append("N");
            } else if ((i & yDiff) != 0) {
                directions.append("S");
            }
            i <<= 1;
        }
        return directions.toString();
    }

    private static String process(Scanner scanner) {
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int absX = Math.abs(X);
        int absY = Math.abs(Y);

        int xNext = nextPowerOfTwo(absX);
        int xDiff = xNext - absX;
        int yNext = nextPowerOfTwo(absY);
        int yDiff = yNext - absY;

        String result = null;

        if (isValidCombination(absX, 0, absY, 0)) {
            result = convertToDirections(absX, 0, absY, 0);
        } else if (isValidCombination(xNext, xDiff, absY, 0)) {
            result = convertToDirections(xNext, xDiff, absY, 0);
        } else if (isValidCombination(absX, 0, yNext, yDiff)) {
            result = convertToDirections(absX, 0, yNext, yDiff);
        } else if (isValidCombination(xNext, xDiff, yNext, yDiff)) {
            result = convertToDirections(xNext, xDiff, yNext, yDiff);
        }

        if (result == null) {
            return "IMPOSSIBLE";
        }

        if (X < 0) {
            result = swapDirections(result, "E", "W");
        }

        if (Y < 0) {
            result = swapDirections(result, "N", "S");
        }

        return result;
    }

    private static String swapDirections(String result, String from, String to) {
        return result.replace(from, "X").replace(to, from).replace("X", to);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in.available() > 0 ? System.in : 
            new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
        int testCaseCount = scanner.nextInt();
        for (int i = 1; i <= testCaseCount; i++) {
            System.out.format("Case #%d: %s\n", i, process(scanner));
        }
    }
}