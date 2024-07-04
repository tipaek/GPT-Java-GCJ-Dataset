import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author itsypkin
 * @since 19.04.20
 */
public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int k = 1; k <= t; k++) {

            int r = in.nextInt();
            int c = in.nextInt();

            String result = solve(r, c);

            System.out.println("Case #" + k + ": " + result);
        }
    }




    private static String solve(int goalX, int goalY) {
        if (goalX == 0 && goalY == 0) return "";

        PriorityQueue<Move> queue = new PriorityQueue<>(100, new Comparator<Move>() {
            @Override
            public int compare(Move o1, Move o2) {
                return Double.compare(o1.distanceToGoal(goalX, goalY), o2.distanceToGoal(goalX, goalY));
            }
        });

        queue.add(new Move(0, 0, "", 1));
        int jumps = 0;

        while (!queue.isEmpty() && jumps < 1000000) {
            jumps++;
            Move move = queue.poll();
            if (move.x == goalX && move.y == goalY) {
                return move.history;
            }

            Move south = new Move(move.x, move.y - (move.nextStep), move.history + "S", move.nextStep * 2);
            Move north = new Move(move.x, move.y + (move.nextStep), move.history + "N", move.nextStep * 2);


            Move west = new Move(move.x - (move.nextStep), move.y, move.history + "W", move.nextStep * 2);
            Move east = new Move(move.x + (move.nextStep), move.y, move.history + "E", move.nextStep * 2);


            List<Move> c = Arrays.asList(south, north, west, east)
                .stream()
                .filter(m -> m.nextStep <= (double)(Integer.MAX_VALUE / 3))
                .collect(Collectors.toList());
            queue.addAll(c);
        }
//        System.out.println(queue.poll().nextStep);
        return "IMPOSSIBLE";

    }





    static class Move {
        int x;
        int y;

        String history;
        int nextStep;

        public double distanceToGoal(int goalX, int goalY) {
            int x1 = x;
            int x2 = goalX;
            int y1 = y;
            int y2 = goalY;

            int temp = (y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1);
            return Math.sqrt(temp);
        }

        public Move(int x, int y, String history, int nextStep) {
            this.x = x;
            this.y = y;
            this.history = history;
            this.nextStep = nextStep;
        }
    }

}
