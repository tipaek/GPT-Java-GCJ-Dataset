import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder result = new StringBuilder();
            int testCases = parseInt(reader.readLine());

            for (int i = 1; i <= testCases; i++) {
                result.append("Case #").append(i).append(": ");
                StringTokenizer tokens = new StringTokenizer(reader.readLine());
                int x = parseInt(tokens.nextToken());
                int y = parseInt(tokens.nextToken());

                boolean isXNegative = x < 0;
                boolean isYNegative = y < 0;
                x = Math.abs(x);
                y = Math.abs(y);

                if (isReachable(x, y)) {
                    result.append(findPath(x, y, isXNegative, isYNegative));
                } else {
                    result.append("IMPOSSIBLE");
                }
                result.append("\n");
            }

            writer.write(result.toString());
        }
    }

    private static boolean isReachable(int x, int y) {
        return ((x + y + 1) & (x + y)) == 0 || 
               (x > y && ((-x + y + 1) & (-x + y)) == 0) || 
               (x < y && ((x - y + 1) & (x - y)) == 0);
    }

    private static String findPath(int x, int y, boolean isXNegative, boolean isYNegative) {
        StringBuilder path = new StringBuilder();
        int step = 1;

        while (x + y > 0) {
            if ((x & step) > 0) {
                if (x > y && ((x - 1) & x) != 0) {
                    path.append(isXNegative ? "E" : "W");
                } else {
                    path.append(isXNegative ? "W" : "E");
                }
                x -= (x & -x);
            } else {
                if (y > x && ((y - 1) & y) != 0) {
                    path.append(isYNegative ? "N" : "S");
                } else {
                    path.append(isYNegative ? "S" : "N");
                }
                y -= (y & -y);
            }
            step <<= 1;
        }

        if (x > y) {
            path.append(isXNegative ? "W" : "E");
        } else {
            path.append(isYNegative ? "S" : "N");
        }

        return path.toString();
    }
}