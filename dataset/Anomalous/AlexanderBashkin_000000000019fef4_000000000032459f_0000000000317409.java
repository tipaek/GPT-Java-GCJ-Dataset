import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final int NORM = 1002;

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    private void run() throws IOException {
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

    private void processTestCase(int testCaseNumber, int startX, int startY, String path) {
        Map<Coordinate, List<Integer>> pathMap = new HashMap<>();
        int x = startX, y = startY;

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

        int candidate = -1;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int currentDistance = distanceMap.get(current);

            if (pathMap.containsKey(current)) {
                List<Integer> times = pathMap.get(current);
                if (currentDistance <= times.get(times.size() - 1)) {
                    for (int time : times) {
                        if (currentDistance <= time && (candidate == -1 || time < candidate)) {
                            candidate = time;
                            break;
                        }
                    }
                }
            }

            if (currentDistance == path.length() || (candidate != -1 && currentDistance > candidate)) continue;

            for (int[] direction : DIRECTIONS) {
                Coordinate next = new Coordinate(current.x + direction[0], current.y + direction[1]);
                if (!distanceMap.containsKey(next)) {
                    distanceMap.put(next, currentDistance + 1);
                    queue.add(next);
                }
            }
        }

        int result = -1;
        for (Map.Entry<Coordinate, List<Integer>> entry : pathMap.entrySet()) {
            if (!distanceMap.containsKey(entry.getKey())) continue;
            int distance = distanceMap.get(entry.getKey());
            for (int time : entry.getValue()) {
                if (distance <= time && (result == -1 || time < result)) {
                    result = time;
                }
            }
        }

        System.out.printf("Case #%d: %s\n", testCaseNumber, (result == -1 ? "IMPOSSIBLE" : String.valueOf(result)));
    }

    static class Coordinate {
        final int x, y;
        final String key;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.key = x + "#" + y;
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
            return key.hashCode();
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }
}