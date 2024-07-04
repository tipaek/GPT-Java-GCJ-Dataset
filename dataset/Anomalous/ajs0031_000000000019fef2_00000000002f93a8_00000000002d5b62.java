import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = scanner.nextInt();
            List<int[]> coordinates = new LinkedList<>();
            for (int i = 0; i < numCases; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                coordinates.add(new int[]{x, y});
            }
            findPath("", 0, 0, 1);
            int caseNumber = 1;
            for (int[] coordinate : coordinates) {
                System.out.print("CASE #" + caseNumber + ": ");
                caseNumber++;
                int x = coordinate[0];
                int y = coordinate[1];
                String key = x + "," + y;
                if (!map.containsKey(key)) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    System.out.println(map.get(key));
                }
            }
        }
    }

    private static void findPath(String path, int x, int y, int dist) {
        if (dist > 128) {
            return;
        }
        String key = x + "," + y;
        if (!map.containsKey(key) || path.length() < map.get(key).length()) {
            map.put(key, path);
        }
        findPath(path + "N", x, y + dist, dist * 2);
        findPath(path + "S", x, y - dist, dist * 2);
        findPath(path + "E", x + dist, y, dist * 2);
        findPath(path + "W", x - dist, y, dist * 2);
    }
}