import java.io.*;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            writer.print("Case #" + (i + 1) + ": ");
            new Solution().solve();
        }
        writer.flush();
    }

    private void solve() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String directions = scanner.next().trim();

        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);

            switch (direction) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                writer.println(i + 1);
                return;
            }
        }
        writer.println("IMPOSSIBLE");
    }
}