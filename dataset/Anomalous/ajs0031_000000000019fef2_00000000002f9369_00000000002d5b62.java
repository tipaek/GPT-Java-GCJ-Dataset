import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Rd1BQ1 {
    private static final HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = scanner.nextInt();
            List<Integer> coordinates = new LinkedList<>();
            for (int i = 0; i < numCases; i++) {
                coordinates.add(scanner.nextInt());
                coordinates.add(scanner.nextInt());
            }
            findPath("", 0, 0, 1);
            processCases(coordinates);
        }
    }

    private static void processCases(List<Integer> coordinates) {
        int caseNumber = 1;
        while (!coordinates.isEmpty()) {
            int x = coordinates.remove(0);
            int y = coordinates.remove(0);
            System.out.print("CASE #" + caseNumber + ": ");
            caseNumber++;
            String key = x + "," + y;
            System.out.println(map.getOrDefault(key, "IMPOSSIBLE"));
        }
    }

    private static void findPath(String path, int x, int y, int dist) {
        if (dist > 128) {
            return;
        }
        String key = x + "," + y;
        map.merge(key, path, (existing, newPath) -> newPath.length() < existing.length() ? newPath : existing);

        findPath(path + "N", x, y + dist, dist * 2);
        findPath(path + "S", x, y - dist, dist * 2);
        findPath(path + "E", x + dist, y, dist * 2);
        findPath(path + "W", x - dist, y, dist * 2);
    }
}