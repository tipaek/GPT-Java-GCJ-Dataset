import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = t;

        while (t > 0) {
            long x = scn.nextInt();
            long y = scn.nextInt();
            String s = determineDirection(x, y);

            System.out.println("Case #" + (tc - t + 1) + ": " + s);
            t--;
        }
    }

    private static String determineDirection(long x, long y) {
        if (x == 0) {
            return determineVerticalDirection(y);
        } else if (y == 0) {
            return determineHorizontalDirection(x);
        } else {
            return determineDiagonalDirection(x, y);
        }
    }

    private static String determineVerticalDirection(long y) {
        switch ((int) y) {
            case 1:
                return "N";
            case -1:
                return "S";
            case 3:
                return "NN";
            case -3:
                return "SS";
            default:
                return "IMPOSSIBLE";
        }
    }

    private static String determineHorizontalDirection(long x) {
        switch ((int) x) {
            case 1:
                return "E";
            case -1:
                return "W";
            case 3:
                return "EE";
            case -3:
                return "WW";
            default:
                return "IMPOSSIBLE";
        }
    }

    private static String determineDiagonalDirection(long x, long y) {
        if (x == 1 && y == 2) return "EN";
        if (x == 1 && y == -2) return "ES";
        if (x == -1 && y == 2) return "WN";
        if (x == -1 && y == -2) return "WS";
        if (x == 2 && y == 1) return "NE";
        if (x == 2 && y == -1) return "SE";
        if (x == -2 && y == 1) return "NW";
        if (x == -2 && y == -1) return "SW";
        if (x == 2 && y == 3) return "SEN";
        if (x == -2 && y == 3) return "SWN";
        if (x == 2 && y == -3) return "NES";
        if (x == -2 && y == -3) return "NWS";
        if (x == 3 && y == 2) return "WNE";
        if (x == 3 && y == -2) return "WSE";
        if (x == -3 && y == 2) return "ENW";
        if (x == -3 && y == -2) return "ESW";
        return "IMPOSSIBLE";
    }
}