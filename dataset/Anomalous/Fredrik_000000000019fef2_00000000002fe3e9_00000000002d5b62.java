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

    public Jump(int x, int y, int level, StringBuilder route) {
        this(new int[]{x, y});
        this.level = level;
        this.route = route;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= testCases; i++) {
            int[] coords = readCoordinates(in);

            Set<String> visited = new HashSet<>();
            Queue<Jump> queue = new LinkedList<>();
            queue.offer(new Jump(0, 0));

            while (!queue.isEmpty()) {
                Jump jump = queue.poll();

                int x = jump.position[0];
                int y = jump.position[1];
                int distance = (int) Math.pow(2, jump.level);

                visited.add(getVisitedKey(x, y, distance));

                if (x == coords[0] && y == coords[1]) {
                    System.out.printf("Case %d: %s%n", i, jump.route.toString());
                    continue;
                }

                addJump(queue, visited, x - distance, y, jump, "W");
                addJump(queue, visited, x + distance, y, jump, "E");
                addJump(queue, visited, x, y - distance, jump, "S");
                addJump(queue, visited, x, y + distance, jump, "N");
            }

            System.out.printf("Case %d: IMPOSSIBLE%n", i);
        }
    }

    private static int[] readCoordinates(Scanner in) {
        String[] splits = in.nextLine().split(" ");
        return new int[]{Integer.parseInt(splits[0]), Integer.parseInt(splits[1])};
    }

    private static boolean hasVisited(Set<String> visited, int x, int y, int distance) {
        return visited.contains(getVisitedKey(x, y, distance));
    }

    private static String getVisitedKey(int x, int y, int distance) {
        return distance + "" + x + "" + y;
    }

    private static void addJump(Queue<Jump> queue, Set<String> visited, int x, int y, Jump jump, String direction) {
        int distance = (int) Math.pow(2, jump.level);
        if (x >= -100 && x <= 100 && y >= -100 && y <= 100 && !hasVisited(visited, x, y, distance)) {
            Jump newJump = new Jump(x, y, jump.level + 1, new StringBuilder(jump.route).append(direction));
            queue.offer(newJump);
        }
    }
}