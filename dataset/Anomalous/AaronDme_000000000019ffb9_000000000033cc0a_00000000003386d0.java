import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int t = getInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            int n = getInt();
            int[][] positions = new int[n][2];
            HashMap<String, Integer> amounts = new HashMap<>();
            int max = 1;

            for (int j = 0; j < n; j++) {
                positions[j][0] = getInt();
                positions[j][1] = getInt();
            }

            for (int j = 0; j < n; j++) {
                boolean didAdd = false;
                for (int k = j + 1; k < n; k++) {
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
                    amounts.put(key, amounts.getOrDefault(key, 0) + (didAdd ? 1 : 2));
                    didAdd = true;
                    max = Math.max(max, amounts.get(key));
                }
            }

            System.out.println(Math.min(max + 2, n));
        }
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt() throws IOException {
        int c = skipSpace();
        boolean isNeg = (char) c == '-';
        int out = 0;

        if (isNeg) {
            c = input.read();
        }

        do {
            out = out * 10 + (c - '0');
            c = input.read();
        } while (c >= '0' && c <= '9');

        return isNeg ? -out : out;
    }

    public static int skipSpace() throws IOException {
        int s = input.read();
        while (s == ' ' || s == '\n' || s == '\r') {
            s = input.read();
        }
        return s;
    }
}