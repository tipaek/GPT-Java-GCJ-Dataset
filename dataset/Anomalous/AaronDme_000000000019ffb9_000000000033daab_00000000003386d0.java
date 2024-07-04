import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            int n = readInt();
            int[][] positions = new int[n][2];
            HashMap<String, Integer> amounts = new HashMap<>();
            int max = 0;

            for (int j = 0; j < n; j++) {
                positions[j][0] = readInt();
                positions[j][1] = readInt();
            }

            for (int j = 0; j < n; j++) {
                HashSet<String> added = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    long x = positions[j][0] - positions[k][0];
                    long y = positions[j][1] - positions[k][1];

                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    if (y == 0) {
                        x = 1;
                    } else if (x == 0) {
                        y = 1;
                    } else {
                        long gcdValue = gcd(x, y);
                        x /= gcdValue;
                        y /= gcdValue;
                    }

                    String key = x + " " + y;
                    if (!added.contains(key)) {
                        amounts.put(key, amounts.getOrDefault(key, 0) + 1);
                        max = Math.max(max, amounts.get(key));
                        added.add(key);
                    }
                }
            }

            System.out.println(Math.min(max + 2, n));
        }
    }

    private static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        int c = skipWhitespace();
        boolean isNegative = (char) c == '-';
        int result = 0;
        if (isNegative) c = input.read();
        do {
            result = result * 10 + (c - '0');
            c = input.read();
        } while (c >= '0' && c <= '9');
        return isNegative ? -result : result;
    }

    private static int skipWhitespace() throws IOException {
        int c;
        while ((c = input.read()) == ' ' || c == '\n' || c == '\r') {
            // Skip whitespace
        }
        return c;
    }
}