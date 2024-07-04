
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String move = in.next();
            String result = solve(x, y, move);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(int x, int y, String move) {
        if (x == 0 && y == 0) {
            return "0";
        }
        int count = 1;
        for (char c : move.toCharArray()) {
            if (c == 'S') {
                y -= 1;
            } else if (c == 'N') {
                y += 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'W') {
                x -= 1;
            }
            final int distance = Math.abs(x) + Math.abs(y);
            if (distance <= count) {
                return count + "";
            }
            count++;
        }
        return "IMPOSSIBLE";
    }
}
