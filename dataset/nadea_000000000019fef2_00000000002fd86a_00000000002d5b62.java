import java.util.Scanner;

public class Solution {
    static int[] powers = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912};

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int cases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < cases; i++) {
                StringBuilder result1 = new StringBuilder();
                String result = "";
                String[] pp = in.nextLine().trim().split(" +");
                int p1 = Integer.parseInt(pp[0]);
                int p2 = Integer.parseInt(pp[1]);

                if ((Math.abs(p1) > 1) && (Math.abs(Math.abs(p1) - Math.abs(p2)) == 1)) {
                    // on diagonal
                    go(p1, p2, getPos2(Math.abs(p1) + Math.abs(p2)), result1);
                    result = rotate(result1.toString());
                } else {
                    int ind = getPos(Math.abs(p1) + Math.abs(p2) + 1);
                    if (ind >= 0) {
                        //
                        go(p1, p2, ind, result1);
                        result = rotate(result1.toString());
                    } else {
                        result = "IMPOSSIBLE";
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static String rotate(String result1) {
        StringBuilder rr = new StringBuilder();
        for (int i = result1.length() - 1; i >= 0; i--) {
            rr.append(result1.charAt(i));
        }
        return rr.toString();
    }

    private static int getPos2(int i) {
        for (int j = 0; j < powers.length; j++) {
            if (i <= powers[j]) {
                return j - 1;
            }
        }
        return -1;
    }

    private static int getPos(int i) {
        for (int j = 0; j < powers.length; j++) {
            if (i == powers[j]) {
                return j - 1;
            }
        }
        return -1;
    }

    private static void go(int p1, int p2, int powerPos, StringBuilder result) {
        if (p1 == 0 && p2 == 0) {
            return;
        }
        if (Math.abs(p1) > Math.abs(p2)) {
            if (p1 < 0) {
                result.append("W");
                p1 += powers[powerPos];
                powerPos -= 1;
                go(p1, p2, powerPos, result);
            } else {
                result.append("E");
                p1 -= powers[powerPos];
                powerPos -= 1;
                go(p1, p2, powerPos, result);
            }
        } else {
            if (p2 < 0) {
                result.append("S");
                p2 += powers[powerPos];
                powerPos -= 1;
                go(p1, p2, powerPos, result);
            } else {
                result.append("N");
                p2 -= powers[powerPos];
                powerPos -= 1;
                go(p1, p2, powerPos, result);
            }
        }
    }
}