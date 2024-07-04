import java.io.*;
import java.util.*;

public class Solution {

    // Directions: East, North, West, South
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static final Map<Character, Integer> directionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        directionMap.put('E', 0);
        directionMap.put('N', 1);
        directionMap.put('W', 2);
        directionMap.put('S', 3);

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int px = scanner.nextInt();
            int py = scanner.nextInt();
            String tour = scanner.next();
            int mx = 0;
            int my = 0;
            int result = Integer.MAX_VALUE;

            for (int i = 0; i < tour.length(); i++) {
                char direction = tour.charAt(i);
                px += dx[directionMap.get(direction)];
                py += dy[directionMap.get(direction)];

                if (mx == px && my == py) {
                    result = i + 1;
                    break;
                }

                if (direction == 'E' || direction == 'W') {
                    if (my < py) {
                        my++;
                    } else {
                        mx++;
                    }
                } else {
                    if (mx < px) {
                        mx++;
                    } else {
                        if (my < px) {
                            my++;
                        } else {
                            my--;
                        }
                    }
                }

                if (mx == px && my == py) {
                    result = i + 1;
                    break;
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (result == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }
}