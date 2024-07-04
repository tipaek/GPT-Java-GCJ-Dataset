import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> directionsMap = new HashMap<>();
        directionsMap.put("0 0", "");

        Queue<String> coordinatesQueue = new LinkedList<>();
        coordinatesQueue.add("0 0");

        int stepCount = 1;
        int stepSize = 1;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < stepCount; j++) {
                String[] coordinates = coordinatesQueue.poll().split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                updateDirectionsMap(directionsMap, coordinatesQueue, x + stepSize, y, directionsMap.get(x + " " + y) + "E");
                updateDirectionsMap(directionsMap, coordinatesQueue, x - stepSize, y, directionsMap.get(x + " " + y) + "W");
                updateDirectionsMap(directionsMap, coordinatesQueue, x, y + stepSize, directionsMap.get(x + " " + y) + "N");
                updateDirectionsMap(directionsMap, coordinatesQueue, x, y - stepSize, directionsMap.get(x + " " + y) + "S");
            }
            stepCount *= 4;
            stepSize *= 2;
        }

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            String result = directionsMap.getOrDefault(targetX + " " + targetY, "IMPOSSIBLE");
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static void updateDirectionsMap(Map<String, String> directionsMap, Queue<String> coordinatesQueue, int x, int y, String direction) {
        String key = x + " " + y;
        if (!directionsMap.containsKey(key)) {
            directionsMap.put(key, direction);
            coordinatesQueue.add(key);
        }
    }
}