import java.util.*;
import java.io.*;

class Jump {
    StringBuilder route;
    int[] position;
    int level;

    public Jump(int[] position) {
        this(position, 0, new StringBuilder());
    }

    public Jump(int x, int y) {
        this(new int[]{x, y});
    }

    public Jump(int x, int y, int level, StringBuilder route) {
        this.position = new int[]{x, y};
        this.level = level;
        this.route = route;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int[] targetCoords = readCoordinates(scanner);

            Set<String> visited = new HashSet<>();
            Queue<Jump> queue = new LinkedList<>();
            queue.offer(new Jump(0, 0));

            while (!queue.isEmpty()) {
                Jump currentJump = queue.poll();
                int x = currentJump.position[0];
                int y = currentJump.position[1];
                visited.add(x + "," + y);

                if (x == targetCoords[0] && y == targetCoords[1]) {
                    System.out.printf("Case %d: %s%n", i, currentJump.route.toString());
                    continue;
                }

                int distance = (int) Math.pow(2, currentJump.level);

                addJumpToQueue(queue, visited, x - distance, y, currentJump, 'W');
                addJumpToQueue(queue, visited, x + distance, y, currentJump, 'E');
                addJumpToQueue(queue, visited, x, y - distance, currentJump, 'S');
                addJumpToQueue(queue, visited, x, y + distance, currentJump, 'N');
            }

            System.out.printf("Case %d: IMPOSSIBLE%n", i);
        }
    }

    private static int[] readCoordinates(Scanner scanner) {
        String[] splits = scanner.nextLine().split(" ");
        return new int[]{Integer.parseInt(splits[0]), Integer.parseInt(splits[1])};
    }

    private static void addJumpToQueue(Queue<Jump> queue, Set<String> visited, int x, int y, Jump currentJump, char direction) {
        if (isWithinBounds(x, y) && !hasVisited(visited, x, y)) {
            StringBuilder newRoute = new StringBuilder(currentJump.route).append(direction);
            queue.offer(new Jump(x, y, currentJump.level + 1, newRoute));
        }
    }

    private static boolean isWithinBounds(int x, int y) {
        return x >= -100 && x <= 100 && y >= -100 && y <= 100;
    }

    private static boolean hasVisited(Set<String> visited, int x, int y) {
        return visited.contains(x + "," + y);
    }
}