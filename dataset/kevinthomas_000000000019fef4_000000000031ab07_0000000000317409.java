import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int i = 0; i < testCount; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String path = scanner.next();
                int n = solve(x, y, path, 0);
                String sol = "IMPOSSIBLE";
                if (n >= 0) sol = n + "";
                System.out.println("Case #" + (i + 1) + ": " + sol);
            }
        }
    }

    private static int solve(int x, int y, String path, int dist) {
        if (x == 0 && y == 0) return 0;
        int d = 0;
        int charCount = path.length();
        for (int i = 0; i < charCount; i++) {
            d++;
            char c = path.charAt(i);
            if (c == 'N') y++;
            if (c == 'S') y--;
            if (c == 'W') x--;
            if (c == 'E') x++;
            if (Math.abs(x) + Math.abs(y) <= d) return d;
        }
        return -1;
    }
}
