import java.util.Scanner;

public class Solution {

    public static int findSteps(int x, int y) {
        int distance = Math.abs(x) + Math.abs(y) - 1;
        int steps = 0;
        while (distance > 0) {
            steps++;
            distance -= Math.pow(2, steps);
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if ((x + y) % 2 == 0) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                int steps = findSteps(x, y);
                StringBuilder path = new StringBuilder();

                while (steps > -1) {
                    int absX = Math.abs(x);
                    int absY = Math.abs(y);

                    if (absX > absY) {
                        if (x > 0) {
                            x -= Math.pow(2, steps);
                            path.append("E");
                        } else {
                            x += Math.pow(2, steps);
                            path.append("W");
                        }
                    } else {
                        if (y > 0) {
                            y -= Math.pow(2, steps);
                            path.append("N");
                        } else {
                            y += Math.pow(2, steps);
                            path.append("S");
                        }
                    }
                    steps--;
                }

                if (x == 0 && y == 0) {
                    System.out.println("Case #" + (i + 1) + ": " + path.reverse().toString());
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                }
            }
        }
        scanner.close();
    }
}