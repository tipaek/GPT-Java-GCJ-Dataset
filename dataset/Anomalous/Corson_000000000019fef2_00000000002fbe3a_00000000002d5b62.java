import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int tc = 0; tc < testCases; tc++) {
            int celX = in.nextInt();
            int celY = in.nextInt();
            boolean xNegative = celX < 0;
            boolean yNegative = celY < 0;

            celX = Math.abs(celX);
            celY = Math.abs(celY);

            boolean xOdd = celX % 2 == 1;
            boolean yOdd = celY % 2 == 1;

            if (xOdd && yOdd) {
                System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder output = new StringBuilder();
            if (xOdd) {
                if (!canAdjust(celX, celY, xNegative, yNegative, output, true)) {
                    System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                    continue;
                }
            } else if (yOdd) {
                if (!canAdjust(celX, celY, xNegative, yNegative, output, false)) {
                    System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                    continue;
                }
            } else {
                generateOutput(celX, celY, xNegative, yNegative, output);
            }

            System.out.println("Case #" + (tc + 1) + ": " + output.toString());
        }
    }

    private static boolean canAdjust(int celX, int celY, boolean xNegative, boolean yNegative, StringBuilder output, boolean adjustX) {
        int adjustedX = adjustX ? celX + 1 : celX;
        int adjustedY = adjustX ? celY : celY + 1;

        if ((adjustedX & adjustedY) != 0) {
            adjustedX = adjustX ? celX - 1 : celX;
            adjustedY = adjustX ? celY : celY - 1;

            if ((adjustedX & adjustedY) != 0) {
                return false;
            }
        }

        if (adjustX) {
            celX = adjustedX;
        } else {
            celY = adjustedY;
        }

        generateOutput(celX, celY, xNegative, yNegative, output);
        return true;
    }

    private static void generateOutput(int celX, int celY, boolean xNegative, boolean yNegative, StringBuilder output) {
        int stepsX = countBits(celX);
        int stepsY = countBits(celY);

        for (int i = 0; i < stepsX; i++) {
            output.append(xNegative ? 'W' : 'E');
        }
        for (int i = 0; i < stepsY; i++) {
            output.append(yNegative ? 'S' : 'N');
        }
    }

    private static int countBits(int number) {
        return Integer.bitCount(number);
    }
}