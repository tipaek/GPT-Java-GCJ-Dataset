import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();

            int currentX = x;
            int currentY = y;
            int time = 0;
            boolean reached = false;

            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);

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

                int distance = Math.abs(currentX) + Math.abs(currentY);

                if (distance <= j + 1) {
                    time = j + 1;
                    reached = true;
                    break;
                }
            }

            if (reached) {
                System.out.println("Case #" + i + ": " + time);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}