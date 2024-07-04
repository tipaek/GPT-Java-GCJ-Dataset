import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;
    private static int X, Y;
    private static List<List<Position>> grid;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }

    private static void solveProblem(InputStream input) {
        grid = initializeGrid();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(input)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            X = scanner.nextInt();
            Y = scanner.nextInt();
            Object result = processTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object processTestCase() {
        String result = "";
        int moves = -1;
        Position target = new Position(X, Y);
        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).contains(target)) {
                moves = i;
                break;
            }
        }
        if (moves == -1) {
            return "IMPOSSIBLE";
        }
        while (moves > 0) {
            int step = (int) Math.pow(2, moves - 1);
            List<Position> previous = grid.get(moves - 1);
            if (previous.contains(new Position(target.x - step, target.y))) {
                result = "E" + result;
                target = new Position(target.x - step, target.y);
            } else if (previous.contains(new Position(target.x + step, target.y))) {
                result = "W" + result;
                target = new Position(target.x + step, target.y);
            } else if (previous.contains(new Position(target.x, target.y - step))) {
                result = "N" + result;
                target = new Position(target.x, target.y - step);
            } else if (previous.contains(new Position(target.x, target.y + step))) {
                result = "S" + result;
                target = new Position(target.x, target.y + step);
            }
            moves--;
        }
        return result;
    }

    private static List<List<Position>> initializeGrid() {
        List<List<Position>> grid = new ArrayList<>();
        List<Position> initial = new ArrayList<>();
        initial.add(new Position(0, 0));
        grid.add(initial);
        for (int move = 1; move <= 10; move++) {
            int step = (int) Math.pow(2, move - 1);
            List<Position> previous = grid.get(move - 1);
            List<Position> current = new ArrayList<>();
            for (Position pos : previous) {
                current.add(new Position(pos.x - step, pos.y));
                current.add(new Position(pos.x + step, pos.y));
                current.add(new Position(pos.x, pos.y - step));
                current.add(new Position(pos.x, pos.y + step));
            }
            grid.add(current);
        }
        return grid;
    }

    private static class Position {
        long x, y;

        public Position(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position position = (Position) obj;
            return x == position.x && y == position.y;
        }

        @Override
        public String toString() {
            return "{ " + x + " " + y + " }";
        }
    }

    private static String joinValues(List<?> list, String delimiter) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    private static String joinValues(int[] array, String delimiter) {
        List<Object> list = new ArrayList<>();
        for (int value : array) {
            list.add(value);
        }
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    private static int[] readInts(Scanner scanner, int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printDebug(Object message) {
        if (debug) {
            System.out.println("DEBUG: " + message);
        }
    }
}