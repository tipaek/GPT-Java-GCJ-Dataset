import java.util.Scanner;

public class Solution {
    static String[] xDirections = {"E", "W"};
    static String[] yDirections = {"N", "S"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            System.out.print("Case #" + t + ": ");
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
                printPath(yBinary, Integer.toBinaryString(xOpposite), ySign, (xSign + 1) % 2, true, false);
                continue;
            }

            int yOpposite = calculateOpposite(yBinary, Math.abs(y));
            String yOppositeBinary = Integer.toBinaryString(yOpposite);
            if ((yOpposite & xOpposite) == 0) {
                printPath(yOppositeBinary, Integer.toBinaryString(xOpposite), (ySign + 1) % 2, (xSign + 1) % 2, true, true);
                continue;
            }

            if ((Math.abs(x) & yOpposite) == 0) {
                printPath(yOppositeBinary, xBinary, (ySign + 1) % 2, xSign, false, true);
                continue;
            }

            System.out.println("IMPOSSIBLE");
        }
    }

    public static void printPath(String yBinary, String xBinary, int ySign, int xSign, boolean xSub, boolean ySub) {
        int maxLength = Math.max(yBinary.length(), xBinary.length());
        int yTemp = 0, xTemp = 0;

        for (int x = xBinary.length() - maxLength, y = yBinary.length() - maxLength, i = 0; i < maxLength; i++, x++, y++) {
            if (x < 0 || xBinary.charAt(x) != '1') {
                if (ySub && yTemp != 0) {
                    System.out.print(yDirections[(ySign + 1) % 2]);
                } else {
                    System.out.print(yDirections[ySign]);
                    yTemp++;
                }
            } else {
                if (xSub && xTemp != 0) {
                    System.out.print(xDirections[(xSign + 1) % 2]);
                } else {
                    System.out.print(xDirections[xSign]);
                    xTemp++;
                }
            }
        }
        System.out.println();
    }

    public static int calculateOpposite(String binary, int original) {
        String largeBinary = "1" + binary;
        int tempLarge = Integer.parseInt(largeBinary, 2);
        int difference = tempLarge - original;
        return (difference | (difference - original));
    }
}