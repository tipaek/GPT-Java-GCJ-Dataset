import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            int result = calculateMinimumTime(x, y, directions);

            if (result == -1) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }

        scanner.close();
    }

    private static int calculateMinimumTime(int x, int y, String directions) {
        int res = -1;

        for (int j = 0; j < directions.length(); j++) {
            char direction = directions.charAt(j);
            switch (direction) {
                case 'N':
                    y += 1;
                    break;
                case 'E':
                    x += 1;
                    break;
                case 'S':
                    y -= 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
            }

            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= j + 1) {
                res = j + 1;
                break;
            }
        }

        return res;
    }
}