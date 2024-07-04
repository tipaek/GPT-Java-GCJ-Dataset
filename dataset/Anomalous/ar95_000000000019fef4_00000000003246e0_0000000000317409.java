import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        new Solver().solve();
    }
}

class Solver {
    void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after the integer input

        for (int tc = 1; tc <= t; tc++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after the integer input
            String path = scanner.nextLine();

            int steps = 0;
            boolean reached = false;

            for (char move : path.toCharArray()) {
                switch (move) {
                    case 'N':
                        if (y < 0) y++;
                        break;
                    case 'S':
                        if (y > 0) y--;
                        break;
                    case 'E':
                        if (x < 0) x++;
                        break;
                    case 'W':
                        if (x > 0) x--;
                        break;
                }

                steps++;

                if (x == 0 && y == 0) {
                    reached = true;
                    break;
                }
            }

            if (reached) {
                System.out.println("Case #" + tc + ": " + steps);
            } else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }
    }
}