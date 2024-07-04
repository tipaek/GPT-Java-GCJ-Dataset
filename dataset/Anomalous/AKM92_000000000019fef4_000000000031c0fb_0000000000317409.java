import java.util.Scanner;

public class Solution {

    public static boolean isPossible(int x, int y, int x1, int y1, int len) {
        return (Math.abs(x - x1) + Math.abs(y - y1) + 1) % 2 <= len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < testCases; t++) {
            String[] input = scanner.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String directions = input[2];
            int targetX = 0, targetY = 0;

            if (X == targetX && Y == targetY) {
                System.out.println("Case #" + (t + 1) + ": 0");
                continue;
            }

            if (isPossible(X, Y, targetX, targetY, directions.length())) {
                int steps = 0;

                for (int j = 0; j < directions.length(); j++) {
                    steps++;
                    char direction = directions.charAt(j);

                    switch (direction) {
                        case 'N': Y++; break;
                        case 'S': Y--; break;
                        case 'E': X++; break;
                        case 'W': X--; break;
                    }

                    if (X == targetX && Y == targetY) break;

                    if (!isPossible(X, Y, targetX, targetY, directions.length() - j - 1)) break;
                }

                if (X == targetX && Y == targetY) {
                    System.out.println("Case #" + (t + 1) + ": " + steps);
                } else {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}