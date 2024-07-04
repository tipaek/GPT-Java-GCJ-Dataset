import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(reader.readLine());
            for (int i = 0; i < T; i++) {
                processCase(reader, i + 1);
            }
        }
    }

    private static void processCase(BufferedReader reader, int caseNum) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long x = Long.parseLong(tokenizer.nextToken());
        long y = Long.parseLong(tokenizer.nextToken());

        System.out.printf("Case #%d: ", caseNum);
        directions = new ArrayList<>();
        int result = findPath((int) x, (int) y, 0);

        if (result >= Integer.MAX_VALUE / 2) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder path = new StringBuilder();
            for (int i = 0; i < result; i++) {
                path.append(directions.get(directions.size() - i - 1));
            }
            System.out.println(path.toString());
        }
    }

    private static List<Character> directions;

    private static int findPath(int x, int y, int depth) {
        if (x == 0 && y == 0) return depth;
        if (depth > 1000) return Integer.MAX_VALUE / 2;

        int minSteps = Integer.MAX_VALUE / 2;
        Character direction = null;

        if ((x - 1) % 2 == 0 && y % 2 == 0) {
            int steps = findPath((x - 1) / 2, y / 2, depth + 1);
            if (steps < minSteps) {
                minSteps = steps;
                direction = 'E';
            }
        }
        if (x % 2 == 0 && (y - 1) % 2 == 0) {
            int steps = findPath(x / 2, (y - 1) / 2, depth + 1);
            if (steps < minSteps) {
                minSteps = steps;
                direction = 'N';
            }
        }
        if ((x + 1) % 2 == 0 && y % 2 == 0) {
            int steps = findPath((x + 1) / 2, y / 2, depth + 1);
            if (steps < minSteps) {
                minSteps = steps;
                direction = 'W';
            }
        }
        if (x % 2 == 0 && (y + 1) % 2 == 0) {
            int steps = findPath(x / 2, (y + 1) / 2, depth + 1);
            if (steps < minSteps) {
                minSteps = steps;
                direction = 'S';
            }
        }

        if (direction != null) {
            directions.add(direction);
        }

        return minSteps;
    }

    private static class Position {
        long x, y;

        Position(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Position)) return false;
            Position other = (Position) o;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}