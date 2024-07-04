import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int t = getInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            int n = getInt();
            int[][] positions = new int[n][2];
            Map<String, Integer> amounts = new HashMap<>();
            int max = 0;

            for (int j = 0; j < n; j++) {
                positions[j][0] = getInt();
                positions[j][1] = getInt();
            }

            for (int j = 0; j < n; j++) {
                Set<String> added = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    
                    int x = positions[j][0] - positions[k][0];
                    int y = positions[j][1] - positions[k][1];

                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }

                    if (y == 0) {
                        x = 1;
                    } else if (x == 0) {
                        y = 1;
                    } else {
                        int gcd = gcd(x, y);
                        x /= gcd;
                        y /= gcd;
                    }

                    String key = x + " " + y;
                    if (!added.contains(key)) {
                        added.add(key);
                        amounts.put(key, amounts.getOrDefault(key, 0) + 1);
                        max = Math.max(max, amounts.get(key));
                    }
                }
            }

            System.out.println(Math.min(max + 2, n));
        }
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt() throws IOException {
        int c = skipSpace();
        boolean isNegative = (char) c == '-';
        int result = 0;
        if (isNegative) c = input.read();
        while (c >= '0' && c <= '9') {
            result = result * 10 + (c - '0');
            c = input.read();
        }
        return isNegative ? -result : result;
    }

    public static int skipSpace() throws IOException {
        int c = input.read();
        while (c == ' ' || c == '\n' || c == '\r') {
            c = input.read();
        }
        return c;
    }
}