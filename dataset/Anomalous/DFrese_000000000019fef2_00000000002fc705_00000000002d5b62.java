import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfTestCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        String[] coordinates = scanner.nextLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        String path = findPath(0, 10, new int[]{0, 0}, new int[]{x, y}, new StringBuilder(), null);

        System.out.printf("Case #%d: %s%n", testCaseNumber, path);
    }

    private static String findPath(int depth, int maxDepth, int[] currentPos, int[] targetPos, StringBuilder path, Character direction) {
        if (depth == maxDepth || (currentPos[0] == targetPos[0] && currentPos[1] == targetPos[1])) {
            if (currentPos[0] == targetPos[0] && currentPos[1] == targetPos[1]) {
                if (direction != null) path.append(direction);
                return path.toString();
            }
            return IMPOSSIBLE;
        }

        int jumpDistance = (int) Math.pow(2, depth);
        if (direction != null) path.append(direction);

        int[] north = {currentPos[0], currentPos[1] + jumpDistance};
        int[] south = {currentPos[0], currentPos[1] - jumpDistance};
        int[] west = {currentPos[0] - jumpDistance, currentPos[1]};
        int[] east = {currentPos[0] + jumpDistance, currentPos[1]};

        String pathNorth = findPath(depth + 1, maxDepth, north, targetPos, new StringBuilder(path), 'N');
        String pathSouth = findPath(depth + 1, maxDepth, south, targetPos, new StringBuilder(path), 'S');
        String pathWest = findPath(depth + 1, maxDepth, west, targetPos, new StringBuilder(path), 'W');
        String pathEast = findPath(depth + 1, maxDepth, east, targetPos, new StringBuilder(path), 'E');

        List<String> possiblePaths = new ArrayList<>();
        if (!IMPOSSIBLE.equals(pathNorth)) possiblePaths.add(pathNorth);
        if (!IMPOSSIBLE.equals(pathSouth)) possiblePaths.add(pathSouth);
        if (!IMPOSSIBLE.equals(pathWest)) possiblePaths.add(pathWest);
        if (!IMPOSSIBLE.equals(pathEast)) possiblePaths.add(pathEast);

        if (possiblePaths.isEmpty()) {
            return IMPOSSIBLE;
        }

        return possiblePaths.stream().min(Comparator.comparingInt(String::length)).orElse(IMPOSSIBLE);
    }
}