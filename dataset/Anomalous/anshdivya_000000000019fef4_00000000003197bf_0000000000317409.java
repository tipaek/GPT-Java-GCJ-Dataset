import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();

            int result = findMinimumTime(x, y, directions, 0);

            if (result == Integer.MAX_VALUE) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }

        scanner.close();
    }

    private static int findMinimumTime(int x, int y, String directions, int currentTime) {
        int minimumTime = Integer.MAX_VALUE;

        if (Math.abs(x) + Math.abs(y) <= currentTime) {
            minimumTime = currentTime;
        }

        if (directions.isEmpty()) {
            return minimumTime;
        } else {
            char direction = directions.charAt(0);
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
            return Math.min(minimumTime, findMinimumTime(x, y, directions.substring(1), currentTime + 1));
        }
    }
}