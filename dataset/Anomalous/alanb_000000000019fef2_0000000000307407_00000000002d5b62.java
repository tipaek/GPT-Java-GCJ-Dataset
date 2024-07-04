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
            
            boolean isXNegative = x < 0;
            boolean isYNegative = y < 0;
            boolean isImpossible = false;

            if (isXNegative) x = -x;
            if (isYNegative) y = -y;

            if ((x & 1) == 1 && (y & 1) == 1) {
                System.out.println("IMPOSSIBLE");
                isImpossible = true;
            }

            if (isImpossible) continue;

            while ((x & y & yShift) == 0 && Integer.bitCount(x ^ y ^ yShift + 1) == 0) {
                yShift++;
                y++;
                if (yShift > 3000) {
                    isImpossible = true;
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }

            if (isImpossible) continue;

            int bitIndex = 0;
            while (bitIndex < 32 && ((x & (1 << bitIndex)) != 0 || (y & (1 << bitIndex)) != 0 || (yShift & (1 << bitIndex)) != 0)) {
                if ((x & (1 << bitIndex)) != 0) {
                    System.out.print(isXNegative ? "W" : "E");
                }
                if ((y & (1 << bitIndex)) != 0) {
                    System.out.print(isYNegative ? "S" : "N");
                }
                if ((yShift & (1 << bitIndex)) != 0) {
                    System.out.print(!isYNegative ? "S" : "N");
                }
                bitIndex++;
            }
            System.out.println();
        }
        scanner.close();
    }
}