import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testNr = 1; testNr <= t; testNr++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String path = scanner.nextLine().trim();
            int m = path.length();
            boolean isDoable = false;

            for (int i = 0; i < m; i++) {
                char dir = path.charAt(i);
                x = moveX(x, dir);
                y = moveY(y, dir);

                int availableSteps = i + 1;
                if (distanceFromOrigin(x, y) <= availableSteps) {
                    System.out.println("Case #" + testNr + ": " + availableSteps);
                    isDoable = true;
                    break;
                }
            }

            if (!isDoable) {
                System.out.println("Case #" + testNr + ": IMPOSSIBLE");
            }
        }
    }

    private static int moveX(int x, char dir) {
        if (dir == 'E') {
            x += 1;
        } else if (dir == 'W') {
            x -= 1;
        }
        return x;
    }

    private static int moveY(int y, char dir) {
        if (dir == 'N') {
            y += 1;
        } else if (dir == 'S') {
            y -= 1;
        }
        return y;
    }

    private static int distanceFromOrigin(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}
