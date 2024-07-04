import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(reader.readLine());

        for (int testCaseIndex = 1; testCaseIndex <= numberOfTestCases; testCaseIndex++) {
            String[] input = reader.readLine().split(" ");
            int targetX = Integer.parseInt(input[0]);
            int targetY = Integer.parseInt(input[1]);

            boolean found = false;
            Queue<Point> queue = new ArrayDeque<>();
            queue.add(new Point(0, 0, "", 0));

            while (!queue.isEmpty()) {
                Point currentPoint = queue.poll();
                
                if (currentPoint.x == targetX && currentPoint.y == targetY) {
                    found = true;
                    System.out.println("Case #" + testCaseIndex + ": " + currentPoint.route);
                    break;
                }

                int nextStep = currentPoint.step + 1;
                if (nextStep > 4) {
                    break;
                }

                int stepSize = (int) Math.pow(2, nextStep - 1);

                queue.add(new Point(currentPoint.x, currentPoint.y + stepSize, currentPoint.route + "N", nextStep));
                queue.add(new Point(currentPoint.x + stepSize, currentPoint.y, currentPoint.route + "E", nextStep));
                queue.add(new Point(currentPoint.x, currentPoint.y - stepSize, currentPoint.route + "S", nextStep));
                queue.add(new Point(currentPoint.x - stepSize, currentPoint.y, currentPoint.route + "W", nextStep));
            }

            if (!found) {
                System.out.println("Case #" + testCaseIndex + ": IMPOSSIBLE");
            }
        }
    }

    static class Point {
        int x;
        int y;
        String route;
        int step;

        Point(int x, int y, String route, int step) {
            this.x = x;
            this.y = y;
            this.route = route;
            this.step = step;
        }
    }
}