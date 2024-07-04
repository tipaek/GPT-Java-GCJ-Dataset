import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private enum Direction {
        NORTH("N", 0, 1),
        EAST("E", 1, 0),
        SOUTH("S", 0, -1),
        WEST("W", -1, 0);

        private String name;
        private int x;
        private int y;

        Direction(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }

    private static List<Direction> directions = Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    private static List<Position> positions = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseAmount = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        scanner.nextLine();
        for (int caseNumber = 1; caseNumber <= caseAmount; caseNumber++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            if (targetX + targetY % 2 == 0) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                List<Direction> steps = null;
                positions.add(new Position(0, 0, new ArrayList<>()));
                int i = 0;
                do {
                    List<Position> currPositions = new ArrayList<>();
                    currPositions.addAll(positions);
                    positions.clear();
                    for (Position position : currPositions) {
                        steps = calc(targetX, targetY, position.x, position.y, position.steps, i);
                        if (steps != null) break;
                    }
                    i++;
                } while (steps == null);
                String out = "";
                for (Direction dir : steps) {
                    out += dir.name;
                }
                System.out.println("Case #" + caseNumber + ": " + out);
                positions.clear();
            }

        }

    }

    private static List<Direction> calc(int targetX, int targetY, int currentX, int currentY, List<Direction> steps, int i) {
        if (currentX == targetX && currentY == targetY) return steps;
        int stepSize = (int) Math.pow(2, i);
        for (Direction dir : directions) {
            List<Direction> newSteps = new ArrayList<>();
            newSteps.addAll(steps);
            newSteps.add(dir);
            positions.add(new Position(currentX + (dir.x * stepSize), currentY + (dir.y * stepSize), newSteps));
        }
        return null;
    }

    private static class Position {
        private int x;
        private int y;
        private List<Direction> steps;

        public Position(int x, int y, List<Direction> steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
}