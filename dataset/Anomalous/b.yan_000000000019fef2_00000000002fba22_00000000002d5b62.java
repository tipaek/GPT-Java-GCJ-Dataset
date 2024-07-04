import java.util.*;
import java.io.*;

public class Solution {
    private static final HashMap<Coordinate, String> coordinateToPathMap = new HashMap<>();
    private static final List<Coordinate> coordinatesList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        generatePaths(0, 0, 0, "");
        
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = findShortestPath(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static void generatePaths(int x, int y, int step, String path) {
        if (Math.abs(x) > 100 || Math.abs(y) > 100) {
            return;
        }
        Coordinate coordinate = new Coordinate(x, y);
        coordinateToPathMap.put(coordinate, path);
        coordinatesList.add(coordinate);
        
        int moveDistance = (int) Math.pow(2, step);
        generatePaths(x + moveDistance, y, step + 1, path + 'E');
        generatePaths(x - moveDistance, y, step + 1, path + 'W');
        generatePaths(x, y + moveDistance, step + 1, path + 'N');
        generatePaths(x, y - moveDistance, step + 1, path + 'S');
    }

    private static String findShortestPath(int x, int y) {
        List<Coordinate> matchingCoordinates = new ArrayList<>();
        int minPathLength = Integer.MAX_VALUE;
        boolean pathFound = false;

        for (Coordinate coordinate : coordinatesList) {
            if (coordinate.x == x && coordinate.y == y) {
                matchingCoordinates.add(coordinate);
                String path = coordinateToPathMap.get(coordinate);
                if (path.length() < minPathLength) {
                    minPathLength = path.length();
                }
                pathFound = true;
            }
        }

        if (pathFound) {
            for (Coordinate coordinate : matchingCoordinates) {
                String path = coordinateToPathMap.get(coordinate);
                if (path.length() == minPathLength) {
                    return path;
                }
            }
        }

        return "IMPOSSIBLE";
    }

    static class Coordinate {
        public final int x;
        public final int y;

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
    }
}