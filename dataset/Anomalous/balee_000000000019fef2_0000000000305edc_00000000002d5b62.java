import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static int nextPowerOfTwo(long value) {
        if (value == 0) return 0;
        int result = 1;
        while (result <= value) {
            result *= 2;
        }
        return result;
    }

    private static boolean isPowerOfTwo(int value) {
        if (value == 1) return true;
        if (value % 2 == 1) return false;
        return isPowerOfTwo(value / 2);
    }

    private static boolean isValidCombination(int xNext, int xDiff, int yNext, int yDiff) {
        if ((xNext & xDiff) != 0 || (xNext & yNext) != 0 || (xNext & yDiff) != 0 || 
            (xDiff & yNext) != 0 || (xDiff & yDiff) != 0 || (yNext & yDiff) != 0) {
            return false;
        }
        int combined = xNext | xDiff | yNext | yDiff;
        combined++;
        return isPowerOfTwo(combined);
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
            i *= 2;
        }
        return directions.toString();
    }

    private static String processInput(Scanner input) {
        int X = input.nextInt();
        int Y = input.nextInt();

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

        if (result == null) return "IMPOSSIBLE";

        if (X < 0) {
            result = swapDirections(result, "E", "W");
        }
        if (Y < 0) {
            result = swapDirections(result, "S", "N");
        }

        return result;
    }

    private static String swapDirections(String result, String direction1, String direction2) {
        result = result.replace(direction1, "X");
        result = result.replace(direction2, direction1);
        result = result.replace("X", direction2);
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in.available() > 0 ? System.in : 
            new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.format("Case #%d: %s\n", i, processInput(input));
        }
    }
}