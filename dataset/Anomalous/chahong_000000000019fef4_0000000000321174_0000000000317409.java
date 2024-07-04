import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static int x = 0, y = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            String directions = sc.next();
            int steps = calculateSteps(directions);

            System.out.print("Case #" + (i + 1) + ": ");
            if (steps == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(steps);
            }
        }
    }

    private static int calculateSteps(String directions) {
        if (x == 0 && y == 0) {
            return 0;
        }

        for (int j = 0; j < directions.length(); j++) {
            char move = directions.charAt(j);

            switch (move) {
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            if (x > 0) x--;
            else if (y > 0) y--;

            if (x == 0 && y == 0) {
                return j + 1;
            }
        }

        return -1;
    }
}