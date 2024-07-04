import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String directions = scanner.next();
            int[][] positions = new int[directions.length()][2];
            
            int currentX = n;
            int currentY = m;
            int step = 0;

            for (char direction : directions.toCharArray()) {
                switch (direction) {
                    case 'N':
                        currentY++;
                        break;
                    case 'S':
                        currentY--;
                        break;
                    case 'E':
                        currentX++;
                        break;
                    case 'W':
                        currentX--;
                        break;
                }
                positions[step][0] = currentX;
                positions[step][1] = currentY;
                step++;
            }

            int time = 1;
            boolean reachable = false;

            for (int[] position : positions) {
                if (Math.abs(position[0]) + Math.abs(position[1]) <= time) {
                    reachable = true;
                    break;
                }
                time++;
            }

            if (reachable) {
                System.out.println("Case #" + i + ": " + time);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}