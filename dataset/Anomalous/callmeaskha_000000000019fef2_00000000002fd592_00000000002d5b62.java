import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            String[] input = reader.readLine().split(" ");
            int targetX = Integer.parseInt(input[0]);
            int targetY = Integer.parseInt(input[1]);

            boolean found = false;
            Queue<Point> queue = new ArrayDeque<>();
            queue.add(new Point(0, 0, "", 0));

            while (!queue.isEmpty()) {
                Point current = queue.poll();

                if (current.x == targetX && current.y == targetY) {
                    found = true;
                    System.out.println("Case #" + (t + 1) + ": " + current.route);
                    break;
                }

                int nextStep = current.step + 1;
                if (nextStep > 8) {
                    break;
                }

                int stepDistance = (int) Math.pow(2, nextStep - 1);
                queue.add(new Point(current.x, current.y + stepDistance, current.route + "N", nextStep));
                queue.add(new Point(current.x + stepDistance, current.y, current.route + "E", nextStep));
                queue.add(new Point(current.x, current.y - stepDistance, current.route + "S", nextStep));
                queue.add(new Point(current.x - stepDistance, current.y, current.route + "W", nextStep));
            }

            if (!found) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
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