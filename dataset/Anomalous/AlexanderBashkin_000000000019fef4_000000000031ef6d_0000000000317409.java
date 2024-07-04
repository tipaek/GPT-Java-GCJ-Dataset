import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String path = tokenizer.nextToken();
            processTestCase(i, x, y, path);
        }
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void processTestCase(int testCaseNumber, int startX, int startY, String path) {
        Map<Coordinate, List<Integer>> pathCoordinates = new HashMap<>();
        int x = startX, y = startY;
        
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'S': y--; break;
                case 'N': y++; break;
                case 'W': x--; break;
                case 'E': x++; break;
            }
            pathCoordinates.computeIfAbsent(new Coordinate(x, y), k -> new ArrayList<>()).add(i + 1);
        }

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        Map<Coordinate, Integer> distances = new HashMap<>();
        distances.put(new Coordinate(0, 0), 0);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int currentDistance = distances.get(current);
            if (currentDistance == path.length()) continue;

            for (int[] direction : DIRECTIONS) {
                Coordinate next = new Coordinate(current.x + direction[0], current.y + direction[1]);
                if (!distances.containsKey(next)) {
                    distances.put(next, currentDistance + 1);
                    queue.add(next);
                }
            }
        }

        int result = -1;
        for (Map.Entry<Coordinate, List<Integer>> entry : pathCoordinates.entrySet()) {
            if (!distances.containsKey(entry.getKey())) continue;
            int distance = distances.get(entry.getKey());
            for (int step : entry.getValue()) {
                if (distance <= step && (result == -1 || step < result)) {
                    result = step;
                }
            }
        }

        System.out.printf("Case #%d: %s\n", testCaseNumber, (result == -1 ? "IMPOSSIBLE" : result));
    }

    static class Coordinate {
        final int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coordinate that = (Coordinate) obj;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }
}