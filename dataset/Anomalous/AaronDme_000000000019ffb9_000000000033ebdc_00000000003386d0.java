import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int testCases = getInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            int n = getInt();
            int[][] positions = new int[n][2];

            Map<String, Integer> directionCounts = new HashMap<>();
            int maxCount = 0;

            for (int j = 0; j < n; j++) {
                positions[j][0] = getInt();
                positions[j][1] = getInt();
            }

            for (int j = 0; j < n; j++) {
                Set<String> addedDirections = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;

                    long dx = positions[j][0] - positions[k][0];
                    long dy = positions[j][1] - positions[k][1];

                    if (dy < 0) {
                        dx = -dx;
                        dy = -dy;
                    } else if (dy == 0 && dx < 0) {
                        dx = -dx;
                    }

                    long gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    String direction = dx + " " + dy;
                    if (addedDirections.contains(direction)) continue;

                    directionCounts.put(direction, directionCounts.getOrDefault(direction, 0) + 1);
                    maxCount = Math.max(maxCount, directionCounts.get(direction));
                    addedDirections.add(direction);
                }
            }

            System.out.println(Math.min(maxCount / 2 * 2 + 2, n));
        }
    }

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private static int getInt() throws IOException {
        int c = skipWhitespace();
        boolean isNegative = (char) c == '-';
        int result = 0;
        if (isNegative) {
            c = input.read();
        }
        do {
            result = result * 10 + (c - '0');
            c = input.read();
        } while (c >= '0' && c <= '9');
        return isNegative ? -result : result;
    }

    private static int skipWhitespace() throws IOException {
        int s = input.read();
        while (s == ' ' || s == '\n' || s == '\r') {
            s = input.read();
        }
        return s;
    }
}