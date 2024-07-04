import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = getInt(input);
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            int n = getInt(input);
            int[][] positions = new int[n][2];
            Map<String, Integer> amounts = new HashMap<>();
            int max = 1;

            for (int j = 0; j < n; j++) {
                positions[j][0] = getInt(input);
                positions[j][1] = getInt(input);
            }

            for (int j = 0; j < n; j++) {
                boolean didAdd = false;
                for (int k = j + 1; k < n; k++) {
                    int x = positions[j][0] - positions[k][0];
                    int y = positions[j][1] - positions[k][1];
                    if (y < 0) {
                        x *= -1;
                        y *= -1;
                    }
                    if (y == 0) {
                        x = 1;
                    } else if (x == 0) {
                        y = 1;
                    } else {
                        int gcdValue = gcd(x, y);
                        x /= gcdValue;
                        y /= gcdValue;
                    }

                    String key = x + " " + y;
                    int count = amounts.getOrDefault(key, 0);
                    if (count > 0) {
                        didAdd = true;
                        count++;
                    } else {
                        count = 2;
                        didAdd = true;
                    }

                    amounts.put(key, count);
                    max = Math.max(max, count);
                }
            }

            System.out.println(Math.min(max + 2, n));
        }
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int getInt(BufferedReader input) throws IOException {
        int c = skipSpace(input);
        boolean isNeg = (char) c == '-';
        int result = 0;
        if (isNeg) {
            c = input.read();
        }
        while (c >= '0' && c <= '9') {
            result = result * 10 + (c - '0');
            c = input.read();
        }
        return isNeg ? -result : result;
    }

    private static int skipSpace(BufferedReader input) throws IOException {
        int c = input.read();
        while (c == ' ' || c == '\n' || c == '\r') {
            c = input.read();
        }
        return c;
    }
}