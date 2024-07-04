import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int t = Integer.parseInt(reader.readLine());
        for (int tt = 0; tt < t; tt++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            Point start = new Point(x, y);

            Map<Integer, Map<Integer, Point>> parentMap = new HashMap<>();
            Map<Integer, Map<Integer, Character>> directionMap = new HashMap<>();
            Deque<Point> queue = new ArrayDeque<>();
            queue.add(start);
            boolean found = false;

            while (!queue.isEmpty() && !found) {
                Point current = queue.poll();
                if (current.x == 0 && current.y == 0) {
                    found = true;
                    break;
                }

                int modX = Math.abs(current.x % 2);
                int modY = Math.abs(current.y % 2);

                if (modX == 1 && modY == 1) {
                    continue;
                }

                if (modX == 1) {
                    addNextPoint(queue, parentMap, directionMap, current, (current.x - 1) / 2, current.y / 2, 'E');
                    addNextPoint(queue, parentMap, directionMap, current, (current.x + 1) / 2, current.y / 2, 'W');
                } else if (modY == 1) {
                    addNextPoint(queue, parentMap, directionMap, current, current.x / 2, (current.y - 1) / 2, 'N');
                    addNextPoint(queue, parentMap, directionMap, current, current.x / 2, (current.y + 1) / 2, 'S');
                }
            }

            if (found) {
                StringBuilder path = new StringBuilder();
                Point current = new Point(0, 0);
                while (current.x != start.x || current.y != start.y) {
                    char direction = directionMap.get(current.x).get(current.y);
                    path.append(direction);
                    current = parentMap.get(current.x).get(current.y);
                }
                writer.printf("Case #%d: %s\n", tt + 1, path.reverse().toString());
            } else {
                writer.printf("Case #%d: IMPOSSIBLE\n", tt + 1);
            }
        }

        reader.close();
        writer.close();
    }

    private static void addNextPoint(Deque<Point> queue, Map<Integer, Map<Integer, Point>> parentMap,
                                     Map<Integer, Map<Integer, Character>> directionMap, Point current,
                                     int nextX, int nextY, char direction) {
        if (!isVisited(parentMap, nextX, nextY)) {
            queue.add(new Point(nextX, nextY));
            put(parentMap, nextX, nextY, current);
            put(directionMap, nextX, nextY, direction);
        }
    }

    private static boolean isVisited(Map<Integer, Map<Integer, Point>> map, int x, int y) {
        return map.containsKey(x) && map.get(x).containsKey(y);
    }

    private static void put(Map<Integer, Map<Integer, Point>> map, int x, int y, Point p) {
        map.computeIfAbsent(x, k -> new HashMap<>()).put(y, p);
    }

    private static void put(Map<Integer, Map<Integer, Character>> map, int x, int y, char c) {
        map.computeIfAbsent(x, k -> new HashMap<>()).put(y, c);
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}