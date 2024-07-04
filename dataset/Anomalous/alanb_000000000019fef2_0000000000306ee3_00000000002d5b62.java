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
            int ys = 0;
            boolean xNegative = false;
            boolean yNegative = false;
            boolean impossible = false;

            if (x < 0) {
                x = -x;
                xNegative = true;
            }

            if (y < 0) {
                y = -y;
                yNegative = true;
            }

            System.out.print("Case #" + t + ": ");

            if ((x & 1) == 1 && (y & 1) == 1) {
                System.out.println("IMPOSSIBLE");
                impossible = true;
            }

            while ((x & y & ys) == 0 && Integer.bitCount(x ^ y ^ ys + 1) == 0) {
                ys++;
                y++;
                if (ys > 3000) {
                    System.out.println("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (impossible) continue;

            for (int i = 0; i < 32; i++) {
                if ((x & (1 << i)) != 0) {
                    System.out.print(xNegative ? "W" : "E");
                }
                if ((y & (1 << i)) != 0) {
                    System.out.print(yNegative ? "S" : "N");
                }
                if ((ys & (1 << i)) != 0) {
                    System.out.print(!yNegative ? "S" : "N");
                }
            }

            System.out.println();
        }

        scanner.close();
    }
}