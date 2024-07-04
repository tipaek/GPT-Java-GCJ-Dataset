import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }

    private static void processTestCase(Scanner scanner, int caseNumber) {
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        String path = scanner.nextLine().trim();

        Map<Integer, Coordinates> coordinatesMap = new HashMap<>();
        coordinatesMap.put(0, new Coordinates(startX, startY));

        int currentX = startX;
        int currentY = startY;

        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'N':
                    currentY++;
                    break;
                case 'S':
                    currentY--;
                    break;
                case 'E':
                    currentX++;
                    break;
                case 'W':
                    currentX--;
                    break;
            }
            coordinatesMap.put(i + 1, new Coordinates(currentX, currentY));
        }

        int result = -1;
        for (int i = 1; i < coordinatesMap.size(); i++) {
            Coordinates target = coordinatesMap.get(i);
            int tempX = 0, tempY = 0;
            boolean reached = false;

            for (int j = 0; j < i; j++) {
                if (tempX < target.x) {
                    tempX++;
                } else if (tempX > target.x) {
                    tempX--;
                } else if (tempY < target.y) {
                    tempY++;
                } else if (tempY > target.y) {
                    tempY--;
                }

                if (tempX == target.x && tempY == target.y) {
                    reached = true;
                    result = i;
                    break;
                }
            }

            if (reached) {
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + (result == -1 ? "IMPOSSIBLE" : result));
    }

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}