import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long X = in.nextLong();
            long Y = in.nextLong();

            System.out.println("Case #" + i + ": " + solve(X, Y));
        }
    }

    private static String solve(long X, long Y) {
        String result = solve(X, Y, 0, 0, 1, "");

        return result != null ? result : "IMPOSSIBLE";
    }

    private static String solve(long X, long Y, long curX, long curY, long step, String path) {
        if (X == curX && Y == curY) {
            return path;
        }

        long maxStep = Math.max(Math.abs(X), Math.abs(Y));
        if (2 * maxStep < step) return null;

        String northPath = solve(X, Y, curX, curY + step, step * 2, path + "N");
        String southPath = solve(X, Y, curX, curY - step, step * 2, path + "S");
        String westPath = solve(X, Y, curX + step, curY, step * 2, path+ "E");
        String eastPath = solve(X, Y, curX - step, curY, step * 2, path + "W");

        List<String> paths = Arrays.asList(northPath, southPath, westPath, eastPath);

        Optional<String> result = paths.stream().filter(Objects::nonNull).sorted((s1, s2) -> (Integer.valueOf(s1.length()).compareTo(s2.length()))).findFirst();

        return result.orElse(null);
    }
}
