import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int steps = 0;
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();

            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);
                steps++;

                if (x > 0) {
                    x--;
                    y += (direction == 'S') ? -1 : 1;
                    continue;
                }

                if (direction == 'S') {
                    y--;
                    if (y == 0) break;
                    if (y > 0) y--;
                    if (y == 0) break;
                } else {
                    y++;
                    if (y == 0) break;
                    if (y > 0) y--;
                    if (y == 0) break;
                }
            }

            if (y != 0 || x != 0) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + steps);
            }
        }

        scanner.close();
    }
}