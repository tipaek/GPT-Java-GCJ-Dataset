import java.util.Scanner;

public class Solution {
    static final String[] xDir = {"E", "W"};
    static final String[] yDir = {"N", "S"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int xSign = (x < 0) ? 1 : 0;
            int ySign = (y < 0) ? 1 : 0;

            String xBinary = Integer.toBinaryString(Math.abs(x));
            String yBinary = Integer.toBinaryString(Math.abs(y));

            if ((Math.abs(x) & Math.abs(y)) == 0) {
                printPath(yBinary, xBinary, ySign, xSign, false, false);
                continue;
            }

            int xOpposite = calculateOpposite(xBinary, Math.abs(x));
            if ((Math.abs(y) & xOpposite) == 0) {
                printPath(yBinary, Integer.toBinaryString(xOpposite), ySign, xSign, true, false);
                continue;
            }

            int yOpposite = calculateOpposite(yBinary, Math.abs(y));
            String yOppositeBinary = Integer.toBinaryString(yOpposite);
            if ((yOpposite & xOpposite) == 0) {
                printPath(yOppositeBinary, Integer.toBinaryString(xOpposite), ySign, xSign, true, true);
                continue;
            }

            if ((Math.abs(x) & yOpposite) == 0) {
                printPath(yOppositeBinary, xBinary, ySign, xSign, false, true);
                continue;
            }

            System.out.println("IMPOSSIBLE");
        }
        scanner.close();
    }

    public static void printPath(String yBinary, String xBinary, int ySign, int xSign, boolean xSub, boolean ySub) {
        int maxLength = Math.max(yBinary.length(), xBinary.length());

        for (int xIndex = xBinary.length() - maxLength, yIndex = yBinary.length() - maxLength, i = 0; i < maxLength; i++, xIndex++, yIndex++) {
            if (xIndex < 0 || xBinary.charAt(xIndex) != '1') {
                if (ySub) {
                    System.out.print(yDir[(ySign + 1) % 2]);
                    ySub = false;
                } else {
                    System.out.print(yDir[ySign]);
                }
            } else {
                if (xSub) {
                    System.out.print(xDir[(xSign + 1) % 2]);
                    xSub = false;
                } else {
                    System.out.print(xDir[xSign]);
                }
            }
        }
        System.out.println();
    }

    public static int calculateOpposite(String binary, int original) {
        String extendedBinary = "1" + binary;
        int tempLarge = Integer.parseInt(extendedBinary, 2);
        int difference = tempLarge - original;
        return (difference | (difference - original));
    }
}