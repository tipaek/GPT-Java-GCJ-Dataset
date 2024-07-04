import javafx.geometry.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;
    private static int X, Y;
    private static List<List<Position>> grid;

    private static void solveProblem(InputStream instr) {
        grid = buildGrid();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            X = sc.nextInt();
            Y = sc.nextInt();
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        String answer = "";
        int moveCount = -1;
        Position target = new Position(X, Y);
        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).contains(target)) {
                moveCount = i;
                break;
            }
        }
        if (moveCount == -1) {
            return "IMPOSSIBLE";
        }
        while (moveCount > 0) {
            int step = (int) Math.pow(2, moveCount - 1);
            List<Position> prev = grid.get(moveCount - 1);
            if (prev.contains(new Position(target.x - step, target.y))) {
                answer = "E" + answer;
                target = new Position(target.x - step, target.y);
            } else if (prev.contains(new Position(target.x + step, target.y))) {
                answer = "W" + answer;
                target = new Position(target.x + step, target.y);
            } else if (prev.contains(new Position(target.x, target.y - step))) {
                answer = "N" + answer;
                target = new Position(target.x, target.y - step);
            } else if (prev.contains(new Position(target.x, target.y + step))) {
                answer = "S" + answer;
                target = new Position(target.x, target.y + step);
            }
            moveCount--;
        }
        return answer;
    }

    private static List<List<Position>> buildGrid() {
        List<List<Position>> grid = new ArrayList<>();
        List<Position> zero = new ArrayList<>();
        zero.add(new Position(0, 0));
        grid.add(zero);
        for (int move = 1; move <= 10; move++) {
            int step = (int) Math.pow(2, move - 1);
            List<Position> prev = grid.get(move - 1);
            List<Position> row = new ArrayList<>();
            for (Position pos : prev) {
                row.add(new Position(pos.x - step, pos.y));
                row.add(new Position(pos.x + step, pos.y));
                row.add(new Position(pos.x, pos.y - step));
                row.add(new Position(pos.x, pos.y + step));
            }
            grid.add(row);
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
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "{ " + x + " " + y + " }";
        }
    }

    private static String joinValues(List<?> list, String delim) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static String joinValues(int[] arr, String delim) {
        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(delim));
    }

    private static int[] readInts(Scanner sc, int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printDebug(Object str) {
        if (debug) {
            System.out.println("DEBUG: " + str);
        }
    }

    public static void main(String[] args) throws Exception {
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }
}