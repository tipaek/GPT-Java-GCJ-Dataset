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
        for (int t = 1; t <= testCases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String path = tokenizer.nextToken();
            processTestCase(t, x, y, path);
        }
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void processTestCase(int caseNumber, int startX, int startY, String path) {
        Map<Coordinate, List<Integer>> pathMap = new HashMap<>();
        int x = startX;
        int y = startY;
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'S': y--; break;
                case 'N': y++; break;
                case 'W': x--; break;
                case 'E': x++; break;
            }
            pathMap.computeIfAbsent(new Coordinate(x, y), k -> new ArrayList<>()).add(i + 1);
        }

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        Map<Coordinate, Integer> distanceMap = new HashMap<>();
        distanceMap.put(new Coordinate(0, 0), 0);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int currentDistance = distanceMap.get(current);
            if (currentDistance == path.length()) continue;

            for (int[] direction : DIRECTIONS) {
                Coordinate neighbor = new Coordinate(current.x + direction[0], current.y + direction[1]);
                if (!distanceMap.containsKey(neighbor)) {
                    distanceMap.put(neighbor, currentDistance + 1);
                    queue.add(neighbor);
                }
            }
        }

        int result = -1;
        for (Map.Entry<Coordinate, List<Integer>> entry : pathMap.entrySet()) {
            if (!distanceMap.containsKey(entry.getKey())) continue;
            int distance = distanceMap.get(entry.getKey());
            for (int pathIndex : entry.getValue()) {
                if (distance <= pathIndex && (result == -1 || pathIndex < result)) {
                    result = pathIndex;
                }
            }
        }

        System.out.printf("Case #%d: %s\n", caseNumber, (result == -1 ? "IMPOSSIBLE" : result));
    }

    static class Coordinate {
        final int x, y;
        private final String key;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.key = x + "#" + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coordinate other = (Coordinate) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }
}