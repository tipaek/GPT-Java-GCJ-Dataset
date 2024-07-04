import java.util.*;

class Jump {
    StringBuilder route;
    int[] position;
    int level = 0;

    public Jump(int[] position) {
        route = new StringBuilder();
        this.position = position;
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
        Scanner scanner = new Scanner(System.in);
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
                int distance = (int) Math.pow(2, currentJump.level);

                visited.add(distance + "" + x + "" + y);

                if (x == target[0] && y == target[1]) {
                    System.out.printf("Case %d: %s%n", i, currentJump.route.toString());
                    continue;
                }

                if (currentJump.level < maxJumps) {
                    addJump(queue, visited, x - distance, y, currentJump, 'W');
                    addJump(queue, visited, x + distance, y, currentJump, 'E');
                    addJump(queue, visited, x, y - distance, currentJump, 'S');
                    addJump(queue, visited, x, y + distance, currentJump, 'N');
                }
            }

            System.out.printf("Case %d: IMPOSSIBLE%n", i);
        }
    }

    private static int[] readCoordinates(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        return new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
    }

    private static void addJump(Queue<Jump> queue, Set<String> visited, int x, int y, Jump currentJump, char direction) {
        int distance = (int) Math.pow(2, currentJump.level);
        if (!visited.contains(distance + "" + x + "" + y)) {
            StringBuilder newRoute = new StringBuilder(currentJump.route);
            newRoute.append(direction);
            queue.offer(new Jump(x, y, currentJump.level + 1, newRoute));
        }
    }
}