import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final byte CENTER = 0;
    private static final byte HIT = 1;
    private static final byte MISS = 2;

    private static final int MAX = 1000000000;
    private static final int MIN = -1000000000;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for (int i = 0; i < t; ++i) {
            solve(in, b);
        }
    }

    private static void solve(Scanner in, int b) {
        int x0 = findBoundary(in, MAX, -1);
        int x1 = findBoundary(in, MIN, 1);
        int xCenter = x0 - x1;

        int y0 = findBoundary(in, MAX, -1, xCenter);
        int y1 = findBoundary(in, MIN, 1, xCenter);
        int yCenter = y0 - y1;

        byte result = query(in, xCenter, yCenter);
        if (result != CENTER) {
            throw new RuntimeException("ERROR");
        }
    }

    private static int findBoundary(Scanner in, int start, int direction) {
        return findBoundary(in, start, direction, 0);
    }

    private static int findBoundary(Scanner in, int start, int direction, int fixedCoord) {
        int offset = 0;
        int prevMiss = -1;

        while (offset < 100) {
            byte response = query(in, start + direction * offset, fixedCoord);
            if (response == HIT) {
                offset = 100;
            } else if (response == MISS) {
                prevMiss = offset;
                offset += 2;
            }
        }

        if (prevMiss > 0) {
            byte response = query(in, start + direction * (prevMiss + 1), fixedCoord);
            if (response == MISS) {
                prevMiss++;
            }
        }

        return prevMiss + 1;
    }

    private static byte query(Scanner in, int x, int y) {
        System.out.println(x + " " + y);
        System.out.flush();

        String response = in.next();
        switch (response) {
            case "CENTER":
                return CENTER;
            case "HIT":
                return HIT;
            case "MISS":
                return MISS;
            case "WRONG":
                throw new RuntimeException("Exit");
            default:
                throw new RuntimeException("Malformed");
        }
    }
}