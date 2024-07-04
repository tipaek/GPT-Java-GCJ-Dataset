import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution { // Renamed to Solution
    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int ys = 0;
            System.out.print("Case #" + testCase + ": ");
            
            boolean isXNegative = x < 0;
            boolean isYNegative = y < 0;
            boolean isImpossible = false;
            
            if (isXNegative) {
                x = -x;
            }
            if (isYNegative) {
                y = -y;
            }
            
            if ((x & 1) == 1 && (y & 1) == 1) {
                System.out.println("IMPOSSIBLE");
                isImpossible = true;
            }
            
            while (!isImpossible && (x & y & ys) == 0 && Integer.bitCount(x ^ y ^ ys + 1) == 0) {
                ys++;
                y++;
            }
            
            if (!isImpossible) {
                int bitIndex = 0;
                while ((x & (1 << bitIndex)) != 0 || (y & (1 << bitIndex)) != 0 || (ys & (1 << bitIndex)) != 0) {
                    if ((x & (1 << bitIndex)) != 0) {
                        System.out.print(isXNegative ? "W" : "E");
                    }
                    if ((y & (1 << bitIndex)) != 0) {
                        System.out.print(isYNegative ? "S" : "N");
                    }
                    if ((ys & (1 << bitIndex)) != 0) {
                        System.out.print(isYNegative ? "N" : "S");
                    }
                    bitIndex++;
                }
                System.out.println();
            }
        }
        scan.close();
    }
}