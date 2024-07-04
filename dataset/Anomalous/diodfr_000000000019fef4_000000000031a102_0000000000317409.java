import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= testCases; t++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String movements = scanner.next();
                scanner.nextLine();

                int steps = -1;
                int distanceCovered = 0;

                for (char direction : movements.toCharArray()) {
                    distanceCovered++;

                    switch (direction) {
                        case 'N':
                            y++;
                            break;
                        case 'S':
                            y--;
                            break;
                        case 'W':
                            x--;
                            break;
                        case 'E':
                            x++;
                            break;
                        default:
                            break;
                    }

                    if (distanceCovered >= Math.abs(x) + Math.abs(y)) {
                        steps = distanceCovered;
                        break;
                    }
                }

                if (steps < 0) {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + t + ": " + steps);
                }
            }
        }
    }
}