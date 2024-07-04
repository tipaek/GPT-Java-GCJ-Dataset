import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            boolean reached = false;
            int steps = 0;

            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);

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

                if (Math.abs(x) + Math.abs(y) <= j + 1) {
                    reached = true;
                    steps = j + 1;
                    break;
                }
            }

            if (reached) {
                System.out.println("Case #" + i + ": " + steps);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}