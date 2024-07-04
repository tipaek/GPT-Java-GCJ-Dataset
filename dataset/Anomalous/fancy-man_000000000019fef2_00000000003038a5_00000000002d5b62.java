import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static boolean solve(int caseNumber, int x, int y) {
        StringBuilder result = new StringBuilder();
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        boolean isXPositive = x > 0;
        boolean isYPositive = y > 0;

        while (absX > 0 || absY > 0) {
            int xBit = absX % 2;
            int yBit = absY % 2;

            if (xBit > 0 && yBit > 0) return false;

            absX /= 2;
            absY /= 2;

            int nextXBit = absX % 2;
            int nextYBit = absY % 2;

            boolean isShift = false;
            if (nextXBit > 0 && nextYBit > 0) {
                isShift = true;
                if (xBit > 0) {
                    absX++;
                } else {
                    absY++;
                }
            }

            if (isShift) {
                if (xBit > 0) {
                    result.append(isXPositive ? "W" : "E");
                } else {
                    result.append(isYPositive ? "S" : "N");
                }
            } else {
                if (xBit > 0) {
                    result.append(isXPositive ? "E" : "W");
                } else {
                    result.append(isYPositive ? "N" : "S");
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result);
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String[] tokens = scanner.nextLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);

            if (!solve(caseNumber, x, y)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}