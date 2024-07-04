import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(x, y));
        }
    }

    public static String solve(int x, int y) {
        boolean positiveX = x >= 0;
        boolean positiveY = y >= 0;
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        int maxBits = Math.max(Integer.toBinaryString(absX).length(), Integer.toBinaryString(absY).length());
        int reverseX = 0, reverseY = 0;

        for (int i = 0; i < maxBits; i++) {
            int bitX = (absX >> i) & 1;
            int bitY = (absY >> i) & 1;

            if (bitX == bitY) {
                if (i == 0) return "IMPOSSIBLE";
                if (((absX >> (i - 1)) & 1) == 1) {
                    reverseX += (1 << (i - 1));
                    absX += (1 << (i - 1));
                }
                if (((absY >> (i - 1)) & 1) == 1) {
                    reverseY += (1 << (i - 1));
                    absY += (1 << (i - 1));
                }
            }
            maxBits = Math.max(Integer.toBinaryString(absX).length(), Integer.toBinaryString(absY).length());
        }

        StringBuilder result = new StringBuilder();
        if (!positiveX) {
            int temp = absX;
            absX = reverseX;
            reverseX = temp;
        }
        if (!positiveY) {
            int temp = absY;
            absY = reverseY;
            reverseY = temp;
        }

        for (int i = 0; i < maxBits; i++) {
            if (((absX >> i) & 1) == 1) {
                result.append('E');
            } else if (((reverseX >> i) & 1) == 1) {
                result.append('W');
            } else if (((absY >> i) & 1) == 1) {
                result.append('N');
            } else if (((reverseY >> i) & 1) == 1) {
                result.append('S');
            }
        }

        return result.toString();
    }
}