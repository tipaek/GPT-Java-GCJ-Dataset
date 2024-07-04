import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            String[] str = br.readLine().split(" ");

            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]);

            boolean isFound = false;

            ArrayDeque<Point> points = new ArrayDeque();

            points.addLast(new Point(0, 0, "", 0));

            while (!points.isEmpty()) {
                Point current = points.poll();
                if (current.X == X && current.Y == Y) {
                    isFound = true;
                    System.out.println("Case #" + (testCase + 1) + ": " + current.route);
                    break;
                }
                int curStep = current.stepVal + 1;
//                System.out.println("Current X: " + current.X + ", Current Y: " + current.Y + ", Current route: " + current.route +  ", Current stepVal: " + curStep);

                if (curStep > 8) {
                    break;
                }

                int curStepMod = (int)Math. pow(2, curStep - 1);

                points.addLast(new Point(current.X, current.Y + curStepMod, current.route + "N", curStep));
                points.addLast(new Point(current.X + curStepMod, current.Y, current.route + "E", curStep));
                points.addLast(new Point(current.X, current.Y - curStepMod, current.route + "S", curStep));
                points.addLast(new Point(current.X - curStepMod, current.Y, current.route + "W", curStep));

            }

            if (!isFound) {
                System.out.println("Case #" + (testCase + 1) + ": " + "IMPOSSIBLE");
            }

        }
    }

    static class Point {
        public int X;
        public int Y;
        String route = "";
        public int stepVal;
        public Point(int X, int Y, String route, int stepVal){
            this.X = X;
            this.Y = Y;
            this.route = route;
            this.stepVal = stepVal;
        }
    }
}
