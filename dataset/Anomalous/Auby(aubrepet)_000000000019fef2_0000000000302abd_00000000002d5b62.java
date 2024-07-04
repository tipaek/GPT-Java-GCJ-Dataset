import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private void execute() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int totalDistance = Math.abs(width) + Math.abs(height);
            Queue<Integer> movements = generateMovements(totalDistance);
            String result = determinePath(movements, width, height);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private Queue<Integer> generateMovements(int totalDistance) {
        Queue<Integer> movements = new ArrayDeque<>();
        int power = 1;
        int cumulativeSum = power;
        while (cumulativeSum < totalDistance) {
            power *= 2;
            cumulativeSum += power;
        }
        while (power >= 1) {
            int direction = totalDistance < 0 ? -1 : 1;
            movements.add(direction * power);
            totalDistance -= direction * power;
            power /= 2;
        }
        return movements;
    }

    private String determinePath(Queue<Integer> movements, int width, int height) {
        StringBuilder path = new StringBuilder();
        int widthCorrection = width < 0 ? -1 : 1;
        int heightCorrection = height < 0 ? -1 : 1;

        while (!movements.isEmpty()) {
            int move = movements.poll();
            if (Math.abs(height - heightCorrection * move) < Math.abs(width - widthCorrection * move)) {
                move *= heightCorrection;
                height -= move;
                path.append(move > 0 ? 'N' : 'S');
            } else {
                move *= widthCorrection;
                width -= move;
                path.append(move > 0 ? 'E' : 'W');
            }
        }

        if (width != 0 || height != 0) {
            return "IMPOSSIBLE";
        }

        return path.reverse().toString();
    }
}