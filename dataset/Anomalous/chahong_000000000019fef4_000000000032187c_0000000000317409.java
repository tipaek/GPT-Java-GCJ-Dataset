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
            String path = sc.next();
            int steps = calculateSteps(path);

            System.out.print("Case #" + (i + 1) + ": ");
            if (steps == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(steps);
            }
        }
    }

    private static int calculateSteps(String path) {
        int steps = 0;

        for (int j = 0; j < path.length(); j++) {
            char direction = path.charAt(j);
            switch (direction) {
                case 'S': y--; break;
                case 'N': y++; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            steps++;

            if (x > 0) x--;
            else if (y > 0) y--;

            if (x == 0 && y == 0) {
                return steps;
            }

            if (j == path.length() - 1) {
                return -1;
            }
        }
        return -1;
    }
}