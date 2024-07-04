import java.io.*;
import java.util.*;

public class Solution {

    // Directions: East, North, West, South
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static final Map<Character, Integer> directionMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeDirectionMap();

        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String tour = scanner.next();

            int currentX = 0;
            int currentY = 0;
            int result = Integer.MAX_VALUE;

            for (int i = 0; i < tour.length(); i++) {
                char direction = tour.charAt(i);
                startX += dx[directionMap.get(direction)];
                startY += dy[directionMap.get(direction)];

                if (currentX == startX && currentY == startY) {
                    result = i + 1;
                    break;
                }

                if (direction == 'E' || direction == 'W') {
                    if (currentY < startY) {
                        currentY++;
                    } else {
                        currentX++;
                    }
                } else {
                    if (currentX < startX) {
                        currentX++;
                    } else {
                        if (currentY < startY) {
                            currentY++;
                        } else {
                            currentY--;
                        }
                    }
                }

                if (currentX == startX && currentY == startY) {
                    result = i + 1;
                    break;
                }
            }

            System.out.print("Case #" + test + ": ");
            if (result == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    private static void initializeDirectionMap() {
        directionMap.put('E', 0);
        directionMap.put('N', 1);
        directionMap.put('W', 2);
        directionMap.put('S', 3);
    }
}