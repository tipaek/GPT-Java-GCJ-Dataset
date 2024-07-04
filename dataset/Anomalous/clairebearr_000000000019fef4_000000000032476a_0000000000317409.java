import java.io.*;
import java.util.*;

public class Solution {

    // Directions: East, North, West, South
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static final HashMap<Character, Integer> directionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        initializeDirectionMap();
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String tour = scanner.next();
            boolean isPossible = false;

            for (int i = 0; i <= tour.length(); i++) {
                if (Math.abs(x) + Math.abs(y) <= i) {
                    System.out.println("Case #" + testCase + ": " + i);
                    isPossible = true;
                    break;
                }
                if (i < tour.length()) {
                    char direction = tour.charAt(i);
                    x += dx[directionMap.get(direction)];
                    y += dy[directionMap.get(direction)];
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
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