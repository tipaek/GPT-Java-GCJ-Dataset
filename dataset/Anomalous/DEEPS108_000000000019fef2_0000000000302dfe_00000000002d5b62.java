import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            results[i] = findPath(X, Y);
        }

        for (int i = 0; i < T; i++) {
            if (results[i].isEmpty()) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + results[i]);
            }
        }
    }

    public static String findPath(int X, int Y) {
        return recurse(0, 0, X, Y, 0, new StringBuilder());
    }

    public static String recurse(int x, int y, int X, int Y, int p, StringBuilder result) {
        if (x == X && y == Y) {
            return result.toString();
        }

        if (Math.abs(x) > Math.abs(X) * Math.pow(2, 5) || Math.abs(y) > Math.abs(Y) * Math.pow(2, 5)) {
            return "";
        }

        int value = (int) Math.pow(2, p);

        result.append('E');
        String eastPath = recurse(x + value, y, X, Y, p + 1, result);
        if (!eastPath.isEmpty()) return eastPath;
        result.setLength(result.length() - 1);

        result.append('W');
        String westPath = recurse(x - value, y, X, Y, p + 1, result);
        if (!westPath.isEmpty()) return westPath;
        result.setLength(result.length() - 1);

        result.append('N');
        String northPath = recurse(x, y + value, X, Y, p + 1, result);
        if (!northPath.isEmpty()) return northPath;
        result.setLength(result.length() - 1);

        result.append('S');
        String southPath = recurse(x, y - value, X, Y, p + 1, result);
        if (!southPath.isEmpty()) return southPath;
        result.setLength(result.length() - 1);

        return "";
    }
}