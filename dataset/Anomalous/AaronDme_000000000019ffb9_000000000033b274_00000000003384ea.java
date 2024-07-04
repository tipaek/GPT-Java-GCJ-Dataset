import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        long t = getLong(input);
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            long l = getLong(input);
            long r = getLong(input);

            long n = 1;
            while (Math.max(l, r) >= n) {
                if (l >= r) {
                    l -= n;
                } else {
                    r -= n;
                }
                n++;
            }

            System.out.println((n - 1) + " " + l + " " + r);
        }
    }

    private static long getLong(BufferedReader input) throws IOException {
        int c = skipSpace(input);
        boolean isNeg = (char) c == '-';
        long out = 0;

        if (isNeg) {
            c = input.read();
        }

        do {
            out *= 10;
            out += c - '0';
            c = input.read();
        } while (c >= '0' && c <= '9');

        return isNeg ? -out : out;
    }

    private static int skipSpace(BufferedReader input) throws IOException {
        int s = input.read();
        while (s == ' ' || s == '\n' || s == '\r') {
            s = input.read();
        }
        return s;
    }
}