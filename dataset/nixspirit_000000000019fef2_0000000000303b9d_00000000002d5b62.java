import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int testNumber = 1; testNumber <= t; testNumber++)
        {
            int x = in.nextInt();
            int y = in.nextInt();

            System.out.println(String.format("Case #%d: %s", testNumber, solve(x, y)));
        }
    }

    public static String solve(int x, int y)
    {
        int totalUnits = Math.abs(x) + Math.abs(y);
        Integer[] steps = getSteps(totalUnits);
        Point current = new Point(x, y, Direction.N);

        Stack<Direction> path = new Stack<>();
        return tryPath(steps, steps.length - 1, current, path)
                ? toString(path)
                : "IMPOSSIBLE";
    }

    private static String toString(Stack<Direction> path)
    {
        StringBuilder s = new StringBuilder();
        while (!path.isEmpty())
            s.append(path.pop());

        return s.toString();
    }

    private static Integer[] getSteps(int totalUnits)
    {
        List<Integer> steps = new ArrayList<>();
        int counter = 1;
        steps.add(counter);

        int total = 1;
        while (total < totalUnits)
        {
            counter *= 2;
            steps.add(counter);
            total += counter;

        }

        return steps.toArray(new Integer[0]);
    }

    private static boolean tryPath(Integer[] steps, int i, Point current, Stack<Direction> path)
    {
        if (i < 0)
            return current.isOrigin();

        Point[] candidateSteps = getNextStep(current, steps[i]);
        for (Point candidateStep : candidateSteps)
        {
            if (candidateStep.distanceToOrigin() <= current.distanceToOrigin())
            {
                path.push(candidateStep.direction);
                if (tryPath(steps, i - 1, candidateStep, path))
                    return true;

                else
                    path.pop();
            }
        }

        return false;
    }

    private static Point[] getNextStep(Point current, int step)
    {
        // opposite directions used

        return new Point[]{
                new Point(current.x, current.y + step, Direction.S),
                new Point(current.x, current.y - step, Direction.N),
                new Point(current.x - step, current.y, Direction.E),
                new Point(current.x + step, current.y, Direction.W),
        };
    }

    enum Direction
    {
        N, S, E, W
    }

    static class Point
    {
        int x;
        int y;
        Direction direction;

        Point(int x, int y, Direction dir)
        {
            this.x = x;
            this.y = y;
            this.direction = dir;
        }

        public boolean isOrigin()
        {
            return x == 0 && y == 0;
        }

        public double distanceToOrigin()
        {
            double first = Math.sqrt(Math.abs(x));
            double second = Math.sqrt(Math.abs(y));
            return first + second;//Math.sqrt(result);
        }
    }


}
