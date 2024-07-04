import java.util.*;
import java.io.*;

public class Solution {
    public static int x = 0, y = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            String root = sc.next();
            System.out.print("Case #" + (i + 1) + ": ");

            int result = findStepsToOrigin(root);

            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    private static int findStepsToOrigin(String root) {
        if (x == 0 && y == 0) {
            return 0;
        }

        int steps = 0;
        for (int j = 0; j < root.length(); j++) {
            char direction = root.charAt(j);

            switch (direction) {
                case 'S':
                    y -= 1;
                    break;
                case 'N':
                    y += 1;
                    break;
                case 'E':
                    x += 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
            }

            steps++;

            if (x == 0 && y == 0) {
                return steps;
            }

            // Adjust coordinates towards the origin
            if (x > 0) {
                x--;
            } else if (x < 0) {
                x++;
            } else if (y > 0) {
                y--;
            } else if (y < 0) {
                y++;
            }

            if (x == 0 && y == 0) {
                return steps;
            }
        }

        return -1; // Return -1 if it's impossible to reach the origin
    }
}