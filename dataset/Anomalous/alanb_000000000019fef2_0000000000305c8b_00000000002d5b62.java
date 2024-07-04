import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int yShift = 0;
            System.out.print("Case #" + t + ": ");
            boolean isXNegative = false;
            boolean isYNegative = false;
            boolean isImpossible = false;

            if (x < 0) {
                x = -x;
                isXNegative = true;
            }
            if (y < 0) {
                y = -y;
                isYNegative = true;
            }

            if ((x & 1) == 1 && (y & 1) == 1) {
                System.out.print("IMPOSSIBLE");
                isImpossible = true;
            }

            while ((x & y & yShift) == 0 && Integer.bitCount((x ^ y ^ yShift) + 1) == 0) {
                yShift++;
                y++;
            }

            int bitPosition = 0;

            if (isImpossible) {
                System.out.println();
                continue;
            }

            while ((x & (1 << bitPosition)) != 0 || (y & (1 << bitPosition)) != 0 || (yShift & (1 << bitPosition)) != 0) {
                if ((x & (1 << bitPosition)) != 0) {
                    System.out.print(isXNegative ? "W" : "E");
                }
                if ((y & (1 << bitPosition)) != 0) {
                    System.out.print(isYNegative ? "S" : "N");
                }
                if ((yShift & (1 << bitPosition)) != 0) {
                    System.out.print(!isYNegative ? "S" : "N");
                }
                bitPosition++;
            }

            System.out.println();
        }

        scanner.close();
    }
}