import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            int xAway = x;
            int yAway = y;
            int minutesToReach = 0;
            boolean reached = false;

            for (char move : moves.toCharArray()) {
                switch (move) {
                    case 'N':
                        yAway++;
                        break;
                    case 'S':
                        yAway--;
                        break;
                    case 'E':
                        xAway++;
                        break;
                    case 'W':
                        xAway--;
                        break;
                }

                if (xAway == 0 && yAway == 0) {
                    minutesToReach++;
                    reached = true;
                    break;
                }

                if (xAway > 0) {
                    xAway--;
                } else if (yAway != 0) {
                    yAway = (yAway > 0) ? yAway - 1 : yAway + 1;
                }

                minutesToReach++;

                if (xAway == 0 && yAway == 0) {
                    reached = true;
                    break;
                }
            }

            if (reached) {
                System.out.println("Case #" + t + ": " + minutesToReach);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}