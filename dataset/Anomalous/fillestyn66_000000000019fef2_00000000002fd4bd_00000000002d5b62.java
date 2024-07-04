import java.util.*;
import java.io.*;

public class Solution {

    private static final String[] UP_DOWN = {"S", "N"};
    private static final String[] LEFT_RIGHT = {"W", "E"};

    private static boolean isPowerOfTwo(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }

    private static String getResult(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        
        if (isPowerOfTwo(x + y)) {
            return "IMPOSSIBLE";
        }
        
        boolean isLinearRule = x == 0 || y == 0;
        if (Math.abs(absX - absY) != 1 && !isLinearRule) {
            return "IMPOSSIBLE";
        }

        StringBuilder result = new StringBuilder(1000);
        int divisionTotal = absX + absY - 1;

        if (x == 0) {
            String direction = (y > 0) ? "S" : "N";
            while (divisionTotal >= 1) {
                result.append(direction);
                divisionTotal /= 2;
            }
        } else if (y == 0) {
            String direction = (x > 0) ? "E" : "W";
            while (divisionTotal >= 1) {
                result.append(direction);
                divisionTotal /= 2;
            }
        } else {
            int udCounter = (y > 0) ? 0 : 1;
            int lrCounter = (x > 0) ? 1 : 0;
            boolean shiftUp = absY > absX;

            while (divisionTotal >= 1) {
                if (shiftUp) {
                    shiftUp = false;
                    result.append(UP_DOWN[udCounter % 2]);
                    udCounter++;
                } else {
                    shiftUp = true;
                    result.append(LEFT_RIGHT[lrCounter % 2]);
                    lrCounter++;
                }
                divisionTotal /= 2;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = getResult(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}