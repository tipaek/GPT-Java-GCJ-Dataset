import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<String, String> reachable = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        findReachablePoints(4);

        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            String[] coords = reader.readLine().split(" ");
            int[] destination = new int[2];
            destination[0] = Integer.parseInt(coords[0]);
            destination[1] = Integer.parseInt(coords[1]);

            String solution = findSolution(destination);

            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static void findReachablePoints(int size) {
        int maxDepth = findMaxDepth(size);
        String path = "";
        reach(1, 0, maxDepth, path + "E", size);
        reach(0, 1, maxDepth, path + "N", size);
        reach(-1, 0, maxDepth, path + "W", size);
        reach(0, -1, maxDepth, path + "S", size);
    }

    private static void reach(int x, int y, int depth, String path, int size) {
        if (x > size || x < -size || y > size || y < -size) {
            return;
        }
        String key = x + "x" + y;
        if (reachable.containsKey(key)) {
            String currentPath = reachable.get(key);
            if (path.length() < currentPath.length()) {
                reachable.put(key, path);
            }
        } else {
            reachable.put(key, path);
        }
        if (depth <= 0) {
            return;
        }
        int diff = (int) Math.pow(2, path.length());
        reach(x + diff, y, depth - 1, path + "E", size);
        reach(x, y + diff, depth - 1, path + "N", size);
        reach(x - diff, y, depth - 1, path + "W", size);
        reach(x, y - diff, depth - 1, path + "S", size);
    }

    private static int findMaxDepth(int size) {
        int width = 2 * size + 1;
        int maxDepth = 0;
        while (Math.pow(2, maxDepth) <= width) {
            maxDepth++;
        }
        return maxDepth - 1;
    }

    private static String findSolution(int[] destination) {
        String key = destination[0] + "x" + destination[1];
        if (reachable.containsKey(key)) {
            return reachable.get(key);
        }
        return "IMPOSSIBLE";
    }
}