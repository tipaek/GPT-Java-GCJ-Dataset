import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            String directions = scan.next();
            int steps = processDirections(x, y, directions);

            if (steps == -1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + steps);
            }
        }
    }

    private static int processDirections(int x, int y, String directions) {
        int count = 0;

        for (int j = 0; j < directions.length(); j++) {
            char direction = directions.charAt(j);
            count++;

            if (x == 0 && y == 0) {
                return count - 1;
            }

            if (x > 0) {
                x--;
                y += (direction == 'S') ? -1 : 1;
                continue;
            }

            if (direction == 'S') {
                y -= 1;
                if (y == 0) {
                    return count;
                }
                y -= (y > 0) ? 1 : 0;
                if (y == 0) {
                    return count;
                }
            } else {
                y += 1;
                if (y == 0) {
                    return count;
                }
                y -= (y > 0) ? 1 : 0;
                if (y == 0) {
                    return count;
                }
            }
        }

        return (x == 0 && y == 0) ? count : -1;
    }
}