import java.util.*;
import java.io.*;

class Jump {
    StringBuilder route;
    int[] position;
    int level;

    public Jump(int[] position) {
        this.route = new StringBuilder();
        this.position = position;
        this.level = 0;
    }

    public Jump(int x, int y) {
        this(new int[]{x, y});
    }

    public Jump(int x, int y, int level, String route) {
        this(new int[]{x, y});
        this.level = level;
        this.route = new StringBuilder(route);
    }
}

public class Solution {
    private static final int[] HORIZONTAL = {1, 0, -1, 0};
    private static final int[] VERTICAL = {0, 1, 0, -1};
    private static final char[] DIRECTIONS = {'E', 'N', 'W', 'S'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int[] target = readCoordinates(scanner);
            int maxJumps = Math.max(Math.abs(target[0]), Math.abs(target[1]));

            Set<String> visited = new HashSet<>();
            Queue<Jump> queue = new LinkedList<>();
            queue.offer(new Jump(0, 0));

            while (!queue.isEmpty()) {
                Jump currentJump = queue.poll();
                int x = currentJump.position[0];
                int y = currentJump.position[1];

                if (x == target[0] && y == target[1]) {
                    System.out.println(String.format("Case %d: %s", i, currentJump.route.toString()));
                    continue;
                }

                int distance = (int) Math.pow(2, currentJump.level);
                visited.add(generateVisitedKey(distance, x, y));

                if (currentJump.level <= maxJumps) {
                    for (int j = 0; j < 4; j++) {
                        int nx = x + HORIZONTAL[j] * distance;
                        int ny = y + VERTICAL[j] * distance;

                        if (!hasVisited(visited, nx, ny, distance)) {
                            Jump nextJump = new Jump(nx, ny, currentJump.level + 1, currentJump.route.toString());
                            nextJump.route.append(DIRECTIONS[j]);
                            queue.offer(nextJump);
                        }
                    }
                }
            }

            System.out.println(String.format("Case %d: IMPOSSIBLE", i));
        }
    }

    private static int[] readCoordinates(Scanner scanner) {
        String[] splits = scanner.nextLine().split(" ");
        return new int[]{Integer.parseInt(splits[0]), Integer.parseInt(splits[1])};
    }

    private static boolean hasVisited(Set<String> visited, int x, int y, int distance) {
        return visited.contains(generateVisitedKey(distance, x, y));
    }

    private static String generateVisitedKey(int distance, int x, int y) {
        return distance + "" + x + "" + y;
    }
}