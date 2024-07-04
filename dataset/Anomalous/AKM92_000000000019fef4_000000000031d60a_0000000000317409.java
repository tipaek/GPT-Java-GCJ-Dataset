import java.util.Scanner;

public class Solution {

    public static boolean canReachInTime(int x, int y, int x1, int y1, int steps) {
        return ((Math.abs(x - x1) + Math.abs(y - y1) + 1) / 2) <= steps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String[] input = sc.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String directions = input[2];

            int targetX = 0, targetY = 0;
            int len = directions.length();

            if (X == targetX && Y == targetY) {
                System.out.println("Case #" + (i + 1) + ": 0");
                continue;
            }

            if (canReachInTime(X, Y, targetX, targetY, len)) {
                int steps = 0;

                for (int j = 0; j < len; j++) {
                    steps++;
                    
                    switch (directions.charAt(j)) {
                        case 'N': Y += 1; break;
                        case 'S': Y -= 1; break;
                        case 'E': X += 1; break;
                        case 'W': X -= 1; break;
                    }

                    if (X == targetX && Y == targetY) {
                        break;
                    }

                    if (directions.charAt(j) == 'N' || directions.charAt(j) == 'S') {
                        if (X != targetX) {
                            targetX += (X > targetX) ? 1 : -1;
                        } else {
                            targetY += (Y > targetY) ? 1 : -1;
                        }
                    } else if (directions.charAt(j) == 'E' || directions.charAt(j) == 'W') {
                        if (Y != targetY) {
                            targetY += (Y > targetY) ? 1 : -1;
                        } else {
                            targetX += (X > targetX) ? 1 : -1;
                        }
                    }

                    if (X == targetX && Y == targetY) {
                        break;
                    }

                    if (!canReachInTime(X, Y, targetX, targetY, len - j - 1)) {
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

        sc.close();
    }
}