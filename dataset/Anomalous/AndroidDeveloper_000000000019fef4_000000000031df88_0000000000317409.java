import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testCase = 0; testCase < numberOfTests; ++testCase) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String path = scanner.next();

            int maxSteps = path.length();
            boolean isImpossible = true;
            int shotTime = 0;

            int x = startX;
            int y = startY;

            for (int step = 0; step < maxSteps; step++) {
                char direction = path.charAt(step);

                switch (direction) {
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'S': y--; break;
                    case 'W': x--; break;
                }

                int distance = calculateManhattanDistance(x, y);

                if (distance <= (step + 1)) {
                    shotTime = Math.min(step, distance) + 1;
                    isImpossible = false;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", testCase + 1));
            } else {
                System.out.println(String.format("Case #%d: %d", testCase + 1, shotTime));
            }
        }
    }

    public static int calculateManhattanDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}