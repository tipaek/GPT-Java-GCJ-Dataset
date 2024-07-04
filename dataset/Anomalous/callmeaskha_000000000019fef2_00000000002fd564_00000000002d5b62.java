import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = br.readLine().split(" ");
            int targetX = Integer.parseInt(input[0]);
            int targetY = Integer.parseInt(input[1]);

            if (findPath(targetX, targetY, testCase)) {
                continue;
            }

            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        }
    }

    private static boolean findPath(int targetX, int targetY, int testCase) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, "", 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == targetX && current.y == targetY) {
                System.out.println("Case #" + testCase + ": " + current.route);
                return true;
            }

            int nextStep = current.step + 1;
            if (nextStep > 10) {
                continue;
            }

            int stepSize = (int) Math.pow(2, nextStep - 1);

            queue.add(new Point(current.x, current.y + stepSize, current.route + "N", nextStep));
            queue.add(new Point(current.x + stepSize, current.y, current.route + "E", nextStep));
            queue.add(new Point(current.x, current.y - stepSize, current.route + "S", nextStep));
            queue.add(new Point(current.x - stepSize, current.y, current.route + "W", nextStep));
        }

        return false;
    }

    static class Point {
        int x, y, step;
        String route;

        Point(int x, int y, String route, int step) {
            this.x = x;
            this.y = y;
            this.route = route;
            this.step = step;
        }
    }
}