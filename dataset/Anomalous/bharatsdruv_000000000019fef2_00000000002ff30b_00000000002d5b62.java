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
        int testCases = in.nextInt();
        for (int tc = 1; tc <= testCases; tc++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int absX = Math.abs(X);
            int absY = Math.abs(Y);
            int sum = absX + absY;
            String res = "";

            if (sum % 2 != 0) {
                switch (absX) {
                    case 1:
                        if (absY == 0) res = "E";
                        break;
                    case 3:
                        if (absY == 0) res = "EE";
                        break;
                    case 0:
                        if (absY == 1) res = "N";
                        else if (absY == 3) res = "NN";
                        break;
                    case 2:
                        if (absY == 1) res = "NE";
                        else if (absY == 3) res = "SEN";
                        break;
                    case 4:
                        if (absY == 1) res = "SNE";
                        else if (absY == 3) res = "NNE";
                        break;
                    case 1:
                        if (absY == 4) res = "WEN";
                        break;
                    case 3:
                        if (absY == 4) res = "EEN";
                        break;
                }

                if (X > 0 && Y < 0) {
                    res = exchangeNS(res);
                } else if (X < 0 && Y > 0) {
                    res = exchangeWE(res);
                } else if (X < 0 && Y < 0) {
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