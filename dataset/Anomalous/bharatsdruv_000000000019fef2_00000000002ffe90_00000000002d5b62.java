import java.util.Scanner;

class Solution {

    public static String exchangeWE(String input) {
        StringBuilder res = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == 'W' || c == 'E') {
                res.append(c == 'W' ? 'E' : 'W');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String exchangeNS(String input) {
        StringBuilder res = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == 'N' || c == 'S') {
                res.append(c == 'N' ? 'S' : 'N');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();

        for (int tc = 1; tc <= testcases; tc++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            int sum = absX + absY;

            String res = "";
            if (sum % 2 != 0) {
                if (absX == 1 && absY == 0) res = "E";
                else if (absX == 3 && absY == 0) res = "EE";
                else if (absX == 0 && absY == 1) res = "N";
                else if (absX == 2 && absY == 1) res = "NE";
                else if (absX == 4 && absY == 1) res = "SNE";
                else if (absX == 1 && absY == 2) res = "EN";
                else if (absX == 3 && absY == 2) res = "WNE";
                else if (absX == 0 && absY == 3) res = "NN";
                else if (absX == 2 && absY == 3) res = "SEN";
                else if (absX == 4 && absY == 3) res = "NNE";
                else if (absX == 1 && absY == 4) res = "WEN";
                else if (absX == 3 && absY == 4) res = "EEN";

                if (x > 0 && y < 0) {
                    res = exchangeNS(res);
                } else if (x < 0 && y > 0) {
                    res = exchangeWE(res);
                } else if (x < 0 && y < 0) {
                    res = exchangeWE(res);
                    res = exchangeNS(res);
                }

                System.out.println("Case #" + tc + ": " + res);
            } else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }

        in.close();
    }
}