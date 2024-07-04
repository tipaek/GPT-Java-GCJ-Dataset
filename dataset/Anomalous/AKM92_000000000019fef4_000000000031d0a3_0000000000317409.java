import java.util.Scanner;

public class Solution {

    public static boolean isReachable(int x, int y, int x1, int y1, int len) {
        return ((Math.abs(x - x1) + Math.abs(y - y1) + 1) / 2) <= len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            String[] input = scanner.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String directions = input[2];

            int targetX = 0, targetY = 0;
            int len = directions.length();

            if (X == targetX && Y == targetY) {
                System.out.println("Case #" + (i + 1) + ": 0");
                continue;
            }

            if (isReachable(X, Y, targetX, targetY, len)) {
                int steps = 0;

                for (int j = 0; j < len; j++) {
                    steps++;
                    char direction = directions.charAt(j);

                    switch (direction) {
                        case 'N': Y++; break;
                        case 'S': Y--; break;
                        case 'E': X++; break;
                        case 'W': X--; break;
                    }

                    if (X == targetX && Y == targetY) {
                        break;
                    }

                    switch (direction) {
                        case 'N':
                        case 'S':
                            if (X > targetX) targetX++;
                            else if (X < targetX) targetX--;
                            else if (Y > targetY) targetY++;
                            else targetY--;
                            break;
                        case 'E':
                        case 'W':
                            if (Y > targetY) targetY++;
                            else if (Y < targetY) targetY--;
                            else if (X > targetX) targetX++;
                            else targetX--;
                            break;
                    }

                    if (X == targetX && Y == targetY) {
                        break;
                    }

                    if (!isReachable(X, Y, targetX, targetY, len - j - 1)) {
                        break;
                    }
                }

                if (X == targetX && Y == targetY) {
                    System.out.println("Case #" + (i + 1) + ": " + steps);
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}