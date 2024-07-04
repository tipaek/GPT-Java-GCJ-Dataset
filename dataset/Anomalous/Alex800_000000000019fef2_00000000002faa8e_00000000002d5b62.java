import java.util.*;
import java.io.*;

public class Solution {

    public static String findPath(int x, int y) {
        if (x % 2 == y % 2) {
            return "IMPOSSIBLE";
        }

        if (x <= 1 && y <= 1) {
            return (x == 1) ? "E" : "N";
        }

        if (x % 2 == 1) {
            if ((x - 1) % 4 == y % 4) {
                return "W" + findPath((x + 1) / 2, y / 2);
            } else {
                return "E" + findPath(x / 2, y / 2);
            }
        }

        if (y % 2 == 1) {
            if ((y - 1) % 4 == x % 4) {
                return "S" + findPath(x / 2, (y + 1) / 2);
            } else {
                return "N" + findPath(x / 2, y / 2);
            }
        }

        return "what the";
    }

    public static String adjustDirection(String path, boolean positiveX, boolean positiveY) {
        StringBuilder adjustedPath = new StringBuilder();

        for (char direction : path.toCharArray()) {
            switch (direction) {
                case 'N':
                    adjustedPath.append(positiveY ? 'N' : 'S');
                    break;
                case 'S':
                    adjustedPath.append(positiveY ? 'S' : 'N');
                    break;
                case 'W':
                    adjustedPath.append(positiveX ? 'W' : 'E');
                    break;
                case 'E':
                    adjustedPath.append(positiveX ? 'E' : 'W');
                    break;
            }
        }

        return adjustedPath.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();

            boolean positiveX = X >= 0;
            boolean positiveY = Y >= 0;

            X = Math.abs(X);
            Y = Math.abs(Y);

            String result = findPath(X, Y);
            if (!result.equals("IMPOSSIBLE")) {
                result = adjustDirection(result, positiveX, positiveY);
            }

            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }
}