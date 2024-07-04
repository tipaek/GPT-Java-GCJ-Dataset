import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String answer(int x, int y) {
        if (x % 2 == y % 2) {
            return "IMPOSSIBLE";
        }

        if (x <= 1 && y <= 1) {
            return x == 1 ? "E" : "N";
        }

        if (x % 2 == 1) {
            return (x - 1) % 4 == y % 4 ? "W" + answer((x + 1) / 2, y / 2) : "E" + answer(x / 2, y / 2);
        }

        if (y % 2 == 1) {
            return (y - 1) % 4 == x % 4 ? "S" + answer(x / 2, (y + 1) / 2) : "N" + answer(x / 2, y / 2);
        }

        return "what the";
    }

    public static String opposite(String s, boolean x, boolean y) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N':
                    ans.append(x ? "N" : "S");
                    break;
                case 'S':
                    ans.append(x ? "S" : "N");
                    break;
                case 'W':
                    ans.append(y ? "W" : "E");
                    break;
                case 'E':
                    ans.append(y ? "E" : "W");
                    break;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = in.nextInt();

            for (int t = 1; t <= T; ++t) {
                int X = in.nextInt();
                int Y = in.nextInt();

                boolean x = true;
                boolean y = true;

                if (X < 0) {
                    X = -X;
                    x = false;
                }

                if (Y < 0) {
                    Y = -Y;
                    y = false;
                }

                String ans = answer(X, Y);
                if (!ans.equals("IMPOSSIBLE")) {
                    ans = opposite(ans, x, y);
                }

                System.out.println("Case #" + t + ": " + ans);
            }
        }
    }
}