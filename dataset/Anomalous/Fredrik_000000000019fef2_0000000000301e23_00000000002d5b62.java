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

            if (Math.abs(coords[0]) == Math.abs(coords[1])) {
                System.out.println(String.format("Case %d: IMPOSSIBLE", i));
                continue;
            }

            if (solveCase(i, coords)) {
                continue;
            }

            System.out.println(String.format("Case %d: IMPOSSIBLE", i));
        }
    }

    private static int[] readCoordinates(Scanner in) {
        int[] coords = new int[2];
        String[] splits = in.nextLine().split(" ");
        coords[0] = Integer.parseInt(splits[0]);
        coords[1] = Integer.parseInt(splits[1]);
        return coords;
    }

    private static boolean solveCase(int caseNumber, int[] coords) {
        Set<String> visited = new HashSet<>();
        Queue<Jump> queue = new LinkedList<>();
        queue.offer(new Jump(0, 0));

        while (!queue.isEmpty()) {
            Jump jump = queue.poll();
            int x = jump.position[0];
            int y = jump.position[1];
            int distance = (int) Math.pow(2, jump.level);
            visited.add(generateKey(x, y, distance));

            if (x == coords[0] && y == coords[1]) {
                System.out.println(String.format("Case %d: %s", caseNumber, jump.route.toString()));
                return true;
            }

            addNextJump(queue, visited, x - distance, y, jump, "W");
            addNextJump(queue, visited, x + distance, y, jump, "E");
            addNextJump(queue, visited, x, y - distance, jump, "S");
            addNextJump(queue, visited, x, y + distance, jump, "N");
        }
        return false;
    }

    private static void addNextJump(Queue<Jump> queue, Set<String> visited, int x, int y, Jump currentJump, String direction) {
        if (isWithinBounds(x, y) && !hasVisited(visited, x, y, (int) Math.pow(2, currentJump.level))) {
            Jump nextJump = new Jump(x, y, currentJump.level + 1, new StringBuilder(currentJump.route).append(direction));
            queue.offer(nextJump);
        }
    }

    private static boolean isWithinBounds(int x, int y) {
        return x >= -10000 && x <= 10000 && y >= -10000 && y <= 10000;
    }

    private static String generateKey(int x, int y, int distance) {
        return distance + "" + x + "" + y;
    }

    private static boolean hasVisited(Set<String> visited, int x, int y, int distance) {
        return visited.contains(generateKey(x, y, distance));
    }
}